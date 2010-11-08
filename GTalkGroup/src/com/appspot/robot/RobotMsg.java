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
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

/**
 * 机器人消息类
 * 
 * @author jumkey
 */
public class RobotMsg {
	public final static String HelloForFirstTime = "您好，欢迎使用群聊机器人！\n如果您需要帮助，请使用/help命令。";
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
	public final static String Help = "\n群聊机器人V1.0帮助\n"
			+ "命令列表\n"
			+ "* /leave - 离开群\n"
			+ "* /list [filter] - 显示群员列表, filter过滤\n"
			+ "* /alias name - 修改你自己的昵称为 'name'\n"
			+ "* /invite email@foo.com, email@bar.com ... - 邀请邮箱列表到这个群\n"
			+ "* /help - 显示这个\n";

	private RobotMsg() {
	}

	private static RobotMsg instance = null;

	public static synchronized RobotMsg getInstance() {
		if (instance == null) {
			instance = new RobotMsg();
		}
		return instance;
	}

	private static final XMPPService xmppService = XMPPServiceFactory
			.getXMPPService();

	/**
	 * 群发XMPP消息
	 * 
	 * @param message，用户发送的message
	 * @param body，发送消息的内容
	 */
	public void sendMessageToAll(Message message, String body) {
		List<User> users = RobotService.getInstance().getAllUser(RobotMsg.getInstance().getUserId(message));
		JID jid = null;
		Message reply = null;
		for (User u : users) {
			jid = new JID(u.getUserId());
			reply = new MessageBuilder().withRecipientJids(jid)
					.withMessageType(MessageType.NORMAL).withBody(body).build();
			boolean messageSent = false;
			if (isOnline(u.getUserId())) {
				SendResponse status = xmppService.sendMessage(reply);
				messageSent = (status.getStatusMap().get(jid) == SendResponse.Status.SUCCESS);
			}
			if (!messageSent) {
				System.out.println(body);
			}
		}
	}

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
		boolean messageSent = false;
		if (xmppService.getPresence(message.getFromJid()).isAvailable()) {
			SendResponse status = xmppService.sendMessage(reply);
			messageSent = (status.getStatusMap().get(message.getFromJid()) == SendResponse.Status.SUCCESS);
		}
		if (!messageSent) {
			System.out.println(body);
		}
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
		if (messageBody.startsWith("/")) {
			if (messageBody.startsWith(RobotOpType.HELPSTR)) {
				return RobotOpType.HELP;
			}
			if (messageBody.startsWith(RobotOpType.ALIASSTR)) {
				return RobotOpType.ALIAS;
			}
			if (messageBody.startsWith(RobotOpType.LISTSTR)) {
				return RobotOpType.LIST;
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
