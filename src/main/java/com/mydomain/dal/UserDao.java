package com.mydomain.dal;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mydomain.model.User;

public class UserDao {

	public List<User> getUserList() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(User.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public User getUser(Integer id) {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit = ses.createCriteria(User.class);
			crit.add(Restrictions.idEq(id));
			User u = (User) crit.uniqueResult();
			return u;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
