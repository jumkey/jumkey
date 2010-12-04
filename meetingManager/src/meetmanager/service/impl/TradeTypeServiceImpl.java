package meetmanager.service.impl;

import java.util.List;

import meetmanager.dao.TradeTypeDAO;
import meetmanager.model.Page;
import meetmanager.model.TradeType;
import meetmanager.service.TradeTypeService;


public class TradeTypeServiceImpl implements TradeTypeService {
	private TradeTypeDAO tradeTypeDAO;

	public void setTradeTypeDAO(TradeTypeDAO tradeTypeDAO) {
		this.tradeTypeDAO = tradeTypeDAO;
	}

	public void addInstance(TradeType tradeType) {
		tradeTypeDAO.save(tradeType);
	}

	public TradeType updateInstance(TradeType tradeType) {
		TradeType u = tradeTypeDAO.get(tradeType.getId());
		u.setName(tradeType.getName());
		u.setUnitstype(tradeType.getUnitstype());
		return u;
	}

	public void deleteInstance(TradeType tradeType) {
		tradeTypeDAO.delete(tradeTypeDAO.get(tradeType.getId()));
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			tradeTypeDAO.delete(tradeTypeDAO.get(id));
		}
	}

	public List<TradeType> getPageUser(Page page) {
		return null;
	}

	public List<TradeType> getAllTradeType() {
		return tradeTypeDAO.findAll();
	}

	public List<TradeType> findPageRootTradeTypes(Page page) {
		page
				.setTotalNum(tradeTypeDAO
						.getCountByQuery("from TradeType where parentid is null or parentid=0"));
		return tradeTypeDAO.findByPagination(
				"from TradeType where parentid is null or parentid=0", page);
	}

	public List<TradeType> findPageTradeTypesByParentId(Integer parentId,
			Page page) {
		if (parentId != null && parentId > 0) {
			page.setTotalNum(tradeTypeDAO
					.getCountByQuery("from TradeType where parentid="
							+ parentId));
			return tradeTypeDAO.findByPagination(
					"from TradeType where parentid=" + parentId, page);
		} else {
			return null;
		}

	}

	public List<TradeType> findRootTradeTypes() {
		return tradeTypeDAO.findRootTradeTypes();
	}

	public TradeType findInstanceById(Integer id) {
		return tradeTypeDAO.get(id);
	}
}
