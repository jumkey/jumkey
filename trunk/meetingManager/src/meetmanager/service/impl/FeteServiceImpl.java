package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.FeteDAO;
import meetmanager.model.Fete;
import meetmanager.model.Page;
import meetmanager.service.FeteService;


public class FeteServiceImpl implements FeteService {
	private FeteDAO feteDAO;

	public FeteDAO getFeteDAO() {
		return feteDAO;
	}

	public void setFeteDAO(FeteDAO feteDAO) {
		this.feteDAO = feteDAO;
	}

	public void addInstance(Fete fete) {
		feteDAO.save(fete);
	}

	public List<Fete> findFetesByMeetingId(Integer meetingid) {
		// TODO Auto-generated method stub
		return feteDAO.find("from Fete where meetingInfo.id=" + meetingid);
	}

	public void deleteInstance(Fete fete) throws Exception {
		fete = feteDAO.get(fete.getId());
		if (fete.getId() != null) {
			feteDAO.delete(fete);
		} else {
			throw new Exception("此记录不是你创建");
		}

	}

	public void deleteSelectInstance(Integer[] selected) throws Exception {
		Fete fete = null;
		for (int id : selected) {
			fete = feteDAO.get(id);
			if (fete != null) {
				feteDAO.delete(fete);
			} else {
				throw new Exception("删除的记录有的不是你创建");
			}
		}

	}

	public Fete updateInstance(Fete fete) throws Exception {
		Fete fe = feteDAO.get(fete.getId());
		if (fe.getId() != null) {
			fe.setAddress(fete.getAddress());
			fe.setDate(fete.getDate());
			fe.setCost(fete.getCost());
			fe.setNumber(fete.getNumber());
			fe.setDesknumber(fete.getDesknumber());
			fe.setUnitprice(fete.getUnitprice());
			fe.setOthercost(fete.getOthercost());
			fe.setUnits(fete.getUnits());
			fe.setOutlays(fete.getOutlays());
			return fe;
		} else {
			throw new Exception("此记录不是你创建");
		}
	}

	public List<Fete> findPageFeteByMeetingId(Page page, Integer id) {
		if (id != null && id != 0) {
			page.setTotalNum(feteDAO.getCountByQuery("from Fete where meetingInfo.id="+id));
			return feteDAO.findByPagination("from Fete where meetingInfo.id="+id, page);
		} else {
			return feteDAO.findByPagination("from Fete", page);
		}
	}
}
