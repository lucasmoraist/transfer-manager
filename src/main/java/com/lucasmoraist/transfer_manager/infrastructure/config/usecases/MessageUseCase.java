package com.lucasmoraist.transfer_manager.infrastructure.config.usecases;

import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.application.messages.OrchestrationMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageUseCase {

    @Bean
    public OrchestrationMessage orchestrationMessageBean(TransferPersistence transferPersistence) {
        return new OrchestrationMessage(transferPersistence);
    }

}
