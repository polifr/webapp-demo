package com.polifr.demo.maven.webapp.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polifr.demo.maven.webapp.model.User;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserDao extends HibernateDaoSupport {

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getAllUsers() {
		return this.getHibernateTemplate().loadAll(User.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> findUsersByExample(User exampleEntity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		criteria.add(Example.create(exampleEntity).enableLike(MatchMode.ANYWHERE).ignoreCase());
		return (List<User>) this.getHibernateTemplate().findByCriteria(criteria);
	}

}
