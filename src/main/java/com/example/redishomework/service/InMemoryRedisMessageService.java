package com.example.redishomework.service;

import com.example.redishomework.entity.RedisMessage;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InMemoryRedisMessageService implements RedisMessageService {
    private final Deque<RedisMessage> messages = new LinkedList<>();

    @Override
    public RedisMessage getLast() {
        return Optional.ofNullable(messages.peekLast())
                .orElse(null);
    }

    @Override
    public List<RedisMessage> getBetween(Long start, Long end) {
        return messages.stream()
                .filter(message -> message.getTimestamp() > start && message.getTimestamp() < end)
                .collect(Collectors.toList());
    }

    @Override
    public void add(Message message) {
        messages.add(new RedisMessage( new String(message.getChannel()), new String(message.getBody()), new Date().getTime()));
    }
}
