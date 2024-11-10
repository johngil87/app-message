package com.app.messages.infrastructure.adapters.jparepository.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "USUARIO")
public class MessageEntity {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "MESSAGE")
    private String message;
    @Column(name = "CREATE_DATE")
    private Date createDate;
}
