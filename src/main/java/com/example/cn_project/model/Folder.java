package com.example.cn_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "folders")
public class Folder {
    @Id
    private String id;  // Will be userId_label (e.g., "user123_inbox")
    
    private String userId;  // Reference to the user who owns this folder
    private String label;   // "inbox" or "sent"
    
    // Constructor to automatically create the composite ID
    public Folder(String userId, String label) {
        this.userId = userId;
        this.label = label;
        this.id = userId + "_" + label;
    }
}
