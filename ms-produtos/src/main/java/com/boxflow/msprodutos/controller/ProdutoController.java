package com.boxflow.msprodutos.controller;

import com.boxflow.msprodutos.entity.Produto;
import com.boxflow.msprodutos.service.ProdutoService;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {

        Produto salvo =  produtoService.salvar(produto);
        return ResponseEntity.status(201).body(salvo);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        produtoService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}
