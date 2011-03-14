package meetmanager.dao.impl;

import java.util.List;

import meetmanager.dao.TradeTypeDAO;
import meetmanager.model.TradeType;
import meetmanager.utils.dao.GenericDAOHibernate;


public class TradeTypeDAOImpl extends GenericDAOHibernate<TradeType, Integer>
		implements TradeTypeDAO {

	public List<TradeType> findRootTradeTypes() {
		return find("from TradeType where parentid is null or parentid=0");
	}

	public List<TradeType> findTradeTypesByParentId(Integer parentId) {
		String sql = "";
		if (parentId != 0) {
			sql = "from TradeType where parentid=" + parentId;
		} else {
			sql = "from TradeType";
		}
		return find(sql);
	}

}
