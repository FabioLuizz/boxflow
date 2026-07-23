package com.boxflow.mscaixas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitMQConfig {

    public static final String QUEUE_NOTIFICACOES = "nofiticacoes_queue";

    @Bean
    public Queue queuenoticacoes() {
        return new Queue(QUEUE_NOTIFICACOES, true);
    }

}
