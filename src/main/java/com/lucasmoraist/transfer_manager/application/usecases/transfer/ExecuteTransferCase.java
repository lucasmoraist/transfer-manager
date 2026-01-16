package com.lucasmoraist.transfer_manager.application.usecases.transfer;

import com.lucasmoraist.transfer_manager.application.gateway.MessageGateway;
import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.application.gateway.UserGateway;
import com.lucasmoraist.transfer_manager.application.utils.TraceId;
import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;
import com.lucasmoraist.transfer_manager.domain.message.Payee;
import com.lucasmoraist.transfer_manager.domain.message.Payer;
import com.lucasmoraist.transfer_manager.domain.message.Payflow;
import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;
import com.lucasmoraist.transfer_manager.domain.model.Transfer;
import com.lucasmoraist.transfer_manager.domain.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ExecuteTransferCase {

    private final UserGateway userGateway;
    private final TransferPersistence transferPersistence;
    private final MessageGateway messageGateway;

    public ExecuteTransferCase(UserGateway userGateway,
                               TransferPersistence transferPersistence,
                               MessageGateway messageGateway) {
        this.userGateway = userGateway;
        this.transferPersistence = transferPersistence;
        this.messageGateway = messageGateway;
    }

    public Transfer execute(UUID payerId, UUID payeeId, BigDecimal amount) {
        Payer payer = getPayerById(payerId);
        Payee payee = getPayeeById(payeeId);

        Transfer transfer = new Transfer(
                null,
                payer,
                payee,
                amount,
                PaymentStatus.PENDING,
                LocalDateTime.now(),
                null
        );

        Transfer transferSaved = this.transferPersistence.save(transfer);

        PaymentMessage paymentMessage = new PaymentMessage(
                transferSaved.id(),
                payer,
                payee,
                amount,
                PaymentStatus.PENDING,
                transferSaved.createdAt(),
                new Payflow(TraceId.fromTodayAndUuid(transferSaved.id()))
        );

        this.messageGateway.sendToWalletCore(paymentMessage);

        return transferSaved;
    }

    private Payer getPayerById(UUID userId) {
        User user = this.userGateway.findUserById(userId);
        return new Payer(
                user.id().toString(),
                user.name(),
                user.email()
        );
    }

    private Payee getPayeeById(UUID userId) {
        User user = this.userGateway.findUserById(userId);
        return new Payee(
                user.id().toString(),
                user.name(),
                user.email()
        );
    }

}
