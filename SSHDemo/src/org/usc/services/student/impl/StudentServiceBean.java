package org.usc.services.student.impl;

import java.util.List;

import org.usc.beans.Student;
import org.usc.daos.base.BaseDaoSupport;
import org.usc.services.student.IStudentService;

/**
 * 学生服务实现类
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
// 业务逻辑层的类
public class StudentServiceBean extends BaseDaoSupport<Student> implements IStudentService
{

	/*
	 * @see org.usc.services.student.IStudentService#findByName(java.lang.String)
	 */
	public List<Student> findByName(String value)
	{
		return super.findByProperty("name", value);
	}

}
