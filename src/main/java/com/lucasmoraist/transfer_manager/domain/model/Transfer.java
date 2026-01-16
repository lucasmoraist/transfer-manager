package com.lucasmoraist.transfer_manager.domain.model;

import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;
import com.lucasmoraist.transfer_manager.domain.message.Payee;
import com.lucasmoraist.transfer_manager.domain.message.Payer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Transfer(
        String id,
        Payer payer,
        Payee payee,
        BigDecimal amount,
        PaymentStatus status,
        String statusReason,
        LocalDateTime createdAt,
        LocalDateTime processedAt
) {

}
