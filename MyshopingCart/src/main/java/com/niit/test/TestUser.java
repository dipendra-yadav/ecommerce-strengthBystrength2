package com.niit.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.niit.dao.UserDao;
import com.niit.domain.User;

public class TestUser {

	@Autowired
	static User user;

	@Autowired
	static UserDao userDao;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext();

		ClassPathXmlApplicationContext cpxmlapplicationcontext = (ClassPathXmlApplicationContext) context;
		cpxmlapplicationcontext.refresh();
		
		//user = (User) cpxmlapplicationcontext.getBean(User.class);

		userDao = (UserDao) cpxmlapplicationcontext.getBean("userDaoImpl");// default
																			// name
																			// of
																			// the
																			// repo

		//System.out.println(user);
		System.out.println(userDao);
		cpxmlapplicationcontext.close();

	}
}
