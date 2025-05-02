package com.example.cn_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    
    private String content;
    private LocalDateTime timestamp = LocalDateTime.now();
    private String senderId;
    private String receiverId;
    private boolean read = false;
    
    // Reference to which folder this message belongs to
    private String folderId;
}
