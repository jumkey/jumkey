package com.appspot.persistence;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

/**
 * 账户实体类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class Account {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key accountId;

	@Persistent
	private User user;

	@Persistent
	private String userName;

	@Persistent
	private String userPwd;

	@Persistent
	private int accountType;

	@Persistent
	private boolean isAuth;

	public Key getAccountId() {
		return accountId;
	}

	public void setAccountId(Key accountId) {
		this.accountId = accountId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public boolean getIsAuth() {
		return isAuth;
	}

	public void setIsAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
}
