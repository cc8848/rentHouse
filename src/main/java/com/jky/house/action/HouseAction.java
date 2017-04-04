package com.jky.house.action;

import java.util.List;
import java.util.Map;

import com.jky.house.entity.House;
import com.jky.house.service.HouseService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HouseAction {
	private HouseService service;
	public void setService(HouseService service) {
		this.service = service;
	}

	public String simpleShowAllHouseInfo() {
		List<House> houseList = service.allHouseSimpleInfo();
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("houseList", houseList);
		return Action.SUCCESS;
	}

}
 