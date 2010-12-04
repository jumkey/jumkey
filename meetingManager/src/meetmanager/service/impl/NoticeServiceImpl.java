package meetmanager.service.impl;

import java.util.Date;
import java.util.List;

import meetmanager.dao.NoticeDAO;
import meetmanager.dao.RoomTypeDAO;
import meetmanager.dao.SendNotificationPlanDAO;
import meetmanager.dao.UserDAO;
import meetmanager.model.Notice;
import meetmanager.model.RoomType;
import meetmanager.model.SendNotificationPlan;
import meetmanager.model.User;
import meetmanager.service.NoticeService;


public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO noticeDAO;
	private UserDAO userDAO;
	private RoomTypeDAO roomTypeDAO;
	private SendNotificationPlanDAO sendNotificationPlanDAO;

	public SendNotificationPlanDAO getSendNotificationPlanDAO() {
		return sendNotificationPlanDAO;
	}

	public void setSendNotificationPlanDAO(
			SendNotificationPlanDAO sendNotificationPlanDAO) {
		this.sendNotificationPlanDAO = sendNotificationPlanDAO;
	}

	public RoomTypeDAO getRoomTypeDAO() {
        return roomTypeDAO;
    }

    public void setRoomTypeDAO(RoomTypeDAO roomTypeDAO) {
        this.roomTypeDAO = roomTypeDAO;
    }

    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public NoticeDAO getNoticeDAO() {
		return noticeDAO;
	}

	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	public Notice updateInstance(Notice notice) {
	    Notice n = noticeDAO.get(notice.getId());
	    n.setDate(notice.getDate());
	    n.setNumber(notice.getNumber());
		return null;
	}

	public void addInstance(Notice notice) {
		noticeDAO.save(notice);
	}

	public List<Notice> getAllNotice() {
		return noticeDAO.findAll();
	}

	public Notice getNoticeById(Integer id) {
		return noticeDAO.get(id);
	}

	public List<User> getAllUser(Integer meetingid) {
		//列出所有没被通知到的人
		return userDAO.find("from User where id not in(select user.id from SendNotificationPlan where notice.meetingInfo.id="+meetingid+")");
	}

	public void dosend(Notice notice, Integer[] selected) {
		SendNotificationPlan snp=null;
		User user=new User();
		for(int i:selected){
			snp=new SendNotificationPlan();
			user.setId(i);
			snp.setNotice(notice);
			snp.setUser(user);
			sendNotificationPlanDAO.save(snp);
		}
	}

	public void doresp(SendNotificationPlan snp1) {
		SendNotificationPlan snp=sendNotificationPlanDAO.get(snp1.getId());
		snp.setIssingle(snp1.getIssingle());
		snp.setRoomtype(snp1.getRoomtype());
		snp.setReachflights(snp1.getReachflights());
		snp.setReachTrain(snp1.getReachTrain());
		snp.setReachtime(snp1.getReachtime());
		snp.setReachman(snp1.getReachman());
        snp.setReachphone(snp1.getReachphone());
		snp.setResponse("已回执");
		snp.setResponsedate(new Date());
		//snp.setSysaccount(sysaccount);回执记录人
	}

	public String checkusername(Integer id, String username) {
		StringBuffer ss=new StringBuffer("[");
		List<SendNotificationPlan> l = sendNotificationPlanDAO.find("select s from User u,SendNotificationPlan s where s.user.id=u.id and s.notice.id="+id+" and s.response=null and u.name LIKE '%"+username+"%'");
		for(SendNotificationPlan u:l){
			ss.append("{\"id\":\""+u.getId()+"\",\"name\":\""+u.getUser().getName()+"\"},");
		}
		ss.append("]");
		if(ss.length()-2!=0){
			ss.deleteCharAt(ss.length()-2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public Notice getNoticeByMeetingId(Integer id) {
		Notice n=null;
		List<Notice> l=noticeDAO.find("from Notice where meetingInfo.id="+id);
		if(l!=null&&l.size()!=0){
			n=l.get(0);
		}
		return n;
	}

    @Override
    public List<RoomType> getAllRoomType() {
        return roomTypeDAO.findAll();
    }
	
}
