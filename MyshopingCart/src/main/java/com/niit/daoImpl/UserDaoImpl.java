package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.domain.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean save(User user) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			user.setEnabled(true);
			user.setRole("ROLE_USER");
			session.save(user);
			tx.commit();
			session.flush();
			session.close();

			return true;

		}

		catch (Exception e) {

			e.printStackTrace();

			return false;

		}

	}

	public boolean validate(User user) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// User retrieved_User = (User) session.get(User.class, user.getId());
		Query query = session.createQuery("from User where name=? and password=?");
		query.setParameter(0, user.getName());
		query.setParameter(1, user.getPassword());

		List<User> userslist = query.list();

		tx.commit();
		session.flush();
		session.close();

		if (userslist.isEmpty()) {

			return false;
		}

		else {
			return true;
		}

	}

}
