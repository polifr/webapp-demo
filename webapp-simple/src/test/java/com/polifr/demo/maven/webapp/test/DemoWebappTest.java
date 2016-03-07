package com.polifr.demo.maven.webapp.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ContextConfiguration;

import com.polifr.demo.maven.webapp.repository.test.UserDaoTest;
import com.polifr.demo.maven.webapp.repository.test.UserGroupDaoTest;

@RunWith(Suite.class)
@SuiteClasses({
	UserDaoTest.class,
	UserGroupDaoTest.class
})
@ContextConfiguration("classpath:test-context.xml")
public class DemoWebappTest {

}
