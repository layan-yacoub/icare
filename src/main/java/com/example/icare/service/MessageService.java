package com.example.icare.service;


import com.example.icare.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

}
