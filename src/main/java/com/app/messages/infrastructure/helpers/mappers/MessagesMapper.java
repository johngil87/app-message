package com.app.messages.infrastructure.helpers.mappers;

import com.app.messages.domain.model.Message;
import com.app.messages.infrastructure.adapters.jparepository.entities.MessageEntity;

public class MessagesMapper {

    public static MessageEntity toEntity(Message message){
        MessageEntity entity = new MessageEntity();
        entity.setIdMessage(message.getIdMessage());
        entity.setMessage(message.getMessageDescription());
        entity.setCreateDate(message.getDate());
        return entity;
    }

    public static Message toObject(MessageEntity entity){
        return Message.builder()
                .messageDescription(entity.getMessage())
                .date(entity.getCreateDate())
                .IdMessage(entity.getIdMessage())
                .build();
    }
}
