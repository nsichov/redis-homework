package com.example.redishomework.broker;

import com.example.redishomework.service.RedisMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;


@Service
public class RedisMessageSubscriber implements MessageListener {
    private RedisMessageService redisMessageService;

    @Autowired
    public RedisMessageSubscriber(RedisMessageService redisMessageService) {
        this.redisMessageService = redisMessageService;
    }

    public void onMessage(Message message, byte[] pattern) {
        redisMessageService.add(message);
    }
}
