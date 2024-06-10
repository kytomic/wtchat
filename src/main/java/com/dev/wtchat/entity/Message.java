package com.dev.wtchat.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "Message")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "body")
    private String body;

    @Column(name = "senderId")
    private int senderId;

    @Column(name = "receiverId")
    private int receiverId;

    @Column(name = "sendingTime")
    private LocalDateTime sendingTime;

    @Column(name = "status")
    private int status;


    public Message(String body, int senderId, int receiverId) {
        this.body = body;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.sendingTime = LocalDateTime.now();
        this.status = 1;
    }
}
