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
