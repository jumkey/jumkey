package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.LimitDAO;
import meetmanager.model.Limit;
import meetmanager.model.Page;
import meetmanager.service.LimitService;


public class LimitServiceImpl implements LimitService {
	private LimitDAO limitDAO;

	public LimitDAO getLimitDAO() {
		return limitDAO;
	}

	public void setLimitDAO(LimitDAO limitDAO) {
		this.limitDAO = limitDAO;
	}

	public void addInstance(Limit limit) {
		limitDAO.save(limit);
	}

	public Limit updateInstance(Limit limit) {
		Limit u = limitDAO.get(limit.getId());
		u.setName(limit.getName());
		u.setCode(limit.getCode());
		return u;
	}

	public void deleteInstance(Limit limit) {
		limitDAO.delete(limitDAO.get(limit.getId()));
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			limitDAO.delete(limitDAO.get(id));
		}
	}

	public List<Limit> getPageUser(Page page) {
		return null;
	}

	@Override
	public List<Limit> getAllLimit() {
		return limitDAO.findAll();
	}
}
