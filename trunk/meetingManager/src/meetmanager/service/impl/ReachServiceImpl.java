package meetmanager.service.impl;

import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import meetmanager.dao.IncomeDAO;
import meetmanager.dao.LotteryDAO;
import meetmanager.dao.MeetingInfoDAO;
import meetmanager.dao.RegisterDAO;
import meetmanager.dao.SendNotificationPlanDAO;
import meetmanager.dao.UnitsDAO;
import meetmanager.dao.UserDAO;
import meetmanager.model.Income;
import meetmanager.model.Lottery;
import meetmanager.model.MeetingInfo;
import meetmanager.model.Reach;
import meetmanager.model.Register;
import meetmanager.model.RoomType;
import meetmanager.model.SendNotificationPlan;
import meetmanager.model.Units;
import meetmanager.model.User;
import meetmanager.service.ReachService;
import meetmanager.utils.RandomAwardToolkits;


public class ReachServiceImpl implements ReachService {
	private MeetingInfoDAO meetingInfoDAO;
	private SendNotificationPlanDAO sendNotificationPlanDAO;
	private UserDAO userDAO;
	private UnitsDAO unitsDAO;
	private RegisterDAO registerDAO;
	private LotteryDAO lotteryDAO;
	private IncomeDAO incomeDAO;

	public UnitsDAO getUnitsDAO() {
		return unitsDAO;
	}

	public void setUnitsDAO(UnitsDAO unitsDAO) {
		this.unitsDAO = unitsDAO;
	}

	public IncomeDAO getIncomeDAO() {
		return incomeDAO;
	}

	public void setIncomeDAO(IncomeDAO incomeDAO) {
		this.incomeDAO = incomeDAO;
	}

	public MeetingInfoDAO getMeetingInfoDAO() {
		return meetingInfoDAO;
	}

	public void setMeetingInfoDAO(MeetingInfoDAO meetingInfoDAO) {
		this.meetingInfoDAO = meetingInfoDAO;
	}

	public void setSendNotificationPlanDAO(
			SendNotificationPlanDAO sendNotificationPlanDAO) {
		this.sendNotificationPlanDAO = sendNotificationPlanDAO;
	}

	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public LotteryDAO getLotteryDAO() {
		return lotteryDAO;
	}

	public void setLotteryDAO(LotteryDAO lotteryDAO) {
		this.lotteryDAO = lotteryDAO;
	}

