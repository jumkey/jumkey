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
import javax.jdo.Query;
import java.util.List;

/**
 * Twitter消息提示持久层操作类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class TwitterNotifyDao {
	private TwitterNotifyDao() {
	}

	private static TwitterNotifyDao instance = null;

	public static synchronized TwitterNotifyDao getInstance() {
		if (instance == null) {
			instance = new TwitterNotifyDao();
		}
		return instance;
	}

	/**
	 * 添加或修改一个Twitter消息提示实体
	 * 
	 * @param twitterNotify，Twitter消息提示实体
	 * @return，是否添加或修改成功
	 */
	public boolean addOrUpdateTwitterNotify(TwitterNotify twitterNotify) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(twitterNotify);
		} catch (Exception e) {
			return false;
		} finally {
			pm.close();
		}
		return true;
	}

	/**
	 * 根据用户ID获取Twitter消息提示实体
	 * 
	 * @param UserId，用户ID
	 * @return，符合条件的Twitter消息提示实体
	 */
	public TwitterNotify getByUserId(String userId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		TwitterNotify twitterNotify = null;
		try {
			twitterNotify = pm.getObjectById(TwitterNotify.class, userId);
		} catch (Exception e) {
		} finally {
			pm.close();
		}
		return twitterNotify;
	}

	/**
	 * 获取当前正在使用的Twitter消息提示实体集合
	 * 
	 * @return，当前正在使用的Twitter消息提示实体集合
	 */
	@SuppressWarnings("unchecked")
	public List<TwitterNotify> getTwitterNotify() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(TwitterNotify.class);
		query.setFilter("isNotify == true");
		List<TwitterNotify> tnList = (List<TwitterNotify>) query.execute();
		return tnList;
	}
}
