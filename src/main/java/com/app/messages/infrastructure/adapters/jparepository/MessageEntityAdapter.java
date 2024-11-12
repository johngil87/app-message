package com.app.messages.infrastructure.adapters.jparepository;

import com.app.messages.domain.model.Message;
import com.app.messages.domain.model.gateway.MessageRepository;
import com.app.messages.infrastructure.adapters.jparepository.interfaces.MessageEntityRepository;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import com.app.messages.infrastructure.helpers.mappers.MessagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MessageEntityAdapter implements MessageRepository {

    @Autowired
    private MessageEntityRepository repository;

    @Override
    public void saveMessage(Message message) {
        repository.save(MessagesMapper.toEntity(message));
        UtilLogger.info(MessageEntityAdapter.class, "El mensaje: {} se ha guardado con exito", message.getMessageDescription());
    }

    @Override
    public List<Message> getMessages() {
        return repository.findAll().stream()
                .peek(item -> UtilLogger.info(MessageEntityAdapter.class, "Mensaje obtenido: {}", item.getMessage()))
                .map(MessagesMapper::toObject).collect(Collectors.toList());
    }
}
