package com.app.messages.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder(toBuilder = true)
public class Message {

    private String IdMessage;
    private String messageDescription;
    private Date actualDate;
}
