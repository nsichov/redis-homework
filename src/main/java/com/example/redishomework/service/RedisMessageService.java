package com.example.redishomework.service;

import com.example.redishomework.entity.RedisMessage;
import org.springframework.data.redis.connection.Message;

import java.util.Date;
import java.util.List;

public interface RedisMessageService {
    RedisMessage getLast();

    List<RedisMessage> getBetween(Date start, Date end);

    void add(Message message);
}
