package com.dev.wtchat.resource;

import com.dev.wtchat.entity.Message;
import com.dev.wtchat.entity.MessageDetail;
import com.dev.wtchat.repository.MessageRepository;
import com.dev.wtchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;


@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class ChatResource {
    @Autowired
    MessageService messageService;

    @GetMapping
    ResponseEntity<String> testPage() {
        return ResponseEntity.ok().body("Testing");
    }

    // test message service
    @PostMapping("/create")
    ResponseEntity<String> createMessage(@RequestBody Message newMessage) {
        messageService.createMessage(newMessage);
        return ResponseEntity.ok().body("Message Creation Successful");
    }

    @MessageMapping("/send")
    @SendTo("/chatroom/public")
    public MessageDetail broadcastMessage(@Payload MessageDetail message) throws Exception {
        Thread.sleep(100);
        message.getMessage().setSendingTime(LocalDateTime.now());
        messageService.createMessage(message.getMessage());
        return message;
    }


    @GetMapping("/{messageId}")
    ResponseEntity<Message> getMessage(@PathVariable Integer messageId) {
        return ResponseEntity.ok().body(messageService.getMessageById(messageId).get());
    }

    @GetMapping("/all")
    ResponseEntity<List<MessageDetail>> getAllMessage() {
        return ResponseEntity.ok().body(messageService.getMessageDetails());
    }

    @PutMapping("/delete/{messageId}")
    ResponseEntity<String> deleteMessage(@PathVariable Integer messageId) {
        messageService.deleteMessageById(messageId);
        return ResponseEntity.ok().body("Deleted Message " + messageId);
    }
}
