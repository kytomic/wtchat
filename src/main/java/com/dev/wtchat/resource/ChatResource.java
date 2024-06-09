package com.dev.wtchat.resource;

import com.dev.wtchat.entity.Message;
import com.dev.wtchat.repository.MessageRepository;
import com.dev.wtchat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<String> testCreateMessage(@RequestBody Message newMessage) {
        messageService.createMessage(newMessage);
        return ResponseEntity.ok().body("Message Creation Successful");
    }

    @GetMapping("/{messageId}")
    ResponseEntity<Message> testGetMessage(@PathVariable Integer messageId) {
        return ResponseEntity.ok().body(messageService.getMessageById(messageId).get());
    }

    @GetMapping("/all")
    ResponseEntity<List<Message>> testGetAllMessage() {
        return ResponseEntity.ok().body(messageService.fetchMessages());
    }

    @PutMapping("/delete/{messageId}")
    ResponseEntity<String> testDeleteMessage(@PathVariable Integer messageId) {
        messageService.deleteMessageById(messageId);
        return ResponseEntity.ok().body("Deleted Message " + messageId);
    }
}
