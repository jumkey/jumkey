package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.MeetingArrangementsDAO;
import com.onegrid.meetmanager.model.MeetingArrangements;
import com.onegrid.meetmanager.service.MeetingArrangementsService;


public class MeetingArrangementsServiceImpl implements MeetingArrangementsService{
	private MeetingArrangementsDAO meetingArrangementsDAO;

	public void setMeetingArrangementsDAO(MeetingArrangementsDAO meetingArrangementsDAO) {
		this.meetingArrangementsDAO = meetingArrangementsDAO;
	}

	public void addInstance(MeetingArrangements meetingArrangements) {
		meetingArrangementsDAO.save(meetingArrangements);
	}
	
	public List<MeetingArrangements> findMeetingArrangementsByMeetingId(Integer meetingid) {
		// TODO Auto-generated method stub
		return meetingArrangementsDAO.find("from MeetingArrangements where meetingInfo.id="+meetingid);
	}

	public void deleteInstance(MeetingArrangements meetingArrangements) throws Exception{
		meetingArrangements = meetingArrangementsDAO.get(meetingArrangements.getId());
		if(meetingArrangements.getId()!=null){
			meetingArrangementsDAO.delete(meetingArrangements);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		MeetingArrangements meetingArrangements=null;
		for (int id : selected) {
			meetingArrangements=meetingArrangementsDAO.get(id);
			if(meetingArrangements!=null){
				meetingArrangementsDAO.delete(meetingArrangements);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public MeetingArrangements updateInstance(MeetingArrangements meetingArrangements) throws Exception {
		MeetingArrangements fe = meetingArrangementsDAO.get(meetingArrangements.getId());
		if(fe.getId()!=null){
			fe.setTitle(meetingArrangements.getTitle());
			fe.setDate(meetingArrangements.getDate());
			fe.setDrawingtime(meetingArrangements.getDrawingtime());
			fe.setEndtime(meetingArrangements.getEndtime());
			fe.setHost(meetingArrangements.getHost());
			fe.setIntermission(meetingArrangements.getIntermission());
			fe.setMeetingInfo(meetingArrangements.getMeetingInfo());
			fe.setMeetingroom(meetingArrangements.getMeetingroom());
			fe.setRecorddate(meetingArrangements.getRecorddate());
			fe.setRecorder(meetingArrangements.getRecorder());
			fe.setStarttime(meetingArrangements.getStarttime());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

}
