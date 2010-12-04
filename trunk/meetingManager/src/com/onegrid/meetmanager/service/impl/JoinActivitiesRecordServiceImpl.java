package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.JoinActivitiesRecordDAO;
import com.onegrid.meetmanager.dao.UserDAO;
import com.onegrid.meetmanager.model.JoinActivitiesRecord;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.User;
import com.onegrid.meetmanager.service.JoinActivitiesRecordService;

public class JoinActivitiesRecordServiceImpl implements
		JoinActivitiesRecordService {
	private UserDAO userDAO;
	private JoinActivitiesRecordDAO joinActivitiesRecordDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public JoinActivitiesRecordDAO getJoinActivitiesRecordDAO() {
		return joinActivitiesRecordDAO;
	}

	public void setJoinActivitiesRecordDAO(
			JoinActivitiesRecordDAO joinActivitiesRecordDAO) {
		this.joinActivitiesRecordDAO = joinActivitiesRecordDAO;
	}

	public void addInstance(JoinActivitiesRecord joinActivitiesRecord) {
		joinActivitiesRecordDAO.save(joinActivitiesRecord);
	}

	public List<JoinActivitiesRecord> findByJoinActivitiesRecord(Integer id) {
		return joinActivitiesRecordDAO
				.find("from JoinActivitiesRecord where activities.id=" + id);
	}

	public void deleteInstance(JoinActivitiesRecord activities)
			throws Exception {
		activities = joinActivitiesRecordDAO.get(activities.getId());
		if (activities.getId() != null) {
			joinActivitiesRecordDAO.delete(activities);
		} else {
			throw new Exception("此记录不是你创建");
		}

	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		JoinActivitiesRecord activities = null;
		for (int id : selected) {
			activities = joinActivitiesRecordDAO.get(id);
			if (activities != null) {
				joinActivitiesRecordDAO.delete(activities);
			} else {
				throw new Exception("删除的记录有的不是你创建");
			}
		}

	}

	public JoinActivitiesRecord updateInstance(JoinActivitiesRecord activities)
			throws Exception {
		JoinActivitiesRecord fe = joinActivitiesRecordDAO.get(activities
				.getId());
		if (fe.getId() != null) {
			fe.setExpendamount(activities.getExpendamount());
			fe.setExpenditures(activities.getExpenditures());
			return fe;
		} else {
			throw new Exception("此记录不是你创建");
		}
	}

	public String checkUser(Integer id, String username) {
		StringBuffer ss = new StringBuffer("[");
		List<User> l = userDAO
				.find("from User where id not in(select u.id from User u,JoinActivitiesRecord j where j.user.id=u.id and j.activities.id="
						+ id + ") and name LIKE '%" + username + "%'");
		for (User u : l) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	@Override
	public List<JoinActivitiesRecord> findPageByJoinActivitiesRecordByActivitiesId(
			Page page, Integer id) {
		if (id != null && id != 0) {
			page
					.setTotalNum(joinActivitiesRecordDAO
							.getCountByQuery("from JoinActivitiesRecord where activities.id="
									+ id));
			return joinActivitiesRecordDAO.findByPagination(
					"from JoinActivitiesRecord where activities.id=" + id,
					page);
		} else {
			return joinActivitiesRecordDAO.findByPagination(
					"from JoinActivitiesRecord", page);
		}
	}
}
