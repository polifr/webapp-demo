package com.polifr.demo.maven.webapp.repository.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.polifr.demo.maven.webapp.model.UserGroup;
import com.polifr.demo.maven.webapp.repository.UserGroupDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
@Transactional
@Rollback
public class UserGroupDaoTest {

	@Autowired(required = false)
	private UserGroupDao userGroupDao;
	public UserGroupDao getUserGroupDao() {
		return userGroupDao;
	}

	@Test
	public final void testInjection() {
		assertNotNull(userGroupDao);
	}

	@Test
	public final void testGetAllUserGroups() {
		List<UserGroup> userGroups = userGroupDao.getAllUserGroups();
		assertNotNull(userGroups);
		assertTrue(userGroups.size() > 0);
	}

	@Test
	public final void testGet() {
		List<UserGroup> userGroups = userGroupDao.getAllUserGroups();
		for(UserGroup item : userGroups) {
			UserGroup userGroup = userGroupDao.getUserGroupWithUsers(item.getId());
			assertNotNull(userGroup);
			assertNotNull(userGroup.getGroupUsers());
		}
	}
}
