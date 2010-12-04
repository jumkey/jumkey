package meetmanager.dao;

import java.util.List;

import meetmanager.model.Notice;


public interface NoticeDAO extends GenericDAO<Notice,Integer> {

	public List<Notice> findNotice();
	
}
