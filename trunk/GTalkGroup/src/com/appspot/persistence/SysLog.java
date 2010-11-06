package com.appspot.persistence;

import java.util.Date;
import com.google.appengine.api.datastore.Text;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * 日志实体类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable = "true")
public class SysLog {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long logId;

	@Persistent
	private Date logTime;

	@Persistent
	private String userId;

	@Persistent
	private Text logContent;

	@Persistent
	private int logType;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Text getLogContent() {
		return logContent;
	}

	public void setLogContent(Text logContent) {
		this.logContent = logContent;
	}

	public int getLogType() {
		return logType;
	}

	public void setLogType(int logType) {
		this.logType = logType;
	}
}
