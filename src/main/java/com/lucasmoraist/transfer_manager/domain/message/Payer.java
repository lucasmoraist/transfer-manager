package com.lucasmoraist.transfer_manager.domain.message;

public record Payer(
        String payerId,
        String name,
        String email
) {

}
