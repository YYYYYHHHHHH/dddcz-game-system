package com.example.demo;

import java.util.List;

import com.example.demo.dao.AuthUserDao;
import com.example.demo.entity.AuthUser;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
class DddczGameHouseServerApplicationTests {
	@Autowired
	private AuthUserDao userDao;

	@Test
	void contextLoads() {
		AuthUser user = new AuthUser();
		user.setName("yzh1");
		List<AuthUser> list = userDao.queryAll(user);
		
		System.out.println(list);
	}

}
