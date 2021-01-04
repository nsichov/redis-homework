package com.example.redishomework.config;

import com.example.redishomework.broker.RedisMessageSubscriber;
import com.example.redishomework.service.RedisMessageService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootConfiguration
public class BeanConfiguration {
    @Bean
    public StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    public MessageListenerAdapter messageListener(RedisMessageService redisMessageService) {
        return new MessageListenerAdapter(new RedisMessageSubscriber(redisMessageService));
    }

    @Bean
    public Topic topic() {
        return new PatternTopic("*");
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container
                = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter, topic());
        return container;
    }
}
