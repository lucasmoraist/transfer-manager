package com.lucasmoraist.transfer_manager.infrastructure.client;

import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "user-service", url = "${secrets.url.wallet-core}")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/{userId}")
    Response getUserById(@PathVariable UUID userId);

}
