package com.example.redishomework.repository;

import com.example.redishomework.entity.RedisMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MessageRepository extends CrudRepository<RedisMessage, Long> {
    @Query(value = "from messages where timestamp BETWEEN :startDate AND :endDate")
    public List<RedisMessage> getAllBetweenDates(@Param("startDate") Long startDate, @Param("endDate") Long endDate);

    @Query(value = "SELECT * FROM messages ORDER BY timestamp DESC LIMIT 1", nativeQuery = true)
    public RedisMessage getLastMessage();
}
