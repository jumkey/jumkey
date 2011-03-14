package meetmanager.dao.impl;

import java.util.Date;
import java.util.List;

import meetmanager.dao.NoticeDAO;
import meetmanager.model.Notice;
import meetmanager.utils.dao.GenericDAOHibernate;


public class NoticeDAOImpl extends GenericDAOHibernate<Notice,Integer> implements NoticeDAO {

	public List<Notice> findNotice() {
		// TODO Auto-generated method stub
		return find("from Notice where date>"+new Date().getTime());
	}

}
