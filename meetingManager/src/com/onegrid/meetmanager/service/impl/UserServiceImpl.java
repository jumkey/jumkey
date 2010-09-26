package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.UserDAO;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.User;
import com.onegrid.meetmanager.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getPageUser(Page page) {
		page.setTotalNum(userDAO.getCountByQuery("from User"));
		return userDAO.findByPagination("from User", page);
	}

}
