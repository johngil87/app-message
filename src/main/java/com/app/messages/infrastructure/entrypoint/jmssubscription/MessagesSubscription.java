package com.app.messages.infrastructure.entrypoint.jmssubscription;

import com.app.messages.domain.model.Message;
import com.app.messages.domain.usecase.MessageUseCase;
import com.app.messages.infrastructure.helpers.log.UtilLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessagesSubscription {

    @Value("${jms.app.message.queue}")
    private String jmsQueue;

    @Autowired
    private MessageUseCase useCase;

    @JmsListener(destination = "${jms.app.message.queue}")
    public void receiveMessage(String message) {
        UtilLogger.info(MessagesSubscription.class, "Seha consumido nuevo mensaje de la queue : {}, valor del mansaje: {}", jmsQueue, message);
            useCase.saveMessage(Message.builder()
                    .messageDescription(message)
                    .build());

    }
}
