package com.example.redishomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RedisMessage {
    private String channel;
    private String text;
    private Date timestamp;
}
