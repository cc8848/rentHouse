package com.jky.user.action;

import java.util.Map;

import com.jky.user.entity.User;
import com.jky.user.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class UserAction {
	/** service层对象 **/
	private UserService service;
	public void setService(UserService service) {
		this.service = service;
	}

	/** Model对象 **/
	/** 1、用户 **/
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/**************************************/

	/** 1.用户登录 **/
	public String login() {
		User u = service.userLogin(user);
		if (u == null) {
			return Action.LOGIN;
		}
		ActionContext.getContext().getSession().put("user", u);
		return Action.SUCCESS;
	}
	/** 2.注册用户 **/
	public String register() {
		int uid = service.registerUser(user);
		if (uid > 0) {
			return Action.SUCCESS;
		}
		return Action.INPUT;
	}
	/** 3.注销 **/
	public String cancel() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("user");
		return Action.SUCCESS;
	}

	/** 跳往首页 **/
	public String index() {
		return Action.SUCCESS;
	}

	/** 跳往登录后的首页 **/
	public String hasLogin() {
		return Action.SUCCESS;
	}

}
