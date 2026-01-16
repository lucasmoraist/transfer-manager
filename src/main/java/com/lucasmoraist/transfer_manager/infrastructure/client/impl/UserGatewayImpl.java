package com.lucasmoraist.transfer_manager.infrastructure.client.impl;

import com.lucasmoraist.transfer_manager.application.gateway.UserGateway;
import com.lucasmoraist.transfer_manager.domain.model.User;
import com.lucasmoraist.transfer_manager.infrastructure.client.UserFeignClient;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserFeignClient userFeignClient;
    private final ObjectMapper objectMapper;

    @Override
    public User findUserById(UUID userId) {
        Response response = this.userFeignClient.getUserById(userId);
        try (InputStream in = response.body().asInputStream()) {
            if (response.status() > 300) {
                log.error("Error fetching user with id {}: HTTP {}", userId, response.status());
                throw new RuntimeException("Failed to fetch user: HTTP " + response.status());
            }

            return objectMapper.readValue(in, User.class);
        } catch (Exception e) {
            log.error("Exception occurred while fetching user with id {}: {}", userId, e.getMessage());
            throw new RuntimeException("Failed to fetch user", e);
        }
    }

}
