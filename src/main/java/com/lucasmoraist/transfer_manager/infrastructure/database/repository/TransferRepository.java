package com.lucasmoraist.transfer_manager.infrastructure.database.repository;

import com.lucasmoraist.transfer_manager.infrastructure.database.entity.TransferEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransferRepository extends MongoRepository<TransferEntity, UUID> {

}
