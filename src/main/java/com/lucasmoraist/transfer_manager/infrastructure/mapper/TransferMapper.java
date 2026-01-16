package com.lucasmoraist.transfer_manager.infrastructure.mapper;

import com.lucasmoraist.transfer_manager.domain.model.Transfer;
import com.lucasmoraist.transfer_manager.infrastructure.database.entity.TransferEntity;

public final class TransferMapper {

    private TransferMapper() {
    }

    public static TransferEntity toEntity(Transfer transfer) {
        return new TransferEntity(
                transfer.id(),
                transfer.payer(),
                transfer.payee(),
                transfer.amount(),
                transfer.status(),
                transfer.createdAt(),
                transfer.processedAt()
        );
    }

    public static Transfer toDomain(TransferEntity entity) {
        return new Transfer(
                entity.getId(),
                entity.getPayer(),
                entity.getPayee(),
                entity.getAmount(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getProcessedAt()
        );
    }

}
