package meetmanager.service.impl;

import java.util.Date;
import java.util.List;

import meetmanager.dao.IncomeDAO;
import meetmanager.dao.MeetingFeeItemDAO;
import meetmanager.dao.MeetingInfoDAO;
import meetmanager.dao.OutlayDAO;
import meetmanager.dao.UnitsDAO;
import meetmanager.dao.UserDAO;
import meetmanager.model.Income;
import meetmanager.model.MeetingFeeItem;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Outlay;
import meetmanager.model.Units;
import meetmanager.model.User;
import meetmanager.service.PaymentService;


public class PaymentServiceImpl implements PaymentService {
	private MeetingInfoDAO meetingInfoDAO;
	private MeetingFeeItemDAO meetingFeeItemDAO;
	private IncomeDAO incomeDAO;
	private OutlayDAO outlayDAO;
	private UnitsDAO unitsDAO;
	private UserDAO userDAO;

	public UnitsDAO getUnitsDAO() {
		return unitsDAO;
	}

	public void setUnitsDAO(UnitsDAO unitsDAO) {
		this.unitsDAO = unitsDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public IncomeDAO getIncomeDAO() {
		return incomeDAO;
	}

	public void setIncomeDAO(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public OutlayDAO getOutlayDAO() {
		return outlayDAO;
	}

	public void setOutlayDAO(OutlayDAO outlayDAO) {
		this.outlayDAO = outlayDAO;
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public MeetingFeeItemDAO getMeetingFeeItemDAO() {
		return meetingFeeItemDAO;
	}

	public void setMeetingFeeItemDAO(MeetingFeeItemDAO meetingFeeItemDAO) {
		this.meetingFeeItemDAO = meetingFeeItemDAO;
	}

	public MeetingInfo getMeetingInfoById(Integer id) {
		return meetingInfoDAO.get(id);
	}

	public List<MeetingFeeItem> getAllMeetingFeeItem() {
		return meetingFeeItemDAO.findAll();
	}

	public void addIncome(Income income) {
		income.setDate(new Date());
		income.setCreatetime(new Date());
		income.setMeetingFeeItem(meetingFeeItemDAO.get(income.getMeetingFeeItem().getId()));// cascade="save-update"
		incomeDAO.save(income);
	}

	public void addOutlay(Outlay outlay) {
		outlay.setCreatetime(new Date());
		outlayDAO.save(outlay);
	}

	public String getStatistics(Integer id) {
		Double in=incomeDAO.getAllIncome(id);
		Double out=outlayDAO.getAllOutlay(id);
		return "{\"income\":\""+in+"\",\"outlay\":\""+out+"\",\"balance\":\""+(in-out)+"\"}";
	}

	public Income updateIncome(Income income) {
		Income in=incomeDAO.get(income.getId());
		in.setMeetingFeeItem(meetingFeeItemDAO.get(income.getMeetingFeeItem().getId()));// cascade="save-update"
		in.setMoney(income.getMoney());
		return in;
	}

	public Outlay updateOutlay(Outlay outlay) {
		Outlay out=outlayDAO.get(outlay.getId());
		out.setMeetingFeeItem(outlay.getMeetingFeeItem());
		out.setMoney(outlay.getMoney());
		return out;
	}

	public String checkunitsname(String username) {
		StringBuffer ss=new StringBuffer("[");
		//获取通知了的单位
		List<Units> l = unitsDAO.find("from Units where name LIKE '%"+username+"%'");
		for(Units u:l){
			ss.append("{\"id\":\""+u.getId()+"\",\"name\":\""+u.getName()+"\"},");
		}
		ss.append("]");
		if(ss.length()-2!=0){
			ss.deleteCharAt(ss.length()-2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public String checkusername(String username) {
		StringBuffer ss=new StringBuffer("[");
		//获取发送了通知并且回执的用户
		List<User> l = userDAO.find("from User where name LIKE '%"+username+"%'");
		for(User u:l){
			ss.append("{\"id\":\""+u.getId()+"\",\"name\":\""+u.getName()+"\"},");
		}
		ss.append("]");
		if(ss.length()-2!=0){
			ss.deleteCharAt(ss.length()-2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public void deleteIncome(Income income) {
		incomeDAO.delete(income);
	}

	public void deleteOutlay(Outlay outlay) {
		outlayDAO.delete(outlay);
	}

}
