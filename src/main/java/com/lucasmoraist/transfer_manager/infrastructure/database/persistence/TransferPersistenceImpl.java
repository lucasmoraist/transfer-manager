package com.lucasmoraist.transfer_manager.infrastructure.database.persistence;

import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.domain.message.PaymentMessage;
import com.lucasmoraist.transfer_manager.domain.model.Transfer;
import com.lucasmoraist.transfer_manager.infrastructure.database.entity.TransferEntity;
import com.lucasmoraist.transfer_manager.infrastructure.database.repository.TransferRepository;
import com.lucasmoraist.transfer_manager.infrastructure.mapper.TransferMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Log4j2
@Component
@RequiredArgsConstructor
public class TransferPersistenceImpl implements TransferPersistence {

    private final TransferRepository transferRepository;

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity entity = TransferMapper.toEntity(transfer);
        TransferEntity savedEntity = this.transferRepository.save(entity);
        return TransferMapper.toDomain(savedEntity);
    }

    @Override
    public void updatePayment(PaymentMessage paymentMessage) {
        TransferEntity entity = this.transferRepository.findById(paymentMessage.transferId())
                .orElseThrow(() -> new IllegalArgumentException("Transfer not found with id: " + paymentMessage.transferId()));

        entity.setStatus(paymentMessage.status());
        entity.setProcessedAt(LocalDateTime.now());

        this.transferRepository.save(entity);
    }

}
