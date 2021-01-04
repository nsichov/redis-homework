package com.example.redishomework.service;

import com.example.redishomework.entity.RedisMessage;
import org.springframework.data.redis.connection.Message;

import java.util.List;

public interface RedisMessageService {
    RedisMessage getLast();

    List<RedisMessage> getBetween(Long start, Long end);

    void add(Message message);
}
