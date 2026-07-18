package com.boxflow.msnotificacoes.listener;

import com.boxflow.msnotificacoes.config.RabbitMQConfig;
import com.boxflow.msnotificacoes.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificacoesListener {

    private final EmailService emailService;

    public NotificacoesListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @Value("${aws.ses.destinatario}")
    private String destinatario;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NOTIFICACOES)
    public void receberNotificacao(String mensagem) {
        System.out.println("Mensagem Recebida: " + mensagem);
        emailService.enviarEmail(
                destinatario,
                "BoxFlow - Sua Caixa foi enviada!",
                mensagem
        );
    }

}
