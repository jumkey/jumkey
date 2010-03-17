package org.usc.services.student;

import java.util.List;

import org.usc.beans.Student;
import org.usc.daos.base.IBaseDao;

/**
 * 学生服务类接口
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
public interface IStudentService extends IBaseDao<Student>
{
	/**
	 * 根据姓名查找学生
	 * 
	 * @param value
	 *            姓名
	 * @return 该姓名的学生集
	 */
	public abstract List<Student> findByName(String value);
}