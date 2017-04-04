package com.jky.user.dao;

import org.springframework.dao.DuplicateKeyException;

import com.jky.user.entity.User;

public interface UserMapper {

	public User queryById(Integer id);

	public User queryByNameAndPassword(User u);

	public void addUser(User u);
}
