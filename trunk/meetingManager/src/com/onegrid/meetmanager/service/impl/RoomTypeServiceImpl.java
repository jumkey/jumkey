package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.RoomTypeDAO;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.service.RoomTypeService;

public class RoomTypeServiceImpl implements RoomTypeService {
	private RoomTypeDAO roomTypeDAO;

	public void setRoomTypeDAO(RoomTypeDAO roomTypeDAO) {
		this.roomTypeDAO = roomTypeDAO;
	}

	public void addInstance(RoomType roomType) {
		roomTypeDAO.save(roomType);
	}

	public RoomType updateInstance(RoomType roomType) {
		RoomType u = roomTypeDAO.get(roomType.getId());
		u.setType(roomType.getType());
		return u;
	}

	public void deleteInstance(RoomType roomType) {
		roomTypeDAO.delete(roomTypeDAO.get(roomType.getId()));
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			roomTypeDAO.delete(roomTypeDAO.get(id));
		}
	}

	public List<RoomType> getPageRoomType(Page page) {
		page.setTotalNum(roomTypeDAO.getCountByQuery("from RoomType"));
		return roomTypeDAO.findByPagination("from RoomType", page);
	}

	@Override
	public List<RoomType> getAllRoomType() {
		return roomTypeDAO.findAll();

	}
}
