package com.dev.wtchat.service;

import java.util.List;
import java.util.Optional;

import com.dev.wtchat.entity.Message;
import com.dev.wtchat.entity.MessageDetail;

public interface MessageService {

    // Create Operation
    void createMessage(Message message);

    // Read Operation
    Optional<Message> getMessageById(Integer messageId);

    List<MessageDetail> getMessageDetails();

    // Read all Operation
    List<Message> fetchMessages();

    // Delete Operation
    void deleteMessageById(int messageId);
}
