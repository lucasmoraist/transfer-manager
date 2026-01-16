package com.lucasmoraist.transfer_manager.application.gateway;

import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;

public interface MessageGateway {

    void sendToWalletCore(PaymentMessage paymentMessage);

}
