package com.niit.dao;

import com.niit.domain.User;

public interface UserDao {

	public boolean save(User user);

	public boolean validate(User user);
}
