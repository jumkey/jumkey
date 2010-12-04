package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Income;
import com.onegrid.meetmanager.model.MeetingInfo;
import com.onegrid.meetmanager.model.Reach;
import com.onegrid.meetmanager.model.Register;

public interface ReachService {
	public MeetingInfo getMeetingInfoById(Integer id);

	public String addInstance(Register register,Income income1, Income income2);

	public String checkuser(Integer userid,Integer meetingid);

	public String checkunits(Integer unitsid,Integer meetingid);

	public void addUnitsFee(Income income);

	public String checkunitsname(Integer perid, String username);
	
	/**
	 * @deprecated
	 * @param perid
	 * @param username
	 * @param jiashuname
	 * @param personalOptions
	 * @return
	 */
	public String checkusername(Integer perid, String username, String jiashuname,Integer personalOptions);
	public String checkusername_x(Integer perid, String username, String jiashuname,Integer personalOptions);

	public Register findRegister(Register register);

	public String checkreachedusername(Integer perid, String username);

	public void dofajiang(Register register);

	public void doyajin(Register register);

	public void doyaoshi(Register register);

	public void doqiandao(Register register);

	public void doziliao(Register register);

	public List<Reach> getReachsByMeetingId(Integer id);
}
