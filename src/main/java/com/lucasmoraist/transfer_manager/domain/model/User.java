package com.lucasmoraist.transfer_manager.domain.model;

import java.util.UUID;

public record User(
        UUID id,
        String name,
        String email
) {

}
