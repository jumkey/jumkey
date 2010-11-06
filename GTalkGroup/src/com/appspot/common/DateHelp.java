package com.appspot.common;

import java.util.Date;

/**
 * 时间公共处理类
 * 
 * @author Steven Wang <http://blog.stevenwang.name>
 */
public class DateHelp {
	public static Date getLocalDateTime() {
		return new Date(new Date().getTime() + 3600000 * 8);
	}

	public static String getTimeSpanStr(Date date) {
		long timeSpan = new Date().getTime() - date.getTime();
		if (timeSpan < 1000) {
			return "0s";
		} else if (timeSpan < 60000) {
			return String.valueOf(timeSpan / 1000) + "s";
		} else if (timeSpan < 3600000) {
			return String.valueOf(timeSpan / 60000) + "m";
		} else if (timeSpan < 86400000) {
			return String.valueOf(timeSpan / 3600000) + "h";
		} else {
			return String.valueOf(timeSpan / 86400000) + "d";
		}
	}
}
