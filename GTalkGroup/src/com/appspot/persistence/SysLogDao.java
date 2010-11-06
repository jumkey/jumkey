package com.appspot.persistence;

import javax.jdo.PersistenceManager;

/**
 * 日志持久层操作类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class SysLogDao {
	private SysLogDao() {
	}

	private static SysLogDao instance = null;

	public static synchronized SysLogDao getInstance() {
		if (instance == null) {
			instance = new SysLogDao();
		}
		return instance;
	}

	/**
	 * 添加一条日志
	 * 
	 * @param log，日志实体
	 * @return，是否添加成功
	 */
	public boolean addSysLog(SysLog log) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(log);
		} catch (Exception e) {
			return false;
		} finally {
			pm.close();
		}
		return false;
	}
}
