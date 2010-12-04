package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.FeteRecordDAO;
import meetmanager.dao.UserDAO;
import meetmanager.model.FeteRecord;
import meetmanager.model.Page;
import meetmanager.model.User;
import meetmanager.service.FeteRecordService;


public class FeteRecordServiceImpl implements FeteRecordService {
	private UserDAO userDAO;
	private FeteRecordDAO feteRecordDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public FeteRecordDAO getFeteRecordDAO() {
		return feteRecordDAO;
	}

	public void setFeteRecordDAO(FeteRecordDAO feteRecordDAO) {
		this.feteRecordDAO = feteRecordDAO;
	}

	public void addInstance(FeteRecord FeteRecord) {
		feteRecordDAO.save(FeteRecord);
	}

	public List<FeteRecord> findByFeteRecord(Integer id) {
		return feteRecordDAO.find("from FeteRecord where fete.id=" + id);
	}

	public void deleteInstance(FeteRecord feterecord) throws Exception {
		feterecord = feteRecordDAO.get(feterecord.getId());
		if (feterecord.getId() != null) {
			feteRecordDAO.delete(feterecord);
		} else {
			throw new Exception("此记录不是你创建");
		}

	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		FeteRecord feterecord = null;
		for (int id : selected) {
			feterecord = feteRecordDAO.get(id);
			if (feterecord != null) {
				feteRecordDAO.delete(feterecord);
			} else {
				throw new Exception("删除的记录有的不是你创建");
			}
		}

	}

	public String checkUser(Integer id, String username) {
		StringBuffer ss = new StringBuffer("[");
		List<User> l = userDAO
				.find("from User where id not in(select u.id from User u,FeteRecord f where f.user.id=u.id and f.fete.id="
						+ id + ") and name LIKE '%" + username + "%'");
		for (User u : l) {
			ss.append("{\"id\":\"" + u.getId() + "\",\"name\":\"" + u.getName()
					+ "\"},");
		}
		ss.append("]");
		if (ss.length() - 2 != 0) {
			ss.deleteCharAt(ss.length() - 2);
		}
		System.out.println(ss);
		return ss.toString();
	}

	public List<FeteRecord> findPageByFeteRecord(Page page, Integer id) {
		if (id != null && id != 0) {
			page.setTotalNum(feteRecordDAO
					.getCountByQuery("from FeteRecord where fete.id=" + id));
			return feteRecordDAO.findByPagination(
					"from FeteRecord where fete.id=" + id, page);
		} else {
			return feteRecordDAO.findByPagination("from FeteRecord", page);
		}
	}
}
