package com.lucasmoraist.transfer_manager.infrastructure.message;

import com.lucasmoraist.transfer_manager.application.gateway.MessageGateway;
import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;
import com.lucasmoraist.transfer_manager.infrastructure.queue.producer.TransferProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@Log4j2
@Component
@RequiredArgsConstructor
public class MessageGatewayImpl implements MessageGateway {

    private static final String TO_WALLET_CORE = "toProcessTransfer-out-0";
    private static final String WALLET_ROUTING_KEY = "walletRoutingKey";
    private static final String TRACE_ID_HEADER = "traceId";
    private static final String TRANSFER_CREATED = "transfer.created";

    private final TransferProducer transferProducer;

    @Override
    public void sendToWalletCore(PaymentMessage message) {
        transferProducer.sendMessage(withPayload(message)
                .setHeader(WALLET_ROUTING_KEY, TRANSFER_CREATED)
                .setHeader(TRACE_ID_HEADER, message.payflow().traceId())
                .build(), TO_WALLET_CORE);
    }

}
