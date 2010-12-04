package com.onegrid.meetmanager.service.impl;

import java.util.List;
import com.onegrid.meetmanager.service.MeetingRoomService;
import com.onegrid.meetmanager.dao.MeetingRoomDAO;
import com.onegrid.meetmanager.model.MeetingRoom;

public class MeetingRoomServiceImpl implements MeetingRoomService{
	private MeetingRoomDAO meetingRoomDAO; 
	public MeetingRoomDAO getMeetingRoomDAO() {
		return meetingRoomDAO;
	}

	public void setMeetingRoomDAO(MeetingRoomDAO meetingRoomDAO) {
		this.meetingRoomDAO = meetingRoomDAO;
	}

	public void addInstance(MeetingRoom meetingRoom) {
		meetingRoomDAO.save(meetingRoom);
	}
	
	public List<MeetingRoom> findFetesByMeetingId(Integer meetingid) {
		// TODO Auto-generated method stub
		return meetingRoomDAO.find("from MeetingRoom where meetingInfo.id="+meetingid);
	}

	public void deleteInstance(MeetingRoom meetingRoom) throws Exception{
		meetingRoom = meetingRoomDAO.get(meetingRoom.getId());
		if(meetingRoom.getId()!=null){
			meetingRoomDAO.delete(meetingRoom);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		MeetingRoom meetingRoom=null;
		for (int id : selected) {
			meetingRoom=meetingRoomDAO.get(id);
			if(meetingRoom!=null){
				meetingRoomDAO.delete(meetingRoom);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public MeetingRoom updateInstance(MeetingRoom meetingRoom) throws Exception {
		MeetingRoom fe = meetingRoomDAO.get(meetingRoom.getId());
		if(fe.getId()!=null){
			fe.setAddress(meetingRoom.getAddress());
			fe.setName(meetingRoom.getName());
			fe.setBackplane(meetingRoom.getBackplane());
			fe.setFruit(meetingRoom.getFruit());
			fe.setHost(meetingRoom.getHost());
			fe.setNumber(meetingRoom.getNumber());
			fe.setWireless(meetingRoom.getWireless());
			fe.setWired(meetingRoom.getWired());
			fe.setVideo(meetingRoom.getVideo());
			fe.setTea(meetingRoom.getTea());
			fe.setScroll(meetingRoom.getScroll());
			fe.setRecording(meetingRoom.getRecording());
			fe.setProjector(meetingRoom.getProjector());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

}
