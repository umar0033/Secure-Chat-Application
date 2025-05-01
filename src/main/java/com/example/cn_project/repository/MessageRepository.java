package com.example.cn_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.cn_project.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    
}