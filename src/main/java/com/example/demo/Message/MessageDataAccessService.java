package com.example.demo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("postgres")
public class MessageDataAccessService implements MessageDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MessageDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getMessage() {
        final String sql = "SELECT id, content FROM message";
        Message message = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String content = resultSet.getString("content");
            return new Message(id, content);
        }).get(0);

        return message.getContent();
    }
}
