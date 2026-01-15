package com.lucasmoraist.transfer_manager.domain.message;

import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentMessage(
        UUID transferId,
        Payer payer,
        Payee payee,
        BigDecimal amount,
        PaymentStatus status,
        LocalDateTime createdAt,
        Payflow payflow
) {

}
