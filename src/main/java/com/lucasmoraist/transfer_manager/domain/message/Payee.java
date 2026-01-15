package com.lucasmoraist.transfer_manager.domain.message;

import java.util.UUID;

public record Payee(
        UUID payeeId,
        String name,
        String email
) {

}
