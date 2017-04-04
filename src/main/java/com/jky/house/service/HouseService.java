package com.jky.house.service;

import java.util.List;

import com.jky.house.dao.HouseMapper;
import com.jky.house.entity.House;

public class HouseService {

	private HouseMapper houseDao;
	public void setHouseDao(HouseMapper houseDao) {
		this.houseDao = houseDao;
	}

	/** 显示所有房屋的简单信息 **/
	public List<House> allHouseSimpleInfo() {
		return houseDao.simpleQueryHouse();
	}

}
