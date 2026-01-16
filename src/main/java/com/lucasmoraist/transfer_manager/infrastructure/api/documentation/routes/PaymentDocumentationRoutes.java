package com.lucasmoraist.transfer_manager.infrastructure.api.documentation.routes;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.UUID;

public interface PaymentDocumentationRoutes {

    ResponseEntity<Void> executePayment(UUID payerId, UUID payeeId, BigDecimal amount);

}
