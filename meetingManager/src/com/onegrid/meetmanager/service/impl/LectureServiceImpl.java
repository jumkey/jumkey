package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.LectureDAO;
import com.onegrid.meetmanager.model.Lecture;
import com.onegrid.meetmanager.service.LectureService;


public class LectureServiceImpl implements LectureService{
	private LectureDAO lectureDAO; 
	public LectureDAO getLectureDAO() {
		return lectureDAO;
	}

	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}

	public void addInstance(Lecture lecture) {
		lectureDAO.save(lecture);
	}
	
	public List<Lecture> findLectureByMeetingId(Integer meetingid) {
		// TODO Auto-generated method stub
		return lectureDAO.find("from Lecture where meetingInfo.id="+meetingid);
	}

	public void deleteInstance(Lecture lecture) throws Exception{
		lecture = lectureDAO.get(lecture.getId());
		if(lecture.getId()!=null){
			lectureDAO.delete(lecture);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Lecture meetingRoom=null;
		for (int id : selected) {
			meetingRoom=lectureDAO.get(id);
			if(meetingRoom!=null){
				lectureDAO.delete(meetingRoom);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
	}

	public Lecture updateInstance(Lecture lecture) throws Exception {
		Lecture fe = lectureDAO.get(lecture.getId());
		if(fe.getId()!=null){
			fe.setAgreement(lecture.getAgreement());
			fe.setExpertsfee(lecture.getExpertsfee());
			fe.setUnits(lecture.getUnits());
			fe.setSubject(lecture.getSubject());
			fe.setSpeakers(lecture.getSpeakers());
			fe.setSeminarfee(lecture.getSeminarfee());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

}
