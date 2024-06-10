package com.dev.wtchat.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageDetail {
    private Message message;
    private String senderName;

    public MessageDetail(Message message, String senderName) {
        this.message = message;
        this.senderName = senderName;
    }
}
