package com.rency.shop.web.dao;

import java.io.Serializable;

import org.rency.commons.toolbox.exception.CoreException;

import com.rency.shop.web.entity.User;

public interface UserDao{

	public User get(Serializable id) throws CoreException;
	public boolean insert(User user) throws CoreException;
	public boolean update(User user) throws CoreException;
	public boolean delete(User user) throws CoreException;
	public boolean deleteById(Serializable id) throws CoreException;
	
}
