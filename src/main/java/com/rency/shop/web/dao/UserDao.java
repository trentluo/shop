package com.rency.shop.web.dao;

import java.io.Serializable;

import org.rency.common.utils.exception.CoreException;
import org.springframework.stereotype.Repository;

import com.rency.shop.web.entity.User;

@Repository(value="userDao")
public interface UserDao{

	public User get(Serializable id) throws CoreException;
	public User findByEmail(String email) throws CoreException;
	public boolean insert(User user) throws CoreException;
	public boolean update(User user) throws CoreException;
	public boolean delete(User user) throws CoreException;
	public boolean deleteById(Serializable id) throws CoreException;
	
}
