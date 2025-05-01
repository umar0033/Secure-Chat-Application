package com.example.cn_project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import lombok.Data;

@Data
@Document(collection = "folders")
@CompoundIndex(name = "userId_label", def = "{'userId': 1, 'label': 1}", unique = true)
public class Folder {
    @Id
    private String id;  // Auto-generated
    
    private String userId;
    private String label;  // "inbox", "drafts", etc.
    
    // Constructor to create a folder
    public Folder(String userId, String label) {
        this.userId = userId;
        this.label = label;
    }
}