	private String getMD5(byte[] source) {
		String s = null;
		// 用来将字节转换成 16 进制表示的字符
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public String addInstance(Register register, Income income1, Income income2) {
		// String
		// ss=getMD5(register.getUser().getId().toString().getBytes())+getMD5(new
		// Date().toString().getBytes());
		// register.setCode(getMD5(ss.getBytes()));// 生成卡号
		register.setChargeDate(new Date());
		String award = String.valueOf(RandomAwardToolkits.next());
		register.setAward(award);
		registerDAO.save(register);

		if (!"家属".equals(register.getUser().getUsertype())
				&& register.getUserName().equals(register.getUser().getName())) {
			Lottery l = new Lottery();
			l.setMeetingInfo(register.getMeetingid());
			l.setOwner(register.getUser());
			l.setCreatedate(new Date());
			lotteryDAO.save(l);
		}

		if (income1.getMoney() != null) {
			incomeDAO.saveOrUpdate1(income1);// cascade="save-update"
		}
		if (income2.getMoney() != null) {
			incomeDAO.saveOrUpdate1(income2);// cascade="save-update"
		}
		
		return award;
	}

	public MeetingInfo getMeetingInfoById(Integer id) {
		return meetingInfoDAO.get(id);
	}

	public String checkuser(Integer userid, Integer meetingid) {
		User user = userDAO.get(userid);
		if (user == null) {
			return "{\"payed\":\"false\",\"success\":\"false\",\"info\":\"没有得到用户信息\"}";
		} else if (user.getUnits() == null) {
			return "{\"payed\":\"false\",\"success\":\"true\",\"info\":\""
					+ user.getName() + "\"}";
		} else {
			List<Income> list = incomeDAO
					.find("from Income where meetingFeeItem.meetingInfo.id="
							+ meetingid + " and units.id="
							+ user.getUnits().getId());
			if (list != null && list.size() != 0) {
				return "{\"payed\":\"true\",\"success\":\"true\",\"info\":\""
						+ user.getName() + "\"}";
			}
			return "{\"payed\":\"false\",\"success\":\"true\",\"info\":\""
					+ user.getName() + "\"}";
		}
	}

	public String checkunits(Integer unitsid, Integer meetingid) {
		Units units = unitsDAO.get(unitsid);
		if (units == null) {
			return "{\"success\":\"false\",\"info\":\"没有得到单位信息\"}";
		} else {
			return "{\"success\":\"true\",\"info\":\"" + units.getName()
					+ "\"}";
		}
	}

	public void addUnitsFee(Income income) {
		incomeDAO.save(income);// cascade="save-update"
	}

	public String checkunitsname(Integer id, String username) {
		StringBuffer ss = new StringBuffer("[");
		// 获取通知了的单位
		List<Units> l = unitsDAO
				.find("select s.units from SendNotificationPlan s,Notice n where s.notice.id=n.id and n.meetingInfo.id="
						+ id + " and s.units.name LIKE '%" + username + "%'");
		for (Units u : l) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	/**
	 * 这个方法只能获取发送了通知并且回执的用户
	 * 
	 * @see checkusername_x
	 * 
	 * @deprecated
	 */
	public String checkusername(Integer id, String username, String jiashuname,
			Integer personalOptions) {
		StringBuffer ss = new StringBuffer("[");
		// 获取发送了通知并且回执的用户
		List<User> l = null;
		if (personalOptions == 2) {
			// ? 这个是否有问题的SQL ?
			l = userDAO
					.find("select s.user from SendNotificationPlan s,Notice n where s.notice.id=n.id and n.meetingInfo.id="
							+ id
							+ " and s.response<>null and s.user.name = '"
							+ username
							+ "' and s.user.user.name= '"
							+ jiashuname + "'");
		} else {
			l = userDAO
					.find("select s.user from SendNotificationPlan s,Notice n where s.notice.id=n.id and n.meetingInfo.id="
							+ id
							+ " and s.response<>null and s.user.name LIKE '%"
							+ username + "%'");
		}
		for (User u : l) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\",\"unitsid\":\"" + u.getUnits().getId()
					+ "\",\"unitsname\":\"" + u.getUnits().getName() + "\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public String checkusername_x(Integer id, String username,
			String jiashuname, Integer personalOptions) {
		StringBuffer ss = new StringBuffer("[");
		// 在通知库中首先获取已回执用户列表
		List<SendNotificationPlan> l0 = sendNotificationPlanDAO
				.find("select s from SendNotificationPlan s,Notice n where s.notice.id=n.id and n.meetingInfo.id="
						+ id
						+ " and s.response<>null and s.user.name LIKE '%"
						+ username + "%' and s.user.user is null");
		for (SendNotificationPlan sp : l0) {
			User u = sp.getUser();
			Integer housenumber = sp.getHousenumber();
			Integer issingle = sp.getIssingle();
			RoomType roomtype = sp.getRoomtype();
			ss.append("{\"id\":\""
					+ u.getId()
					+ "\",\"name\":\""
					+ u.getName()
					+ "\",\"unitsid\":\""
					+ u.getUnits().getId()
					+ "\",\"unitsname\":\""
					+ u.getUnits().getName()
					+ "\",\"notice\":\"1\""
					+ (housenumber == null ? "" : (",\"notice_housenumber\":\""
							+ housenumber + "\""))
					+ (issingle == null ? "" : (",\"notice_issingle\":\""
							+ issingle + "\""))
					+ (roomtype == null ? "" : (",\"notice_roomtype\":\""
							+ roomtype.getType() + "\"")) + "},");
		}
		// 在总库中查找且当前用户不是亲属且没有回执
		List<User> l1 = userDAO
				.find("from User s where s.name LIKE '%"
						+ username
						+ "%' and s.user is null and s.id not in (select t.user.id from SendNotificationPlan t,Notice n where t.notice.id=n.id and n.meetingInfo.id="
						+ id + " and t.response<>null)");
		for (User u : l1) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\",\"unitsid\":\"" + u.getUnits().getId()
					+ "\",\"unitsname\":\"" + u.getUnits().getName()
					+ "\",\"notice\":\"0\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public Register findRegister(Register register) {
		List<Register> lr = registerDAO
				.find("from Register where meetingid.id="
						+ register.getMeetingid().getId() + " and user.id="
						+ register.getUser().getId());
		Register r = null;
		if (lr != null && lr.size() != 0) {
			r = lr.get(0);
		}
		return r;
	}

	public String checkreachedusername(Integer id, String username) {
		StringBuffer ss = new StringBuffer("[");
		// 获取发送了通知并且回执的用户
		List<User> l = userDAO
				.find("select r.user from Register r where r.meetingid.id="
						+ id + " and r.user.name LIKE '%" + username + "%'");
		for (User u : l) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public void dofajiang(Register register) {
		Register r = getRegister(register);
		registerDAO.save(r);

		if (!"家属".equals(r.getUser().getUsertype())) {
			Lottery l = new Lottery();
			l.setMeetingInfo(r.getMeetingid());
			l.setOwner(r.getUser());
			l.setCreatedate(new Date());
			lotteryDAO.save(l);
			r.setAward(l.getId().toString());
		} else {
			throw new RuntimeException("亲属不能发奖");
		}

	}

	public void doyajin(Register register) {
		Register r = getRegister(register);
		r.setDeposit(register.getDeposit());
		r.setDepositDate(new Date());
		registerDAO.save(r);
	}

	public void doyaoshi(Register register) {
		Register r = getRegister(register);
		r.setRoomNo(register.getRoomNo());
		registerDAO.save(r);
	}

	public void doqiandao(Register register) {
		Register r = getRegister(register);
		r.setSign(register.getSign());
		r.setReachDate(new Date());
		registerDAO.save(r);
	}

	public void doziliao(Register register) {
		Register r = getRegister(register);
		r.setReceive(register.getReceive());
		registerDAO.save(r);
	}

	public Register getRegister(Register register) {
		List<Register> l = registerDAO.find("from Register where meetingid.id="
				+ register.getMeetingid().getId() + " and user.id="
				+ register.getUser().getId());
		Register r = null;
		if (l != null && l.size() != 0) {
			r = l.get(0);
		} else {
			throw new RuntimeException("未找到相关记录");
		}
		return r;
	}

	@Override
	public List<Reach> getReachsByMeetingId(Integer id) {
		List<Reach> l = registerDAO
				.findReachs("select new meetmanager.model.Reach(i, s, r) "
						+ "from SendNotificationPlan s,Income i,Register r "
						+ "where s.user.id=r.user.id and i.user.id=r.user.id "
						+ "and s.notice.meetingInfo.id=i.meetingFeeItem.meetingInfo.id "
						+ "and i.meetingFeeItem.meetingInfo.id=r.meetingid.id "
						+ "and r.meetingid.id=" + id);
		return l;
	}
}
