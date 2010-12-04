package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.FeeItemDAO;
import com.onegrid.meetmanager.dao.MeetingFeeItemDAO;
import com.onegrid.meetmanager.dao.MeetingInfoDAO;
import com.onegrid.meetmanager.model.FeeItem;
import com.onegrid.meetmanager.model.MeetingFeeItem;
import com.onegrid.meetmanager.model.MeetingInfo;
import com.onegrid.meetmanager.service.MeetingFeeItemService;

public class MeetingFeeItemServiceImpl implements MeetingFeeItemService {
	private MeetingFeeItemDAO meetingFeeItemDAO;
	private FeeItemDAO feeItemDAO;
	private MeetingInfoDAO meetingInfoDAO;

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public FeeItemDAO getFeeItemDAO() {
		return feeItemDAO;
	}

	public void setFeeItemDAO(FeeItemDAO feeItemDAO) {
		this.feeItemDAO = feeItemDAO;
	}

	public MeetingFeeItemDAO getMeetingFeeItemDAO() {
		return meetingFeeItemDAO;
	}

	public void setMeetingFeeItemDAO(MeetingFeeItemDAO meetingFeeItemDAO) {
		this.meetingFeeItemDAO = meetingFeeItemDAO;
	}

	public void addInstance(MeetingFeeItem meetingfeeitem) {
		meetingFeeItemDAO.save(meetingfeeitem);
	}

	public void deleteInstance(MeetingFeeItem meetingfeeitem) {
		meetingFeeItemDAO.delete(meetingfeeitem);
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			meetingFeeItemDAO.delete(meetingFeeItemDAO.get(id));
		}
	}

	public MeetingFeeItem updateInstance(MeetingFeeItem meetingfeeitem) {
		MeetingFeeItem sysa = meetingFeeItemDAO.get(meetingfeeitem.getId());
		// PropertyUtils.copyProperties
		// BeanUtils.copyProperties(sysa, account);
		sysa.setFeeItem(feeItemDAO.get(meetingfeeitem.getFeeItem().getId()));
		sysa.setMoney(meetingfeeitem.getMoney());
		return sysa;
	}

	public List<MeetingFeeItem> getAllMeetingFeeItem() {
		return meetingFeeItemDAO.findAll();
	}

	public MeetingInfo getMeetingInfo(Integer meetingid) {
		return meetingInfoDAO.get(meetingid);
	}

	public List<FeeItem> getAllFeeItem() {
		return feeItemDAO.findAll();
	}

}
