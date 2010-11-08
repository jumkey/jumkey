package com.appspot.persistence;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.appspot.common.DateHelp;

import java.util.Date;
import java.util.List;

/**
 * 用户持久层操作类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class UserDao {
	private UserDao() {
	}

	private static UserDao instance = null;

	public static synchronized UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	/**
	 * 添加或修改一个用户
	 * 
	 * @param user，用户实体
	 * @return，是否添加或修改成功
	 */
	public boolean addOrUpdateUser(User user) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(user);
		} catch (Exception e) {
			return false;
		} finally {
			pm.close();
		}
		return true;
	}

	/**
	 * 获取所有用户
	 * 
	 * @return，所有用户
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUserList(String userId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<User> users = null;
		try {
			Query query = pm.newQuery(User.class);
			query.setFilter("userId != userParam");
			query.declareParameters("java.lang.String userParam");
			users = (List<User>) query.execute(userId);
			pm.detachCopyAll(users);
		} catch (Exception e) {
		} finally {
			pm.close();
		}
		return users;
	}

	/**
	 * 用户昵称是否存在
	 * 
	 * @param nickName，用户昵称
	 * @return 是否存在
	 */
	@SuppressWarnings("unchecked")
	public boolean checkNickName(String nickName) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = false;
		try {
			Query query = pm.newQuery(User.class);
			query.setFilter("nickName == userParam");
			query.declareParameters("java.lang.String userParam");
			List<User> users = (List<User>) query.execute(nickName);
			if(users==null||users.size()==0){
				flag = false;
			}else{
				flag = true;
			}
		} catch (Exception e) {
		} finally {
			pm.close();
		}
		return flag;
	}

	/**
	 * 根据用户ID获取用户
	 * 
	 * @param UserId，用户ID
	 * @return，符合条件的用户
	 */
	public User getByUserId(String userId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		User user = null;
		try {
			user = pm.getObjectById(User.class, userId);
		} catch (Exception e) {
		} finally {
			pm.close();
		}
		return user;
	}

	/**
	 * 根据用户ID获取用户的绑定账号
	 * 
	 * @param user，用户实体
	 * @return，户的绑定账号集合
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getUserAccountList(User user) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Account.class);
		query.setFilter("user == userParam");
		query.declareParameters("com.appspot.persistence.User userParam");
		List<Account> results = (List<Account>) query.execute(user);
		return results;
	}

	/**
	 * 根据用户ID删除用户的绑定账号
	 * 
	 * @param userId，用户ID
	 * @return，是否删除成功
	 */
	public boolean deleteUserAccountList(String userId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		User user = null;
		try {
			user = pm.getObjectById(User.class, userId);
			if (user != null) {
				List<Account> accountList = user.getAccountList();
				for (Account account : accountList) {
					pm.deletePersistent(account);
				}
			}
			return true;
		} catch (Exception e) {
		} finally {
			pm.close();
		}
		return false;
	}

	/**
	 * 获取一定时间内使用系统的用户数量
	 * 
	 * @return，一定时间内使用系统的用户数量
	 */
	@SuppressWarnings("unchecked")
	public int getOnlineUserCount() {
		int pastHour = 1;
		Date timestamp = new Date(DateHelp.getLocalDateTime().getTime()
				- 3600000 * pastHour);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(User.class);
		query.setFilter("lastActiveTime > timestamp");
		query.declareParameters("java.util.Date timestamp");
		List<User> results = (List<User>) query.execute(timestamp);
		if (results == null)
			return 0;
		else
			return results.size();
	}
}
