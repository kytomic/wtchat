package com.dev.wtchat.resource;

import com.dev.wtchat.entity.User;
import com.dev.wtchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {
    @Autowired
    UserService userService;

    @PostMapping("/create")
    ResponseEntity<String> createUser(@RequestBody User newUser) {
        userService.createUser(newUser);
        return ResponseEntity.ok().body("User Creation Successful");
    }

    @GetMapping("/{userId}")
    ResponseEntity<User> getUser(@PathVariable int userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
    }

    @PutMapping("/delete/{userId}")
    ResponseEntity<String> deleteUser(@PathVariable int userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().body("Deleted user " + userId);
    }
}
