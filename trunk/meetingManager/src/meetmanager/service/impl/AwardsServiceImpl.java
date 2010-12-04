package meetmanager.service.impl;

import java.util.ArrayList;
import java.util.List;

import meetmanager.dao.AwardsDAO;
import meetmanager.dao.LotteryDAO;
import meetmanager.dao.LotteryRecordDAO;
import meetmanager.dao.MeetingInfoDAO;
import meetmanager.dao.UnitsDAO;
import meetmanager.model.Awards;
import meetmanager.model.Lottery;
import meetmanager.model.LotteryRecord;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Units;
import meetmanager.service.AwardsService;



public class AwardsServiceImpl implements AwardsService{
	private LotteryDAO lotteryDAO;
	private LotteryRecordDAO lotteryRecordDAO;
	private AwardsDAO awardsDAO;
	private UnitsDAO unitsDAO;
	private MeetingInfoDAO meetingInfoDAO;

	public UnitsDAO getUnitsDAO() {
		return unitsDAO;
	}

	public void setUnitsDAO(UnitsDAO unitsDAO) {
		this.unitsDAO = unitsDAO;
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public LotteryRecordDAO getLotteryRecordDAO() {
		return lotteryRecordDAO;
	}

	public void setLotteryRecordDAO(LotteryRecordDAO lotteryRecordDAO) {
		this.lotteryRecordDAO = lotteryRecordDAO;
	}

	public LotteryDAO getLotteryDAO() {
		return lotteryDAO;
	}

	public void setLotteryDAO(LotteryDAO lotteryDAO) {
		this.lotteryDAO = lotteryDAO;
	}

	public AwardsDAO getAwardsDAO() {
		return awardsDAO;
	}

	public void setAwardsDAO(AwardsDAO awardsDAO) {
		this.awardsDAO = awardsDAO;
	}

	public void addInstance(Awards awards) {
		awardsDAO.save(awards);
	}
	
	public List<Awards> findAwardsByMeetingId(Integer meetingid) {
		return awardsDAO.find("from Awards where meetingInfo.id="+meetingid);
	}

	public void deleteInstance(Awards awards) throws Exception{
		awards = awardsDAO.get(awards.getId());
		if(awards.getId()!=null){
			awardsDAO.delete(awards);
		}else{
			throw new Exception("此记录不是你创建");
		}
		
	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Awards awards=null;
		for (int id : selected) {
			awards=awardsDAO.get(id);
			if(awards!=null){
				awardsDAO.delete(awards);
			}else{
				throw new Exception("删除的记录有的不是你创建");
			}
		}
		
	}

	public Awards updateInstance(Awards awards) throws Exception {
		Awards fe = awardsDAO.get(awards.getId());
		if(fe.getId()!=null){
			fe.setGuest(awards.getGuest());
			fe.setHost(awards.getHost());
			fe.setName(awards.getName());
			fe.setUnitstype(awards.getUnitstype());
			fe.setUsertype(awards.getUsertype());
			fe.setShieldunits(awards.getShieldunits());
			fe.setShielduser(awards.getShielduser());
			fe.setValue(awards.getValue());
			fe.setUnits(awards.getUnits());
			fe.setRemarks(awards.getRemarks());
			fe.setExpenses(awards.getExpenses());
			fe.setMeetingArrangements(awards.getMeetingArrangements());
			return fe;
		}else{
			throw new Exception("此记录不是你创建");
		}
	}

	public Awards findAwardsById(Integer awardsid) {
		 return awardsDAO.get(awardsid);
	}

	public String dochoujiang(Integer meetingId,Integer[] id) {
		String [] allWinners = new String[id.length];
		
		List<Lottery> llist = lotteryDAO.find("from Lottery where meetingInfo.id="+meetingId);
		for(int v=0;v<id.length;v++){
			Awards awards = awardsDAO.get(id[v]);
			StringBuffer sb=new StringBuffer();
			int zj=0;
			Lottery lottery;
			boolean flag=true;//标记是否抽奖成功 默认成功
			
				flag=true;
				List<Lottery> llist1=new ArrayList<Lottery>();
				
				llist1.addAll(llist);//拷贝一个奖券组
				for(;;){
					if(llist1.size()==0){//奖券选完
						break;
					}
					zj=(int) (Math.random()*llist1.size());//生成随机index
					lottery=llist1.get(zj);//得到奖券
					
					if(llist.size()==0||awards==null){
						allWinners[v] = "○-1●-1●"+lottery.getOwner().getName();
						break;
					}
					//--------------------------------------------
					String[] shielduser = awards.getShielduser().split(",");
					String[] shieldunits = awards.getShieldunits().split(",");
					String[] usertype = awards.getUsertype().split(",");
					String[] unitstype = awards.getUnitstype().split(",");
					
					for(String ut:unitstype){//判断是否在可抽奖单位类型里
						if(ut.equals(""+lottery.getOwner().getUnits().getUnitsType().getId())){
							flag=true;
							break;
						}
						flag=false;
					}
					if(flag){
						for(String ut2:usertype){//判断是否在可抽奖用户类型里
							if(ut2.equals(""+lottery.getOwner().getUsertype())){
								flag=true;
								break;
							}
							flag=false;
						}
					}
					if(flag){
						for(String ut3:shieldunits){//判断是否在屏蔽单位列表里
							if(ut3.equals(""+lottery.getOwner().getUnits().getId())){
								flag=false;
								break;
							}
							flag=true;
						}
					}
					if(flag){
						for(String ut4:shielduser){//判断是否在屏蔽个人列表里
							if(ut4.equals(""+lottery.getOwner().getId())){
								flag=false;
								break;
							}
							flag=true;
						}
					}
					//--------------------------------------------
					if(flag){
						//add
						LotteryRecord lotteryRecord=new LotteryRecord();
						lotteryRecord.setAwards(awards);
						lotteryRecord.setLottery(lottery);
						lotteryRecordDAO.save(lotteryRecord);
						sb.append("○"+awards.getName()+"●"+lottery.getOwner().getId()+"●"+lottery.getOwner().getName());
						break;
					}else {
						llist1.remove(zj);//副本移除
					}
					
				}
			allWinners[v]=sb.toString();
		}
		String allwin = "";
		for(int i=0;i<allWinners.length;i++){
			allwin=allwin+allWinners[i];
		}
		System.out.println(allwin);
		return allwin;
	}

	public MeetingInfo findMeetingInfoById(Integer id) {
		return meetingInfoDAO.get(id);
	}

	public List<Units> findAllUnits() {
		return unitsDAO.findAll();
	}

}
