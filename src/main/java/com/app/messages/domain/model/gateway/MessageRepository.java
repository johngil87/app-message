package com.app.messages.domain.model.gateway;

import com.app.messages.domain.model.Message;

import java.util.List;

public interface MessageRepository {
    void saveMessage(Message message);
    List<Message> getMessages();
}
