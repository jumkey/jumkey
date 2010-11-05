/*
 *  Copyright (c) 2010, Steven Wang
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *      
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 *  twitterSina at http://twitterSina.appspot.com
 *  twitterSina code at http://twitterSina.googlecode.com
 * 	
 */
package com.appspot.persistence;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Twitter消息提示实体类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class TwitterNotify {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String userId;

	@Persistent
	private String userJID;

	@Persistent
	private String userName;

	@Persistent
	private String userPwd;

	@Persistent
	private long lastNotifyMsgId;

	@Persistent
	private Date lastNotifyTime;

	@Persistent
	private int notifyCount;

	@Persistent
	private boolean isNotify;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserJID() {
		return userJID;
	}

	public void setUserJID(String userJID) {
		this.userJID = userJID;
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

	public long getLastNotifyMsgId() {
		return lastNotifyMsgId;
	}

	public void setLastNotifyMsgId(long lastNotifyMsgId) {
		this.lastNotifyMsgId = lastNotifyMsgId;
	}

	public Date getLastNotifyTime() {
		return lastNotifyTime;
	}

	public void setLastNotifyTime(Date lastNotifyTime) {
		this.lastNotifyTime = lastNotifyTime;
	}

	public int getNotifyCount() {
		return notifyCount;
	}

	public void setNotifyCount(int notifyCount) {
		this.notifyCount = notifyCount;
	}

	public boolean getIsNotify() {
		return isNotify;
	}

	public void setIsNotify(boolean isNotify) {
		this.isNotify = isNotify;
	}
}
