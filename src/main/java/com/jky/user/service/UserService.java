package com.jky.user.service;

import org.springframework.dao.DuplicateKeyException;

import com.jky.user.dao.UserMapper;
import com.jky.user.entity.User;

public class UserService {
	private UserMapper userDao;
	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}
	/**
	 * 根据用户名和密码登录
	 * 
	 * @param u
	 * @return
	 */
	public User userLogin(User u) {
		if ("".equals(u.getUname().trim()) || "".equals(u.getUpassword().trim())) {
			return null;
		}
		User user = userDao.queryByNameAndPassword(u);
		return user;
	}
	public int registerUser(User user) {
		if ("".equals(user.getUname().trim()) || "".equals(user.getUpassword().trim())) {
			return 0;
		} else {
			try {
				// 权限等级，通过注册的都是普通用户
				user.setUlevel(1);

				userDao.addUser(user);
				return user.getUid();
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
				return 0;
			}
		}
	}

}
