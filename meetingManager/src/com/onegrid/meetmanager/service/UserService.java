package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.User;

public interface UserService {
	public List<User> getPageUser(Page page);
}
