package com.onegrid.meetmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.onegrid.meetmanager.dao.MeetingInfoDAO;
import com.onegrid.meetmanager.dao.RegisterDAO;
import com.onegrid.meetmanager.model.MeetingInfo;
import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.Register;
import com.onegrid.meetmanager.service.MeetingService;

public class MeetingServiceImpl implements MeetingService {
	private MeetingInfoDAO meetingInfoDAO;
	private RegisterDAO registerDAO;

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public void addInstance(MeetingInfo meeting) {
		meetingInfoDAO.save(meeting);
	}
	
	public List<MeetingInfo> findByMeetings() {
		return meetingInfoDAO.findByMeetings();
	}

	public void deleteInstance(MeetingInfo meetinginfo) throws Exception{
		meetinginfo = meetingInfoDAO.get(meetinginfo.getId());
		if(meetinginfo.getId()!=null){
			meetingInfoDAO.delete(meetinginfo);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		MeetingInfo mentinginf=null;
		for (int id : selected) {
			mentinginf=meetingInfoDAO.get(id);
			if(mentinginf!=null){
				meetingInfoDAO.delete(mentinginf);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public MeetingInfo updateInstance(MeetingInfo meetinginfo) throws Exception {
		MeetingInfo mentinginf = meetingInfoDAO.get(meetinginfo.getId());
		Price p=mentinginf.getPrice();
		p.setDate(meetinginfo.getPrice().getDate());
		p.setRegistTime(meetinginfo.getPrice().getRegistTime());
		p.setMeetingDays(meetinginfo.getPrice().getMeetingDays());
		mentinginf.setPrice(p);
		//mentinginf.setDate(meetinginfo.getDate());
		//mentinginf.setAuthor(meetinginfo.getAuthor());
		mentinginf.setAddress(meetinginfo.getAddress());
		mentinginf.setTitle(meetinginfo.getTitle());
		//mentinginf.setDesc1(meetinginfo.getDesc1());
		return mentinginf;
	}

	public List<Register> getRegisterByMeetingInfo(MeetingInfo meetinginfo) {
//		String s="from Register where user.id not in(select r.user.user.id from Register r where r.user.usertype='家属' and r.meetingid.id="+meetinginfo.getId()+") and user.usertype<>'家属' and meetingid.id="+meetinginfo.getId();
//		String ss="from Register where user.usertype='家属' and meetingid.id="+meetinginfo.getId();
//		List<Register> list1=registerDAO.find(s);
//		List<Register> list2=registerDAO.find(ss);
//		List<Register> list=new ArrayList<Register>();
//		list.addAll(list1);
//		list.addAll(list2);
		return registerDAO.find("from Register where meetingid.id="+meetinginfo.getId());
	}

	public MeetingInfo getMeetingInfo(Integer id) {
		return meetingInfoDAO.get(id);
	}

}
