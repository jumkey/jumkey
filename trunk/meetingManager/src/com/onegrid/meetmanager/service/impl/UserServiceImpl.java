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

	public void addInstance(User user) {
		userDAO.save(user);
	}

	public User updateInstance(User user) {
		User u = userDAO.get(user.getId());
		u.setName(user.getName());
		u.setSex(user.getSex());
		u.setUnits(user.getUnits());
		u.setPhone(user.getPhone());
		u.setCellphone(user.getCellphone());
		u.setZwu(user.getZwu());
		u.setFax(user.getFax());
		u.setMail(user.getMail());
		return u;
	}

	public void deleteInstance(User user) {
		userDAO.delete(userDAO.get(user.getId()));
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			userDAO.delete(userDAO.get(id));
		}
	}

	public List<User> findUserForSeach(Page page, Integer unitsId, String name) {
		String sql = "from User where 1=1";
		if (unitsId != null && unitsId > 0) {
			sql += " and units.id=" + unitsId;
		}
		if (name != null && !name.equals("")) {
			sql += " and name like '%" + name + "%'";
		}
		page.setTotalNum(userDAO.getCountByQuery(sql));
		return userDAO.findByPagination(sql, page);
	}

	public List<User> findUserByUnits(Integer unitsId) {
		return userDAO.find("from User where units.id=" + unitsId);
	}

}
