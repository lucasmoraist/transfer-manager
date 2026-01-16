package com.lucasmoraist.transfer_manager.infrastructure.config.usecases;

import com.lucasmoraist.transfer_manager.application.gateway.MessageGateway;
import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.application.gateway.UserGateway;
import com.lucasmoraist.transfer_manager.application.usecases.transfer.ExecuteTransferCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TransferUseCase {

    private final UserGateway userGateway;
    private final TransferPersistence transferPersistence;
    private final MessageGateway messageGateway;

    @Bean
    public ExecuteTransferCase executeTransferCase() {
        return new ExecuteTransferCase(
                userGateway,
                transferPersistence,
                messageGateway
        );
    }

}
