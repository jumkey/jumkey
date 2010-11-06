package com.appspot.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.appspot.common.AccountType;

/**
 * 用户实体类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String userId;

	@Persistent
	private String userPwd;

	@Persistent(mappedBy = "user")
	private List<Account> accountList = new ArrayList<Account>();

	@Persistent
	private Date startTime;

	@Persistent
	private Date lastActiveTime;

	@Persistent
	private int pushCount;

	@Persistent
	private boolean isInUse;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(Date lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public int getPushCount() {
		return pushCount;
	}

	public void setPushCount(int pushCount) {
		this.pushCount = pushCount;
	}

	public boolean getIsInUse() {
		return isInUse;
	}

	public void setIsInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

	public String getAccountNames() {
		StringBuffer userNameSb = new StringBuffer();
		for (Account account : accountList) {
			switch (account.getAccountType()) {
			case AccountType.TWITTER:
				userNameSb.append(AccountType.TWITTERNAME);
				break;
			case AccountType.SINA:
				userNameSb.append(AccountType.SINANAME);
				break;
			case AccountType.RENREN:
				userNameSb.append(AccountType.RENRENNAME);
				break;
			case AccountType.DIGU:
				userNameSb.append(AccountType.DIGUNAME);
				break;
			case AccountType.ZUOSA:
				userNameSb.append(AccountType.ZUOSANAME);
				break;
			}
			userNameSb.append("-");
			userNameSb.append(account.getUserName());
			userNameSb.append(",");
		}
		return userNameSb.toString();
	}
}
