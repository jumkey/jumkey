package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.ArrangementsSeminarsDAO;
import com.onegrid.meetmanager.model.ArrangementsSeminars;
import com.onegrid.meetmanager.service.ArrangementsSeminarsService;



public class ArrangementsSeminarsServiceImpl implements ArrangementsSeminarsService{
	private ArrangementsSeminarsDAO arrangementsSeminarsDAO;

	public void setArrangementsSeminarsDAO(ArrangementsSeminarsDAO arrangementsSeminarsDAO) {
		this.arrangementsSeminarsDAO = arrangementsSeminarsDAO;
	}

	public void addInstance(ArrangementsSeminars arrangementsSeminars) {
		arrangementsSeminarsDAO.save(arrangementsSeminars);
	}
	
	public List<ArrangementsSeminars> findArrangementsSeminarsByArrangementId(Integer arrangementsId) {
		// TODO Auto-generated method stub
		return arrangementsSeminarsDAO.find("from ArrangementsSeminars where meetingArrangements.id="+arrangementsId+" order by number asc");
	}

	public void deleteInstance(ArrangementsSeminars arrangementsSeminars) throws Exception{
		arrangementsSeminars = arrangementsSeminarsDAO.get(arrangementsSeminars.getId());
		if(arrangementsSeminars.getId()!=null){
			arrangementsSeminarsDAO.delete(arrangementsSeminars);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		ArrangementsSeminars arrangementsSeminars=null;
		for (int id : selected) {
			arrangementsSeminars=arrangementsSeminarsDAO.get(id);
			if(arrangementsSeminars!=null){
				arrangementsSeminarsDAO.delete(arrangementsSeminars);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public ArrangementsSeminars updateInstance(ArrangementsSeminars arrangementsSeminars) throws Exception {
		ArrangementsSeminars fe = arrangementsSeminarsDAO.get(arrangementsSeminars.getId());
		if(fe.getId()!=null){
			fe.setLecture(arrangementsSeminars.getLecture());
			fe.setMeetingArrangements(arrangementsSeminars.getMeetingArrangements());
			fe.setNumber(arrangementsSeminars.getNumber());
			fe.setRecorddate(arrangementsSeminars.getRecorddate());
			fe.setRecorder(arrangementsSeminars.getRecorder());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

}
