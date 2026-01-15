package com.lucasmoraist.transfer_manager.domain.message;

import java.util.UUID;

public record Payer(
        UUID payerId,
        String name,
        String email
) {

}
