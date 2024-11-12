package com.adrian.SimpleSocial.service;

import com.adrian.SimpleSocial.entity.Message;
import com.adrian.SimpleSocial.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void postMessage(Message message)
    {
        messageRepository.save(message);
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}