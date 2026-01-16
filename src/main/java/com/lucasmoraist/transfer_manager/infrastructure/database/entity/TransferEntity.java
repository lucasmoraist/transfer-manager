package com.lucasmoraist.transfer_manager.infrastructure.database.entity;

import com.lucasmoraist.transfer_manager.domain.enums.PaymentStatus;
import com.lucasmoraist.transfer_manager.domain.message.Payee;
import com.lucasmoraist.transfer_manager.domain.message.Payer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transfers")
public class TransferEntity {

    @Id
    private String id;
    private Payer payer;
    private Payee payee;
    private BigDecimal amount;
    private PaymentStatus status;
    private String statusReason;
    private LocalDateTime createdAt;
    private LocalDateTime processedAt;

}
