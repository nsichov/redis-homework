package com.example.redishomework.dao;

import com.example.redishomework.entity.RedisMessage;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InMemoryRedisMessageDao implements RedisMessageDao{
    private final Deque<RedisMessage> messages = new LinkedList<>();

    @Override
    public String getLast() {
        return Optional.ofNullable(messages.peekLast())
                .map(RedisMessage::getText)
                .orElse(null);
    }

    @Override
    public List<String> getBetween(Date start, Date end) {
        return messages.stream()
                .filter(message -> message.getTimestamp().after(start) && message.getTimestamp().before(end))
                .map(RedisMessage::getText)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Message message) {
        messages.add(new RedisMessage(new String(message.getChannel()), new String(message.getBody()), new Date()));
    }
}
