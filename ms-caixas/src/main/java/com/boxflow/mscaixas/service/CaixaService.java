package com.boxflow.mscaixas.service;

import com.boxflow.mscaixas.entity.Caixa;
import com.boxflow.mscaixas.repository.CaixaRepository;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.boxflow.mscaixas.config.RabbitMQConfig;
import java.util.List;

@Service
public class CaixaService {

    private final CaixaRepository caixaRepository;
    private final RabbitTemplate rabbitTemplate;

    public CaixaService(CaixaRepository caixaRepository, RabbitTemplate rabbitTemplate) {
        this.caixaRepository = caixaRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    public Caixa salvar(Caixa caixa) {

        Caixa salva = caixaRepository.save(caixa);

        String mensagem = "Caixa do mês " + salva.getMesReferencia() + " foi registrada para o cliente ID: " + salva.getClienteId();

        System.out.println("Publicando mensagem na fila: " + mensagem);

        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NOTIFICACOES, mensagem);

        return salva;


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
