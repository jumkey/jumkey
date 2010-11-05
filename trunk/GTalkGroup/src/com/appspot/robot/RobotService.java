package com.appspot.robot;

import com.appspot.common.AccountType;
import com.appspot.common.DateHelp;
import com.appspot.common.SysLogType;
import com.appspot.persistence.Account;
import com.appspot.persistence.SysLog;
import com.appspot.persistence.SysLogDao;
import com.appspot.persistence.TwitterNotify;
import com.appspot.persistence.TwitterNotifyDao;
import com.appspot.persistence.User;
import com.appspot.persistence.UserDao;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.xmpp.Message;

/**
 * 机器人服务类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class RobotService {
	private RobotService() {
	}

	private static RobotService instance = null;

	public static synchronized RobotService getInstance() {
		if (instance == null) {
			instance = new RobotService();
		}
		return instance;
	}

	/**
	 * 根据用户ID获取用户
	 * 
	 * @param UserId，用户ID
	 * @return，符合条件的用户
	 */
	public User getUserByUserId(String userId) {
		User user = UserDao.getInstance().getByUserId(userId);
		if (user != null) {
			user.setAccountList(UserDao.getInstance().getUserAccountList(user));
		}
		return user;
	}

	/**
	 * 添加一个新用户
	 * 
	 * @param userId，用户ID
	 * @return，添加的用户实体
	 */
	public User newUser(String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUserPwd("000000");
		user.setIsInUse(true);
		user.setPushCount(0);
		user.setStartTime(DateHelp.getLocalDateTime());
		user.setLastActiveTime(DateHelp.getLocalDateTime());
		UserDao.getInstance().addOrUpdateUser(user);
		return user;
	}

	/**
	 * 取消所有绑定
	 * 
	 * @param message，用户发送的message
	 * @param user，用户实体
	 */
	public void doRemove(Message message, User user) {
		String accountNames = user.getAccountNames();
		user.setAccountList(null);
		SysLog log = new SysLog();
		if (UserDao.getInstance().deleteUserAccountList(user.getUserId())) {
			RobotMsg.getInstance().sendMessage(message, RobotMsg.RemoveSuc);
			log
					.setLogContent(new Text(accountNames + "@"
							+ RobotMsg.RemoveSuc));
		} else {
			RobotMsg.getInstance().sendMessage(message, RobotMsg.RemoveFail);
			log
					.setLogContent(new Text(accountNames + "@"
							+ RobotMsg.RemoveFail));
		}

		// 更新用户信息
		user.setLastActiveTime(DateHelp.getLocalDateTime());
		UserDao.getInstance().addOrUpdateUser(user);

		// 更新Twitter消息提示
		TwitterNotify twitterNotify = TwitterNotifyDao.getInstance()
				.getByUserId(user.getUserId());
		if (twitterNotify != null) {
			twitterNotify.setIsNotify(false);
			TwitterNotifyDao.getInstance().addOrUpdateTwitterNotify(
					twitterNotify);
		}

		// 写系统日志
		log.setUserId(user.getUserId());
		log.setLogTime(DateHelp.getLocalDateTime());
		log.setLogType(SysLogType.doRemove);
		SysLogDao.getInstance().addSysLog(log);
	}

	/**
	 * 查看用户绑定账号信息
	 * 
	 * @param message，用户发送的message
	 * @param user，用户实体
	 */
	public void doStatus(Message message, User user) {
		if (user.getAccountList().size() == 0) {
			RobotMsg.getInstance().sendMessage(message, RobotMsg.NotBind);
			return;
		}
		StringBuffer userInfo = new StringBuffer();
		userInfo.append(RobotMsg.StatusHead);
		for (Account account : user.getAccountList()) {
			switch (account.getAccountType()) {
			case AccountType.TWITTER:
				userInfo.append(AccountType.TWITTERNAME);
				break;
			case AccountType.SINA:
				userInfo.append(AccountType.SINANAME);
				break;
			case AccountType.RENREN:
				userInfo.append(AccountType.RENRENNAME);
				break;
			case AccountType.DIGU:
				userInfo.append(AccountType.DIGUNAME);
				break;
			case AccountType.ZUOSA:
				userInfo.append(AccountType.ZUOSANAME);
				break;
			}
			userInfo.append("-");
			userInfo.append(account.getUserName());
			if (account.getIsAuth()) {
				userInfo.append("\n");
			} else {
				userInfo.append("(未验证)\n");
			}
		}
		RobotMsg.getInstance().sendMessage(message, userInfo.toString());

		// 更新用户信息
		user.setLastActiveTime(DateHelp.getLocalDateTime());
		UserDao.getInstance().addOrUpdateUser(user);
	}

	/**
	 * 设置Twitter消息提示
	 * 
	 * @param message，用户发送的message
	 * @param user，用户实体
	 * @param isNotify，打开/关闭消息提示
	 */
	public void doTwitterNotifyChange(Message message, User user,
			boolean isNotify) {
		TwitterNotify twitterNotify = TwitterNotifyDao.getInstance()
				.getByUserId(user.getUserId());

		// 没有设置消息提示时取消消息提示操作
		if (twitterNotify == null && !isNotify) {
			RobotMsg.getInstance().sendMessage(message,
					RobotMsg.NotSetTwitterNotify);
			return;
		}

		// 若为打开消息提示
		if (isNotify) {
			// 还没有设置过消息提示
			if (twitterNotify == null) {
				twitterNotify = new TwitterNotify();
				twitterNotify.setUserId(user.getUserId());
				twitterNotify.setLastNotifyMsgId(0);
				twitterNotify.setNotifyCount(0);
			}
			boolean find = false;
			for (Account account : user.getAccountList()) {
				if (account.getAccountType() == AccountType.TWITTER
						&& account.getIsAuth()) {
					twitterNotify.setUserJID(message.getFromJid().getId());
					twitterNotify.setUserName(account.getUserName());
					twitterNotify.setUserPwd(account.getUserPwd());
					find = true;
					break;
				}
			}
			if (!find) {
				RobotMsg.getInstance().sendMessage(message,
						RobotMsg.NotBindTwitter);
				return;
			}
		}
		twitterNotify.setIsNotify(isNotify);
		TwitterNotifyDao.getInstance().addOrUpdateTwitterNotify(twitterNotify);

		String result = "";
		if (isNotify)
			result = RobotMsg.SetTwitterNotifyOnSuc;
		else
			result = RobotMsg.SetTwitterNotifyOffSuc;
		RobotMsg.getInstance().sendMessage(message, result);

		// 更新用户信息
		user.setLastActiveTime(DateHelp.getLocalDateTime());
		UserDao.getInstance().addOrUpdateUser(user);

		// 写系统日志
		SysLog log = new SysLog();
		log.setUserId(user.getUserId());
		log.setLogTime(DateHelp.getLocalDateTime());
		log.setLogType(SysLogType.doTwitterNotifyChange);
		log.setLogContent(new Text(result));
		SysLogDao.getInstance().addSysLog(log);
	}
}
