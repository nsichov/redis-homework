package com.example.redishomework.controller;

import com.example.redishomework.service.RedisMessageService;
import com.example.redishomework.entity.RedisMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisPublishController {
    private RedisTemplate<String, String> redisTemplate;
    private RedisMessageService redisMessageService;

    @Value("${app.redis.channelName}")
    private String redisChannelName;

    @Autowired
    public RedisPublishController(RedisTemplate<String, String> redisTemplate, RedisMessageService redisMessageService) {
        this.redisTemplate = redisTemplate;
        this.redisMessageService = redisMessageService;
    }

    @GetMapping("/getLast")
    public RedisMessage getLast() {
        return redisMessageService.getLast();
    }

    @GetMapping("/getByTime")
    public List<RedisMessage> getByTime(@RequestParam Date start, @RequestParam Date end) {
        return redisMessageService.getBetween(start, end);
    }

    @PostMapping("/publish")
    public void publish(@RequestBody String text) {
        redisTemplate.convertAndSend(redisChannelName, text);
    }
}
