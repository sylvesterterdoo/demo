package com.example.demo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageDao messageDao;

    @Autowired
    public MessageService(@Qualifier("postgres") MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    public String getMessage() {
        return messageDao.getMessage();
    }
}
