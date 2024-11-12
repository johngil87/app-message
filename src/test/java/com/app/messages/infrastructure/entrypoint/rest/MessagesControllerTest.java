package com.app.messages.infrastructure.entrypoint.rest;

import com.app.messages.infrastructure.entrypoint.rest.dto.MessagesDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MessagesControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getMessageTest() throws Exception {
        mockMvc.perform(get("/message/recibirMensaje"))
                .andExpect(status().isOk());
    }

    @Test
    public void publishMessageTest() throws Exception {
        MessagesDTO messagesDTO = new MessagesDTO("mensaje de prueba");
        mockMvc.perform(post("/message/enviarMensaje")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(messagesDTO)))
                .andExpect(status().isOk());
    }

}