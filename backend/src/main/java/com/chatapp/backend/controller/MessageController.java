package com.chatapp.backend.controller;

import com.chatapp.backend.entity.Message;
import com.chatapp.backend.repository.MessageRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Chat App!";
    }
    @GetMapping("/messages")
        public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @PostMapping("/messages")
    public Message saveMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }
}