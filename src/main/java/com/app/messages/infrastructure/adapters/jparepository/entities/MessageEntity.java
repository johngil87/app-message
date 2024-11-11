package com.app.messages.infrastructure.adapters.jparepository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "MESSAGE_TABLE")
public class MessageEntity {

    @Id
    @Column(name = "ID_MESSAGE")
    private String idMessage;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "CREATE_DATE")
    private Date createDate;
}
