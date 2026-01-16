package com.lucasmoraist.transfer_manager.application.gateway;

import com.lucasmoraist.transfer_manager.domain.model.User;

import java.util.UUID;

public interface UserGateway {

    User findUserById(UUID userId);

}
