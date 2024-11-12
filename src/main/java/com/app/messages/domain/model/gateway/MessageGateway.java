package com.app.messages.domain.model.gateway;

public interface MessageGateway {
    void sendQueueMessage(String message);
}
