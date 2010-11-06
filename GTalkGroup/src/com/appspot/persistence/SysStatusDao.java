package com.appspot.persistence;

import javax.jdo.PersistenceManager;

/**
 * 系统状态持久层操作类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class SysStatusDao {
	private SysStatusDao() {
	}

	private static SysStatusDao instance = null;

	public static synchronized SysStatusDao getInstance() {
		if (instance == null) {
			instance = new SysStatusDao();
		}
		return instance;
	}

	/**
	 * 添加或修改系统状态
	 * 
	 * @param sysStatus，系统状态实体
	 * @return，是否添加或修改成功
	 */
	public boolean addOrUpdateSysStatus(SysStatus sysStatus) {
		if (sysStatus.getSysName() == null
				|| !sysStatus.getSysName().equals("twitterSina")) {
			sysStatus.setSysName("twitterSina");
		}
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(sysStatus);
		} catch (Exception e) {
			return false;
		} finally {
			pm.close();
		}
		return false;
	}
}
