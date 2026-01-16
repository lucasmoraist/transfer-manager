package com.lucasmoraist.transfer_manager.infrastructure.database.repository;

import com.lucasmoraist.transfer_manager.infrastructure.database.entity.TransferEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransferRepository extends MongoRepository<TransferEntity, String> {

}
