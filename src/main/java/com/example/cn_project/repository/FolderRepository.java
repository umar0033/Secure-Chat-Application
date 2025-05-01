package com.example.cn_project.repository;
 
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.cn_project.model.Folder;


public interface FolderRepository extends MongoRepository <Folder, String> {
    
}
