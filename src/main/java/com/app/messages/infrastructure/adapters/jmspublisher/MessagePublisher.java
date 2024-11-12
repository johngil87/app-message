package com.app.messages.infrastructure.adapters.jmspublisher;

import com.app.messages.domain.model.gateway.MessageGateway;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher implements MessageGateway {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${jms.app.message.queue}")
    String jmsQueue;

    @Override
    public void sendQueueMessage(String message){
        jmsTemplate.convertAndSend(jmsQueue,message);
        UtilLogger.info(MessagePublisher.class, "El mensaje: {} se ha publicado con exito, en la cola {}", message, jmsQueue);
    }
}
