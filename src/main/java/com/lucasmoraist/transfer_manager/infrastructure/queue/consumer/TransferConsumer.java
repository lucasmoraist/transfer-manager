package com.lucasmoraist.transfer_manager.infrastructure.queue.consumer;

import com.lucasmoraist.transfer_manager.application.messages.OrchestrationMessage;
import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
public class TransferConsumer {

    private final OrchestrationMessage orchestrationMessage;

    @Bean
    public Consumer<Message<PaymentMessage>> fromWalletProcessed() {
        return orchestrationMessage::execute;
    }

}
