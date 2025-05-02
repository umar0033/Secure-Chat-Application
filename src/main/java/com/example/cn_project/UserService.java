package com.example.cn_project.service;

import com.example.cn_project.model.User;
import com.example.cn_project.model.Folder;
import com.example.cn_project.repository.UserRepository;
import com.example.cn_project.repository.FolderRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;
  ///  private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, 
                       FolderRepository folderRepository
                       /*,PasswordEncoder passwordEncoder*/) {
        this.userRepository = userRepository;
        this.folderRepository = folderRepository;
      ///  this.passwordEncoder = passwordEncoder;
    }
    
    public User createUser(User user) {
        // Hash password
      ///  user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Save user
        User savedUser = userRepository.save(user);
        
        // Create default folders
        createDefaultFolders(savedUser.getId());
        
        return savedUser;
    }
    
    private void createDefaultFolders(String userId) {
        // Create inbox folder
        Folder inbox = new Folder(userId, "inbox");
        folderRepository.save(inbox);
        
        // Create sent folder
        Folder sent = new Folder(userId, "sent");
        folderRepository.save(sent);
    }
    
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }
    
   /// public Optional<User> getUserByUsername(String username) {
      ///  return userRepository.findByUsername(username);
    ///}
    
    // Other user-related methods
}