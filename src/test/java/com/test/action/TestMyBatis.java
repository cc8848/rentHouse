package com.test.action;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.jky.house.dao.HouseMapper;
import com.jky.house.entity.House;

public class TestMyBatis {

	@Test
	public void test01() {

		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HouseMapper mapper = (HouseMapper) ac.getBean("houseMapper");
		List<House> list = mapper.simpleQueryHouse();
		System.out.println(list.size());

	}
}
