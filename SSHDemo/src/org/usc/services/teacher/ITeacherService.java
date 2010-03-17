package org.usc.services.teacher;

import java.util.List;

import org.usc.beans.Teacher;
import org.usc.daos.base.IBaseDao;

/**
 * 老师服务类接口
 * 
 * @author <a href="http://www.blogjava.net/lishunli/" target="_blank">ShunLi</a>
 * @notes Created on 2010-3-9<br>
 *        Revision of last commit:$Revision: 648 $<br>
 *        Author of last commit:$Author: nhjsjmz@gmail.com $<br>
 *        Date of last commit:$Date: 2010-03-09 19:52:10 +0800 (周二, 09 三月 2010) $<br>
 *        <p>
 */
public interface ITeacherService extends IBaseDao<Teacher>
{
	/**
	 * 根据职称查找老师
	 * 
	 * @param value
	 *            职称
	 * @return 该职称的学生集
	 */
	public abstract List<Teacher> findByPositional(String value);
}