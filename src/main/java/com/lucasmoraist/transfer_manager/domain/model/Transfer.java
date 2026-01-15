package com.lucasmoraist.transfer_manager.domain.model;

import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Transfer(
        UUID id,
        UUID payerId,
        UUID payeeId,
        BigDecimal amount,
        PaymentStatus status,
        LocalDateTime createdAt,
        LocalDateTime processedAt
) {

}
