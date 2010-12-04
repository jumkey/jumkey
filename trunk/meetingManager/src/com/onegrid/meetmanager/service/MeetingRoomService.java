package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.MeetingRoom;

public interface MeetingRoomService {

	public void addInstance(MeetingRoom meetingRoom);
	public List<MeetingRoom> findFetesByMeetingId(Integer meetingId);
	public void deleteInstance(MeetingRoom meetingRoom) throws Exception;
	public void deleteSelectInstance(Integer[] selected) throws Exception;
	public MeetingRoom updateInstance(MeetingRoom meetingRoom) throws Exception;

}
