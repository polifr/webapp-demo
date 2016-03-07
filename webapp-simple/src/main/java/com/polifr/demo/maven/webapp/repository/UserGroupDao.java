package com.polifr.demo.maven.webapp.repository;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polifr.demo.maven.webapp.model.UserGroup;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserGroupDao extends HibernateDaoSupport {

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<UserGroup> getAllUserGroups() {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserGroup.class);
		criteria.addOrder(Order.asc("name"));
		return (List<UserGroup>)this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	public UserGroup getUserGroupWithUsers(Long groupId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserGroup.class);
		criteria.add(Restrictions.idEq(groupId));
		criteria.setFetchMode("groupUsers", FetchMode.JOIN);
		List<UserGroup> items = (List<UserGroup>)this.getHibernateTemplate().findByCriteria(criteria);
		if(items.size() == 0) {
			// Nessun match
			return null;
		}
		return items.get(0);
	}
}
