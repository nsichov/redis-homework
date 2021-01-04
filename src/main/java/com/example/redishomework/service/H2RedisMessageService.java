package com.example.redishomework.service;

import com.example.redishomework.entity.RedisMessage;
import com.example.redishomework.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Primary
public class H2RedisMessageService implements RedisMessageService {
    private MessageRepository repository;

    @Autowired
    public H2RedisMessageService(MessageRepository repository) {
        this.repository = repository;
    }

    @Override
    public RedisMessage getLast() {
        return repository.getLastMessage();
    }

    @Override
    public List<RedisMessage> getBetween(Long start, Long end) {
        return repository.getAllBetweenDates(start, end);
    }

    @Override
    public void add(Message message) {
        repository.save(new RedisMessage(new String(message.getChannel()), new String(message.getBody()), new Date().getTime()));
    }
}
