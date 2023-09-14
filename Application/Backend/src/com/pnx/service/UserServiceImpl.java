package com.pnx.services;

import java.util.List;

import com.pnx.dao.UserDao;
import com.pnx.models.Users;

public class UserServiceImpl implements UserService{
    private UserDao dao;
    
	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Users> importUsers() {
		// TODO Auto-generated method stub
		return dao.readUsers();
	}



}
