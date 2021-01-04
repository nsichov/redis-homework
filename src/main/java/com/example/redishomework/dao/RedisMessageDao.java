package com.example.redishomework.dao;

import org.springframework.data.redis.connection.Message;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RedisMessageDao {
    String getLast();

    List<String> getBetween(Date start, Date end);

    void add(Message text);
}
