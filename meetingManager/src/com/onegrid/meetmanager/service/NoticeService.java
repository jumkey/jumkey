package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Notice;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.model.SendNotificationPlan;
import com.onegrid.meetmanager.model.User;

public interface NoticeService {

	public Notice updateInstance(Notice notice);

	public void addInstance(Notice notice);

	public List<Notice> getAllNotice();

	public Notice getNoticeById(Integer id);

	public List<User> getAllUser(Integer meetingid);

	public void dosend(Notice notice, Integer[] selected);

	public void doresp(SendNotificationPlan snp);

	public String checkusername(Integer id, String username);

	public Notice getNoticeByMeetingId(Integer id);

    public List<RoomType> getAllRoomType();
}
