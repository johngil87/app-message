package com.app.messages.domain.usecase;

import com.app.messages.domain.model.Message;
import com.app.messages.domain.model.gateway.MessageRepository;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageUseCase {

    @Autowired
    private MessageRepository repository;

    public void saveMessage(Message message){
        UtilLogger.info(PublishMessageUseCase.class, "Se ha iniciado guardado de mensaje ene DB: {}, con id {}", message.getMessageDescription(), message.getIdMessage());
        repository.saveMessage(message.toBuilder()
                .date(new Date())
                .IdMessage(UUID.randomUUID().toString())
                .build());
    }

    public List<Message> listMessage(){
        UtilLogger.info(PublishMessageUseCase.class, "Se ha iniciado ha consulta de mensajes que han sido publicados");
        return repository.getMessages();
    }


}
