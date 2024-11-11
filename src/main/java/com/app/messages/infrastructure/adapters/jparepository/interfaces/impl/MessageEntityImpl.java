package com.app.messages.infrastructure.adapters.jparepository.interfaces.impl;

import com.app.messages.domain.model.Message;
import com.app.messages.domain.model.gateway.MessageRepository;
import com.app.messages.infrastructure.adapters.jparepository.interfaces.MessageEntityRepository;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import com.app.messages.infrastructure.helpers.mappers.MessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageEntityImpl implements MessageRepository {

    @Autowired
    private MessageEntityRepository repository;

    @Override
    public void saveMessage(Message message) {
        repository.save(MessagesMapper.toEntity(message));
        UtilLogger.info(MessageEntityImpl.class, "El mensaje: {} se ha guardado con exito", message.getMessageDescription());
    }
}
