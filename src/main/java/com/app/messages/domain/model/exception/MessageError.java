package com.app.messages.domain.model.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class MessageError {
    private String message;
}
