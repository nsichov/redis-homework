package com.example.redishomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
public class RedisMessage {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String channel;
    private String text;
    private Date timestamp;

    public RedisMessage(String channel, String text, Date timestamp) {
        this.channel = channel;
        this.text = text;
        this.timestamp = timestamp;
    }
}
