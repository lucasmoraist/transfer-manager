package com.lucasmoraist.transfer_manager.infrastructure.queue.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class TransferProducer {

    private final StreamBridge streamBridge;

    public void sendMessage(Message<?> message, String bindingName) {
        log.info("Sending message [{}] to binding [{}]", message, bindingName);
        streamBridge.send(bindingName, message);
    }

}
