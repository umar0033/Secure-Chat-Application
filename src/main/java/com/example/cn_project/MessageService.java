package com.example.cn_project.service;

//import com.example.cn_project.model.User;
//import com.example.cn_project.model.Folder;
import com.example.cn_project.model.Message;
import com.example.cn_project.repository.UserRepository;
import com.example.cn_project.repository.FolderRepository;
import com.example.cn_project.repository.MessageRepository;

import java.time.LocalDateTime;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;
    private final MessageRepository messageRepository;

    public MessageService(
        UserRepository userRepository,
        MessageRepository messageRepository,
        FolderRepository folderRepository
    ) {
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.folderRepository = folderRepository;
    }

    public void sendMessage(Message message) {
        // 1. Validate required fields
        if (message.getContent() == null || message.getContent().isBlank()) {
            throw new IllegalArgumentException("Message content cannot be empty!");
        }

        // 2. Validate sender and folder exist
        if (!userRepository.existsById(message.getSenderId())) {
            throw new IllegalArgumentException("Sender not found");
        }
        if (!folderRepository.existsById(message.getFolderId())) {
            throw new IllegalArgumentException("Folder not found");
        }

        // 3. Prepare and save the sent message
        Message sentMessage = new Message();
        sentMessage.setContent(message.getContent());
        sentMessage.setSenderId(message.getSenderId());
        sentMessage.setFolderId(message.getFolderId());
        sentMessage.setTimestamp(LocalDateTime.now());
        sentMessage.setRead(false);
        messageRepository.save(sentMessage);

        // 4. Prepare and save the received message (if needed)
        Message receivedMessage = new Message();
        receivedMessage.setContent(message.getContent());
        receivedMessage.setSenderId(message.getSenderId());
        receivedMessage.setFolderId("inbox"); // Different folder for recipient
        receivedMessage.setTimestamp(LocalDateTime.now());
        receivedMessage.setRead(false);
        messageRepository.save(receivedMessage);
    }
}
