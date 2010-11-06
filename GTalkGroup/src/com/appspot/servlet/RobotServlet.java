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
 *  http://twitterSina.appspot.com
 *  code at http://twitterSina.googlecode.com
 * 	
 */
package com.appspot.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.persistence.User;
import com.appspot.robot.RobotMsg;
import com.appspot.robot.RobotService;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

/**
 * 机器人相关的Servlet
 * 
 * @author Steven Wang
 */
public class RobotServlet extends HttpServlet {
	private static final long serialVersionUID = -8333918611331603780L;
	private static final XMPPService xmppService = XMPPServiceFactory.getXMPPService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Message message = xmppService.parseMessage(request);
		if (message == null) {
			return;
		}
		String messageBody = message.getBody();
		
		String userId = RobotMsg.getInstance().getUserId(message);
        if(messageBody.length() == 0 || userId == null) {
        	return;
        }
        User user = RobotService.getInstance().getUserByUserId(userId);
        if(user == null) {//第一次使用，保存用户信息
        	RobotMsg.getInstance().sendMessage(message, RobotMsg.HelloForFirstTime);
        	user = RobotService.getInstance().newUser(userId);
        }
		RobotMsg.getInstance().sendMessage(message,messageBody);
	}
}
