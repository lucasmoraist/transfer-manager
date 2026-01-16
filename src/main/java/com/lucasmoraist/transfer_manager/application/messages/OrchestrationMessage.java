package com.lucasmoraist.transfer_manager.application.messages;

import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;
import org.springframework.messaging.Message;

public class OrchestrationMessage {

    private final TransferPersistence transferPersistence;

    public OrchestrationMessage(TransferPersistence transferPersistence) {
        this.transferPersistence = transferPersistence;
    }

    public void execute(Message<PaymentMessage> paymentMessageMessage) {
        PaymentMessage paymentMessage = paymentMessageMessage.getPayload();
        this.transferPersistence.updatePayment(paymentMessage);
    }

}
