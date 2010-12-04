package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.User;

public interface UserService {
	public List<User> getPageUser(Page page);

	public void addInstance(User user);

	public User updateInstance(User user);

	public void deleteInstance(User user);

	public void deleteSelectInstance(Integer[] selected);

	public List<User> findUserForSeach(Page page, Integer unitsId,
			String name);
	public List<User> findUserByUnits(Integer unitsId);
}
