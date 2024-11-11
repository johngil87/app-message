package com.app.messages.infrastructure.entrypoint.rest;


import com.app.messages.domain.model.Message;
import com.app.messages.domain.usecase.MessageUseCase;
import com.app.messages.infrastructure.entrypoint.rest.dto.MessagesDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Autowired
    private MessageUseCase useCase;

    @PostMapping(path = "/pulish", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> publishMessage(@RequestBody @Valid MessagesDTO messagesDTO){
        useCase.saveMessage(Message.builder()
                .messageDescription(messagesDTO.getMessageDescription())
                .build());
        return new ResponseEntity<>("todo bien ", HttpStatus.OK);
    }
}
