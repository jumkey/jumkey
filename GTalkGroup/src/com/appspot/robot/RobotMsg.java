﻿/*
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
package com.appspot.robot;

import java.util.List;
import java.util.ArrayList;

import com.appspot.common.AccountType;
import com.appspot.common.RobotOpType;
import com.appspot.persistence.Account;
import com.appspot.persistence.User;
import com.google.appengine.api.xmpp.JID;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.MessageType;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

/**
 * 机器人消息类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class RobotMsg {
	public final static String HelloForFirstTime = "您好，欢迎使用围着脖子推机器人！\n如果您需要帮助，请使用-help命令。";
	public final static String OperateError = "您输入的操作不正确，请重新输入。";
	public final static String NotBind = "您目前还没有绑定同步账号。";
	public final static String BindSuc = "绑定同步账号成功！";
	public final static String BindFail = "绑定同步账号失败！";
	public final static String PC2Long = "发布失败！您发布的内容超过了140个字！";
	public final static String PublishSuc = "发布成功！";
	public final static String PublishFail = "发布失败！";
	public final static String RemoveSuc = "取消绑定成功！";
	public final static String RemoveFail = "取消绑定失败！";
	public final static String StatusHead = "您目前绑定的账号如下：\n";
	public final static String NotSetTwitterNotify = "您目前还没有设置Twitter更新提示。";
	public final static String NotBindTwitter = "您目前还没有绑定Twitter账号或绑定的Twitter账号没有通过身份验证。";
	public final static String SetTwitterNotifyOnSuc = "开启Twitter更新提示成功！";
	public final static String SetTwitterNotifyOffSuc = "关闭Twitter更新提示成功！";
	public final static String NoTweet = "您暂时没有更新。";
	public final static String Help = "\n围着脖子推机器人V1.0帮助\n"
			+ "绑定账号：-bind  -同步源代码  账号  密码 \n"
			+ "如：-bind -t myn0 myp0 -s myn1 myp1\n" + "同步源代码：\n"
			+ "t-Twitter,  s-新浪围脖,  r-人人网,  d-嘀咕,  z-做啥\n" + "删除绑定：-remove\n"
			+ "查看绑定状态：-status\n" + "选择同步源发布信息：-t -s -r -d -z mymsg\n"
			+ "[-t -s -r -d -z] 可选择一个或多个进行组合\n" + "开启Twitter更新提示：-ton\n"
			+ "关闭Twitter更新提示：-toff\n" + "查看Twitter最近20条更新：-thome\n"
			+ "查看Twitter最近20条回复：-treply\n"
			+ "Twitter Reply：-treply statusID @name mymsg\n"
			+ "如：-treply 1234567890 @Jim This is Twitter.\n" + "查看帮助：-help\n"
			+ "注：以非\"-\"开头对话，即向所有同步源发布消息";

	private RobotMsg() {
	}

	private static RobotMsg instance = null;

	public static synchronized RobotMsg getInstance() {
		if (instance == null) {
			instance = new RobotMsg();
		}
		return instance;
	}

	private static final XMPPService xmppService = XMPPServiceFactory.getXMPPService();

	/**
	 * 发送XMPP消息
	 * 
	 * @param message，用户发送的message
	 * @param body，发送消息的内容
	 */
	public void sendMessage(Message message, String body) {
		Message reply = new MessageBuilder().withRecipientJids(
				message.getFromJid()).withMessageType(MessageType.NORMAL)
				.withBody(body).build();
		xmppService.sendMessage(reply);
	}

	/**
	 * 发送XMPP消息
	 * 
	 * @param jid，用户的JID
	 * @param body，发送消息的内容
	 */
	public void sendMessage(String jid, String body) {
		Message reply = new MessageBuilder().withRecipientJids(new JID(jid))
				.withMessageType(MessageType.NORMAL).withBody(body).build();
		xmppService.sendMessage(reply);
	}

	/**
	 * 从用户发送的message中获取用户ID
	 * 
	 * @param message，用户发送的message
	 * @return，用户ID
	 */
	public String getUserId(Message message) {
		if (message == null || message.getFromJid() == null) {
			return null;
		}
		String tmp[] = message.getFromJid().getId().toString().split("\\/");
		if (tmp == null || tmp.length < 1) {
			return null;
		}
		return tmp[0].toLowerCase();
	}

	/**
	 * 从messageBody中获取操作类型
	 * 
	 * @param messageBody，用户发送的消息内容
	 * @return，操作类型
	 */
	public int getOperateType(String messageBody) {
		if (messageBody.startsWith("-")) {
			if (messageBody.startsWith(RobotOpType.HELPSTR)) {
				return RobotOpType.HELP;
			}
			if (messageBody.startsWith(RobotOpType.BINDSTR)) {
				return RobotOpType.BIND;
			}
			if (messageBody.startsWith(RobotOpType.REMOVESTR)) {
				return RobotOpType.REMOVE;
			}
			if (messageBody.startsWith(RobotOpType.STATUSSTR)) {
				return RobotOpType.STATUS;
			}
			if (messageBody.startsWith(RobotOpType.TONSTR)) {
				return RobotOpType.TON;
			}
			if (messageBody.startsWith(RobotOpType.TOFFSTR)) {
				return RobotOpType.TOFF;
			}
			if (messageBody.startsWith(RobotOpType.THOMESTR)) {
				return RobotOpType.THOME;
			}
			if (messageBody.trim().equals(RobotOpType.TREPLYSTR)) {
				return RobotOpType.TREPLY;
			}
			if (messageBody.startsWith(RobotOpType.TReplyPublishSTR)) {
				return RobotOpType.TReplyPublish;
			}
			if (messageBody.indexOf("-t") > -1
					|| messageBody.indexOf("-s") > -1
					|| messageBody.indexOf("-r") > -1
					|| messageBody.indexOf("-d") > -1
					|| messageBody.indexOf("-z") > -1) {
				return RobotOpType.SePublish;
			}
			return RobotOpType.ERROR;
		}
		return RobotOpType.Publish;
	}

	/**
	 * 从messageBody中获取须绑定的账号
	 * 
	 * @param user，账号所属的用户
	 * @param messageBody，用户发送的消息内容
	 * @param userNameSb，拼接账户名，用于记录日志
	 * @return，绑定的账号集合
	 */
	public List<Account> getAccounts(User user, String messageBody,
			StringBuffer userNameSb) {
		List<Account> accountList = new ArrayList<Account>();
		Account account = null;
		// etc. -bind -t st 000 -s st 000 -r st 000 -d st 000 -z st 000
		String tmp[] = messageBody.split(" -");
		if (tmp.length < 2) {
			return null;
		}
		for (int i = 1; i < tmp.length; i++) // etc. 't st 000 '
		{
			String tmpAccount[] = tmp[i].trim().split("\\s+");
			if (tmpAccount.length < 3) {
				return null;
			}
			account = new Account();
			String type = tmpAccount[0].toLowerCase();
			if (type.equals("t")) {
				account.setAccountType(AccountType.TWITTER);
				userNameSb.append(AccountType.TWITTERNAME);
			} else if (type.equals("s")) {
				account.setAccountType(AccountType.SINA);
				userNameSb.append(AccountType.SINANAME);
			} else if (type.equals("r")) {
				account.setAccountType(AccountType.RENREN);
				userNameSb.append(AccountType.RENRENNAME);
			} else if (type.equals("d")) {
				account.setAccountType(AccountType.DIGU);
				userNameSb.append(AccountType.DIGUNAME);
			} else if (type.equals("z")) {
				account.setAccountType(AccountType.ZUOSA);
				userNameSb.append(AccountType.ZUOSANAME);
			}
			account.setUserName(tmpAccount[1]);
			account.setUserPwd(tmpAccount[2]);
			account.setUser(user);
			accountList.add(account);

			userNameSb.append("-");
			userNameSb.append(account.getUserName());
			userNameSb.append(",");
		}
		return accountList;
	}

	/**
	 * 根据JID判断用户是否在线
	 * 
	 * @param jid，用户的JID
	 * @return，用户是否在线
	 */
	public boolean isOnline(String jid) {
		return xmppService.getPresence(new JID(jid)).isAvailable();
	}
}