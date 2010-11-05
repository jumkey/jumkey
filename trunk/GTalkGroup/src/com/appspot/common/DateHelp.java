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
