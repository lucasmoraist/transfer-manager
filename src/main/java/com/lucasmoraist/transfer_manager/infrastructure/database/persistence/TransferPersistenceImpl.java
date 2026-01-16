package com.lucasmoraist.transfer_manager.infrastructure.database.persistence;

import com.lucasmoraist.transfer_manager.application.gateway.TransferPersistence;
import com.lucasmoraist.transfer_manager.domain.model.Transfer;
import com.lucasmoraist.transfer_manager.infrastructure.database.entity.TransferEntity;
import com.lucasmoraist.transfer_manager.infrastructure.database.repository.TransferRepository;
import com.lucasmoraist.transfer_manager.infrastructure.mapper.TransferMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

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

}
