package com.lucasmoraist.transfer_manager.domain.message;

public record Payee(
        String payeeId,
        String name,
        String email
) {

}
