package com.lzl.springboot_crud;

import com.lzl.springboot_crud.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCrudApplicationTests {

	@Autowired
	private Jedis jedis;

	@Test
	public void redisTest() {
		System.out.println(jedis.ping());
	}

}
