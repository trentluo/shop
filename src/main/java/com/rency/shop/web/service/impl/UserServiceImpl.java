package com.rency.shop.web.service.impl;

import org.rency.toolbox.exception.CoreException;
import org.springframework.stereotype.Service;

import com.rency.shop.web.entity.User;
import com.rency.shop.web.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Override
	public User get(String uuid) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(User user) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String uuid) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

}
