package com.example.redishomework;

import com.example.redishomework.dao.RedisMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;


@Service
public class RedisMessageSubscriber implements MessageListener {
    private RedisMessageDao redisMessageDao;

    @Autowired
    public RedisMessageSubscriber(RedisMessageDao redisMessageDao) {
        this.redisMessageDao = redisMessageDao;
    }

    public void onMessage(Message message, byte[] pattern) {
        redisMessageDao.add(message);
    }
}
