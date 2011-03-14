package meetmanager.dao;

import java.util.List;

import meetmanager.model.TradeType;
import meetmanager.utils.dao.GenericDAO;


public interface TradeTypeDAO extends GenericDAO<TradeType, Integer> {
	public List<TradeType> findRootTradeTypes();
	public List<TradeType> findTradeTypesByParentId(Integer parentId);
}
