package com.lzl.springboot_crud.test;

import com.lzl.springboot_crud.utils.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {


    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis =null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k1","v1");
            System.out.println(jedis.get("k1"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }
}
