package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.ActivitiesDAO;
import com.onegrid.meetmanager.model.Activities;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.service.ActivitiesService;

public class ActivitiesServiceImpl implements ActivitiesService {
	private ActivitiesDAO activitiesDAO;

	public void setActivitiesDAO(ActivitiesDAO activitiesDAO) {
		this.activitiesDAO = activitiesDAO;
	}

	public void addInstance(Activities activities) {
		activitiesDAO.save(activities);
	}

	public List<Activities> findActivitiesByMeetingId(Integer meetingid) {
		return activitiesDAO.find("from Activities where meetingInfo.id="
				+ meetingid);
	}

	public void deleteInstance(Activities activities) throws Exception {
		activities = activitiesDAO.get(activities.getId());
		if (activities.getId() != null) {
			activitiesDAO.delete(activities);
		} else {
			throw new Exception("此记录不是你创建");
		}

	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Activities activities = null;
		for (int id : selected) {
			activities = activitiesDAO.get(id);
			if (activities != null) {
				activitiesDAO.delete(activities);
			} else {
				throw new Exception("删除的记录有的不是你创建");
			}
		}

	}

	public Activities updateInstance(Activities activities) throws Exception {
		Activities fe = activitiesDAO.get(activities.getId());
		if (fe.getId() != null) {
			fe.setName(activities.getName());
			fe.setDate(activities.getDate());
			fe.setDay(activities.getDay());
			fe.setPerson(activities.getPerson());
			fe.setPhone(activities.getPhone());
			fe.setMobilephone(activities.getMobilephone());
			fe.setDesc1(activities.getDesc1());
			return fe;
		} else {
			throw new Exception("此记录不是你创建");
		}
	}

	public List<Activities> findPageActivitiesByMeetingId(Page page,
			Integer meetingid) {
		if (meetingid != null && meetingid != 0) {
			page.setTotalNum(activitiesDAO
					.getCountByQuery("from Activities where meetingInfo.id="
							+ meetingid));
			return activitiesDAO.findByPagination(
					"from Activities where meetingInfo.id=" + meetingid, page);
		} else {
			return activitiesDAO.findByPagination("from Activities", page);
		}
	}

}
