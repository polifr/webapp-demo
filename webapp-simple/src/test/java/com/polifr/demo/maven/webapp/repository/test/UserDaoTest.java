package com.polifr.demo.maven.webapp.repository.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.polifr.demo.maven.webapp.repository.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
@Transactional
@Rollback
public class UserDaoTest {

	@Autowired(required = false)
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	@Test
	public final void testInjection() {
		assertNotNull(userDao);
	}

}
