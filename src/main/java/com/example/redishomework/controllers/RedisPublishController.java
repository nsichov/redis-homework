package com.example.redishomework.controllers;

import com.example.redishomework.dao.RedisMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class RedisPublishController {
    private RedisTemplate<String, String> redisTemplate;
    private RedisMessageDao redisMessageDao;

    @Autowired
    public RedisPublishController(RedisTemplate<String, String> redisTemplate, RedisMessageDao redisMessageDao) {
        this.redisTemplate = redisTemplate;
        this.redisMessageDao = redisMessageDao;
    }

    @GetMapping("/getLast")
    public String getLast() {
        return redisMessageDao.getLast();
    }

    @GetMapping("/getByTime")
    public List<String> getByTime(@RequestParam Date start, @RequestParam Date end) {
        return redisMessageDao.getBetween(start, end);
    }

    @PostMapping("/publish")
    public String publish(@RequestBody String text) {
        redisTemplate.convertAndSend("test-topic", text);
        return "Done";
    }
}
