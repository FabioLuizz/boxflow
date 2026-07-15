package com.boxflow.mscaixas.controller;

import com.boxflow.mscaixas.entity.Caixa;
import com.boxflow.mscaixas.service.CaixaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixas")
public class CaixaController {

    private final CaixaService caixaService;

    public CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @PostMapping
    public ResponseEntity<Caixa> criar(@RequestBody Caixa caixa) {
        Caixa salvo = caixaService.salvar(caixa);
        return ResponseEntity.status(201).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Caixa>> listarTodos() {
        return ResponseEntity.ok(caixaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caixa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caixaService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        caixaService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}
