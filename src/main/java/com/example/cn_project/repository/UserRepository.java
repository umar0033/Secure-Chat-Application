package com.example.cn_project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.cn_project.model.User;  // Add this import

public interface UserRepository extends MongoRepository<User, String> {
    // Your repository methods here
    
}