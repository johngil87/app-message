package com.app.messages.domain.usecase;

import com.app.messages.domain.model.Message;
import com.app.messages.domain.model.gateway.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.UUID;

public class MessageUseCase {

    @Autowired
    private MessageRepository repository;

    public void saveMessage(Message message){
        repository.saveMessage(message.toBuilder()
                .actualDate(new Date())
                .IdMessage(UUID.randomUUID().toString())
                .build());
    }


}
