package com.boxflow.msclientes.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NOTIFICACOES = "notificacoes.queue";

    @Bean
    public Queue queueNotificacoes() {
        return new Queue(QUEUE_NOTIFICACOES, true);
    }



}
