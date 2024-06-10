package com.dev.wtchat.service;

import com.dev.wtchat.entity.MessageDetail;
import com.dev.wtchat.repository.MessageRepository;
import com.dev.wtchat.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void createMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Optional<Message> getMessageById(Integer messageId) {
        return messageRepository.findById(messageId);
    }

    @Override
    public List<MessageDetail> getMessageDetails() {
        return messageRepository.getMessageDetails();
    }

    @Override
    public List<Message> fetchMessages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public void deleteMessageById(int messageId) {
        messageRepository.deleteById(messageId);
    }
}
