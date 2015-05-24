package com.rency.shop.web.service;

import org.rency.commons.toolbox.exception.CoreException;

import com.rency.shop.web.entity.User;

public interface UserService {

	public User get(String uuid) throws CoreException;
	
	public boolean save(User user) throws CoreException;
	
	public boolean update(User user) throws CoreException;
	
	public boolean delete(String uuid) throws CoreException;
	
}