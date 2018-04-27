package com.lzl.springboot_crud.test;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import sun.applet.Main;

import java.util.*;

public class JedisTest {

    private static Jedis jedis = new Jedis("192.168.88.246",6379);

    public static void main(String[] args) {
        jedis.flushDB();
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        jedis.set("k3","v3");
        jedis.set("k4","v4");

        System.out.println("========================basic===============================");
        Set<String> keys = jedis.keys("*");
        for(Iterator iterator =keys.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println("jedis has k2:"+jedis.exists("k2"));
        System.out.println("jedis k1 ttl:"+jedis.ttl("k1"));
        System.out.println("========================String===============================");
        jedis.set("k1","v1");
        jedis.append("k1","feili");
        System.out.println("k1:"+jedis.get("k1"));
        jedis.mset("mk1","mv1","mk2","mv2","mk3","mv3");
        keys = jedis.keys("mk*");
        for(Iterator iterator =keys.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        List<String> list  = jedis.mget("mk1","mk2","mk3");
        System.out.println(list);
        System.out.println("=========================List===============================");
          jedis.lpush("jlist","v1","v2","v3");
        list =  jedis.lrange("jlist",0,-1);
        System.out.println(list);
        System.out.println("==========================Set===============================");
        jedis.sadd("sk1","sv1","sv3","sv4","sv5");
        Set<String> set = jedis.smembers("sk1");
        for (Iterator<String> iterator=set.iterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        jedis.srem("sk1","sv5");
        System.out.println("size="+jedis.smembers("sk1").size());
        System.out.println("=========================Hash===============================");
        jedis.hset("user","name","lisi");
        System.out.println("user.name="+jedis.hget("user","name"));
        Map<String,String> map = new HashMap<>();
        map.put("id","1");
        map.put("gender","man");
        jedis.hmset("user",map);
        //有则追加，无则创建
        list = jedis.hmget("user","id","name");
        System.out.println("[id,name]="+list);
        System.out.println("=========================ZSet===============================");
        jedis.zadd("zk1",60,"zv1");
        jedis.zadd("zk1",70,"zv2");
        jedis.zadd("zk1",80,"zv3");
        set = jedis.zrange("zk1",0,-1);
        for (Iterator<String> iterator=set.iterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        set = jedis.zrangeByScore("zk1",60,70);
        System.out.println("60-70:");
        for (Iterator<String> iterator=set.iterator();iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
