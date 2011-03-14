package meetmanager.service;

import java.util.List;

import meetmanager.model.TradeType;
import meetmanager.utils.dao.Page;


public interface TradeTypeService {

	public void addInstance(TradeType tradeType);

	public TradeType updateInstance(TradeType tradeType);

	public void deleteInstance(TradeType tradeType);

	public void deleteSelectInstance(Integer[] selected);

	public List<TradeType> getAllTradeType();

	public List<TradeType> findPageRootTradeTypes(Page page);

	public List<TradeType> findPageTradeTypesByParentId(Integer parentId,
			Page page);

	public List<TradeType> findRootTradeTypes();

	public TradeType findInstanceById(Integer id);
}
