package com.app.messages.infrastructure.entrypoint.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessagesDTO {

    @NotBlank(message = "el mensaje no puede ser nulo o vacio")
    private String messageDescription;
}
