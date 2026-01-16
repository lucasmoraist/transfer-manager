package com.lucasmoraist.transfer_manager.application.gateway;

import com.lucasmoraist.transfer_manager.domain.model.Transfer;

public interface TransferPersistence {
    Transfer save(Transfer transfer);
}
