package com.example.demo.Message;

import java.util.UUID;

public class Message {

    private final UUID id;
    private final String content;


    public Message(UUID id, String content) {
        this.id = id;
        this.content = content;
    }


    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
