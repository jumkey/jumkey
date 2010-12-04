package com.onegrid.meetmanager.service.impl;

import java.util.Date;
import java.util.List;

import com.onegrid.meetmanager.dao.AgreementDAO;
import com.onegrid.meetmanager.dao.FeeItemDAO;
import com.onegrid.meetmanager.dao.MeetingFeeItemDAO;
import com.onegrid.meetmanager.dao.MeetingInfoDAO;
import com.onegrid.meetmanager.dao.PriceDAO;
import com.onegrid.meetmanager.model.Agreement;
import com.onegrid.meetmanager.model.FeeItem;
import com.onegrid.meetmanager.model.MeetingFeeItem;
import com.onegrid.meetmanager.model.MeetingInfo;
import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.Units;
import com.onegrid.meetmanager.service.AgreementService;

public class AgreementServiceImpl implements AgreementService {
	private AgreementDAO agreementDAO;
	private MeetingInfoDAO meetingInfoDAO;
	private PriceDAO priceDAO;
	private FeeItemDAO feeItemDAO;
	private MeetingFeeItemDAO meetingFeeItemDAO;

	public MeetingFeeItemDAO getMeetingFeeItemDAO() {
		return meetingFeeItemDAO;
	}

	public void setMeetingFeeItemDAO(MeetingFeeItemDAO meetingFeeItemDAO) {
		this.meetingFeeItemDAO = meetingFeeItemDAO;
	}

	public FeeItemDAO getFeeItemDAO() {
		return feeItemDAO;
	}

	public void setFeeItemDAO(FeeItemDAO feeItemDAO) {
		this.feeItemDAO = feeItemDAO;
	}

	public PriceDAO getPriceDAO() {
		return priceDAO;
	}

	public void setPriceDAO(PriceDAO priceDAO) {
		this.priceDAO = priceDAO;
	}

	public AgreementDAO getAgreementDAO() {
		return agreementDAO;
	}

	public void setAgreementDAO(AgreementDAO agreementDAO) {
		this.agreementDAO = agreementDAO;
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public void addInstance(Price price,MeetingInfo meeting) {
		
	}

	public void deleteInstance(Units operator,Price price) throws Exception {
		
	}

	public void deleteSelectInstance(Units operator,Integer[] selected) throws Exception {
		
	}

	public List<Agreement> getAllAgreement() {
		return agreementDAO.findAll();
	}

	public Agreement updateInstance(Agreement agreement) {
		Agreement am = agreementDAO.get(agreement.getId());
		
		MeetingInfo mm=am.getMeetingInfo();
		mm.setTitle(agreement.getMeetingInfo().getTitle());
		mm.setAuthor(agreement.getMeetingInfo().getAuthor());
		
		am.setTravelContact(agreement.getTravelContact());
		am.setTravelPhone(agreement.getTravelPhone());
		am.setHotelContacts(agreement.getHotelContacts());
		am.setHotelPhone(agreement.getHotelPhone());
		am.setHoteldeposit(agreement.getHoteldeposit());
		return am;
	}

	public void addInstance(Agreement agreement) {
		//两步走 先保存会议 再合同
		MeetingInfo mm=agreement.getMeetingInfo();
		Price pp=priceDAO.get(mm.getPrice().getId());
		meetingInfoDAO.save(mm);
		mm.setAddress(pp.getAddress());
		mm.setDate(pp.getDate());
		mm.setDesc1(pp.getTravel());
		
		//拷贝费项
		MeetingFeeItem mfi=null;
		List<FeeItem> l=feeItemDAO.findAll();
		for(FeeItem f:l){
			mfi=new MeetingFeeItem();
			mfi.setFeeItem(f);
			mfi.setMeetingInfo(mm);
			mfi.setCreatetime(new Date());
			
			meetingFeeItemDAO.save(mfi);
		}
		
		agreement.setDate(pp.getRegistTime());
		agreement.setMdate(pp.getDate());
		agreementDAO.save(agreement);
	}

	public Agreement getInstance(Agreement agreement) {
		Agreement a=null;
		List<Agreement> l=agreementDAO.find("from Agreement where meetingInfo.price.id="+agreement.getMeetingInfo().getPrice().getId());
		if(l!=null&&l.size()!=0){
			a=l.get(0);
		}
		return a;
	}

}
