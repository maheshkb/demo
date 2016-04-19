package com.mydomain.service;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.mydomain.dal.UserDao;
import com.mydomain.model.User;

import junit.framework.Assert;

public class UserServiceTest {

	@Test(expected = IllegalArgumentException.class)
	public void testGetUser() {
		//Test valid Id
		UserDao mockUserDao = mock(UserDao.class);
		User u = new User();
		u.setName("Manish");
		when(mockUserDao.getUser(anyInt())).thenReturn(u);
		
		UserService service = new UserService();
		service.setUserDao(mockUserDao);
		u =service.getUser(1);
		Assert.assertEquals("Manish", u.getName());
		
		//Test id being null
		when(mockUserDao.getUser(null)).thenThrow(new IllegalArgumentException("ID Cannot be "));
		u= service.getUser(null);
	}

}
