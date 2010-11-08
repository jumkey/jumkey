package com.appspot.common;

/**
 * 机器人操作常量类 ERROR-错误的操作码- -1，Publish-发布消息-0，HELP-查看帮助-1，BIND-绑定同步账号-2，
 * REMOVE-取消所有绑定-3，STATUS-产看用户信息-4，TON-打开Twitter消息提示-5，
 * TON-关闭Twitter消息提示-6，THOME-获取Twitter最新20条更新-7，
 * TREPLY-获取Twitter最新20条回复-8，TReplyPublish-以回复的形式发布Twitter消息-9
 * SePublish-选择同步源发布消息-10
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class RobotOpType {
	/**
	 * ERROR-错误的操作码- -1
	 */
	public final static int ERROR = -1;

	/**
	 * Publish-发布消息-0
	 */
	public final static int Publish = 0;

	/**
	 * HELP-查看帮助-1
	 */
	public final static int HELP = 1;
	public final static String HELPSTR = "/help";

	/**
	 * ALIAS-绑定同步账号-2
	 */
	public final static int ALIAS = 2;
	public final static String ALIASSTR = "/alias";

	/**
	 * LIST-取消所有绑定-3
	 */
	public final static int LIST = 3;
	public final static String LISTSTR = "/list";

	/**
	 * STATUS-产看用户信息-4
	 */
	public final static int STATUS = 4;
	public final static String STATUSSTR = "-status";

	/**
	 * TON-打开Twitter消息提示-5
	 */
	public final static int TON = 5;
	public final static String TONSTR = "-ton";

	/**
	 * TON-关闭Twitter消息提示-6
	 */
	public final static int TOFF = 6;
	public final static String TOFFSTR = "-toff";

	/**
	 * THOME-获取Twitter最新20条更新-7
	 */
	public final static int THOME = 7;
	public final static String THOMESTR = "-thome";

	/**
	 * TREPLY-获取Twitter最新20条回复-8
	 */
	public final static int TREPLY = 8;
	public final static String TREPLYSTR = "-treply";

	/**
	 * TReplyPublish-以回复的形式发布Twitter消息-9
	 */
	public final static int TReplyPublish = 9;
	public final static String TReplyPublishSTR = "-treply";

	/**
	 * SePublish-选择同步源发布消息-10
	 */
	public final static int SePublish = 10;
}
