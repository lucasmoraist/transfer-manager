package com.lucasmoraist.transfer_manager.infrastructure.api.controller;

import com.lucasmoraist.transfer_manager.application.usecases.transfer.ExecuteTransferCase;
import com.lucasmoraist.transfer_manager.domain.model.Transfer;
import com.lucasmoraist.transfer_manager.infrastructure.api.documentation.routes.PaymentDocumentationRoutes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController implements PaymentDocumentationRoutes {

    private final ExecuteTransferCase executeTransferCase;

    @Override
    @PostMapping
    public ResponseEntity<Void> executePayment(
            @RequestParam UUID payerId,
            @RequestParam UUID payeeId,
            @RequestParam BigDecimal amount
    ) {
        Transfer transfer = this.executeTransferCase.execute(payerId, payeeId, amount);
        URI location = URI.create(String.format("/api/v1/payments/%s", transfer.id()));
        return ResponseEntity.created(location).build();
    }

}
