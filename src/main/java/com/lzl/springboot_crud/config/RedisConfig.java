package com.lzl.springboot_crud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {

    @Bean
    public Jedis jedis(){
        return  new Jedis("192.168.88.246",6379);
    }
}
