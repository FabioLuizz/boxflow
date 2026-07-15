package com.boxflow.mscaixas.service;

import com.boxflow.mscaixas.entity.Caixa;
import com.boxflow.mscaixas.repository.CaixaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;

    public CaixaService(CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }
    public Caixa salvar(Caixa caixa) {
        return caixaRepository.save(caixa);
    }

    public List<Caixa> listarTodos() {
        return caixaRepository.findAll();
    }

    public Caixa buscarPorId(Long id) {
        return caixaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caixa não encontrada com o id"));
    }

    public void deletar(Long id) {
        caixaRepository.deleteById(id);
    }

}
