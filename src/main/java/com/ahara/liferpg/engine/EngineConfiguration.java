package com.ahara.liferpg.engine;

import com.ahara.liferpg.engine.runner.Runner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class EngineConfiguration {
    @Bean
    LettuceConnectionFactory redisConnectionFactory() {
        LettuceConnectionFactory l = new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
        return l;
    }

//
//    @Bean
//    RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
//
//        RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//
//        return template;
//    }
}
