package com.app.messages.infrastructure.entrypoint.rest;


import com.app.messages.domain.model.Message;
import com.app.messages.domain.usecase.MessageUseCase;
import com.app.messages.domain.usecase.PublishMessageUseCase;
import com.app.messages.infrastructure.entrypoint.rest.dto.MessagesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Autowired
    private PublishMessageUseCase useCase;
    @Autowired
    private MessageUseCase messageUseCase;

    @PostMapping(path = "/enviarMensaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> publishMessage(@RequestBody @Valid MessagesDTO messagesDTO){
        useCase.publishMessage(messagesDTO.getMessageDescription());
        return new ResponseEntity<>("Mensaje publicado con exito", HttpStatus.OK);
    }

    @GetMapping(path = "/recibirMensaje", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getMessage(){
        List<Message> listResponse = messageUseCase.listMessage();
        return new ResponseEntity<>(listResponse, HttpStatus.OK);
    }
}
