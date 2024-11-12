package com.app.messages.domain.usecase;

import com.app.messages.domain.model.gateway.MessageGateway;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishMessageUseCase {

    @Autowired
    private MessageGateway messageGateway;
    @Autowired
    private MessageUseCase saveMessageUseCase;


    public void publishMessage(String message){
        UtilLogger.info(PublishMessageUseCase.class, "Se ha iniciado la publicacion del mensaje: {}", message);
        messageGateway.sendQueueMessage(message);
    }
}
