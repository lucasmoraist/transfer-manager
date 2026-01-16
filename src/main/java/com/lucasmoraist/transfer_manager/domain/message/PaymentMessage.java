package com.lucasmoraist.transfer_manager.domain.message;

import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PaymentMessage(
        String transferId,
        Payer payer,
        Payee payee,
        BigDecimal amount,
        PaymentStatus status,
        String statusReason,
        LocalDateTime createdAt,
        Payflow payflow
) {

}
