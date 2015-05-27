package com.rency.shop.web.service.impl;

import java.io.Serializable;

import org.rency.commons.toolbox.exception.CoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rency.shop.web.dao.UserDao;
import com.rency.shop.web.entity.User;
import com.rency.shop.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User get(String uuid) throws CoreException {
		return userDao.get(uuid);
	}

	@Override
	public boolean save(User user) throws CoreException {
		return userDao.insert(user);
	}

	@Override
	public boolean update(User user) throws CoreException {
		return userDao.update(user);
	}

	@Override
	public boolean delete(User user) throws CoreException {
		return userDao.delete(user);
	}

	@Override
	public boolean deleteById(Serializable id) throws CoreException {
		return userDao.deleteById(id);
	}

}
