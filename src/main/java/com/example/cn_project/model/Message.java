package com.example.cn_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String content;
    private LocalDateTime timestamp;
    private String senderId;
    private String receiverId;
    
    // Constructor
    public Message() {
        this.timestamp = LocalDateTime.now();
    }
}