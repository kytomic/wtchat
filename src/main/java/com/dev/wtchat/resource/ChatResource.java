package com.dev.wtchat.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatResource {

    @GetMapping
    public ResponseEntity<String> getChat() {
        return ResponseEntity.ok().body("test");
    }
}
