package meetmanager.service;

import java.util.List;

import meetmanager.model.Notice;
import meetmanager.model.RoomType;
import meetmanager.model.SendNotificationPlan;
import meetmanager.model.User;


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
