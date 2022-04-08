package com.edward.mt;

import com.edward.mt.bean.User;
import com.edward.mt.service.CategoryService;
import com.edward.mt.service.DishService;
import com.edward.mt.service.UserService;
import com.edward.mt.vo.MtResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class MtApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private DishService dishService;
@Autowired
	private CategoryService categoryService;

	@Test
	void jedisTest() {
		JedisPool jedisPool = new JedisPool("192.168.23.129", 6379);
		// 第二步：从JedisPool中获得Jedis对象。
		Jedis jedis = jedisPool.getResource();
		// 第三步：使用Jedis操作redis服务器。
		jedis.set("aaaa", "bbbb");
		String result = jedis.get("jedis");
		System.out.println(result);
		// 第四步：操作完毕后关闭jedis对象，连接池回收资源。
		jedis.close();
		// 第五步：关闭JedisPool对象。
		jedisPool.close();
	}

	@Test
	void mailTest() {
		User user = new User();
		user.setUserName("edward123");
		user.setPassWord("edward123");
		user.setEmail("1356148816@qq.com");
		userService.addUser(user);
	}
	@Test
	void pricesTest() {
		MtResult result = dishService.priceRange();
		System.out.println(result);

	}
	@Test
	void dishNumTest() {
		MtResult result = categoryService.dishNumByCategory();
		System.out.println(result);

	}

}
