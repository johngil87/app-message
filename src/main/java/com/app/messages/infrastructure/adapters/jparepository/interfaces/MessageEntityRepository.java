package com.app.messages.infrastructure.adapters.jparepository.interfaces;

import com.app.messages.infrastructure.adapters.jparepository.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageEntityRepository extends JpaRepository<MessageEntity, String>{
}
