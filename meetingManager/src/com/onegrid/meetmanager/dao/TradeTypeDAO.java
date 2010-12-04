package com.onegrid.meetmanager.dao;

import java.util.List;

import com.onegrid.meetmanager.model.TradeType;

public interface TradeTypeDAO extends GenericDAO<TradeType, Integer> {
	public List<TradeType> findRootTradeTypes();
	public List<TradeType> findTradeTypesByParentId(Integer parentId);
}
