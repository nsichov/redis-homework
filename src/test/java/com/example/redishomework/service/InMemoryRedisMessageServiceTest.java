package com.example.redishomework.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.data.redis.connection.DefaultMessage;

import java.time.LocalDateTime;
import java.util.Date;

class InMemoryRedisMessageServiceTest {

    public static final String MESSAGE = "message";
    public static final String CHANNEL_NAME = "test";
    private RedisMessageService service;

    @BeforeEach
    public void before() {
        service =  new InMemoryRedisMessageService();
    }

    @Test
    void getLastEmpty() {
        assertNull(service.getLast());
    }

    @Test
    void getLast() {
        service.add(new DefaultMessage(CHANNEL_NAME.getBytes(), MESSAGE.getBytes()));

        assertNotNull(service.getLast());
        assertEquals(service.getLast().getChannel(), CHANNEL_NAME);
    }

    @Test
    void getBetween() {
        service.add(new DefaultMessage(CHANNEL_NAME.getBytes(), MESSAGE.getBytes()));
        service.add(new DefaultMessage(CHANNEL_NAME.getBytes(), MESSAGE.getBytes()));

        assertEquals(2, service.getBetween(System.currentTimeMillis() - 1000, System.currentTimeMillis() + 1000).size());
    }
}
