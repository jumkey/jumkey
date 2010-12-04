package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.FeeItem;
import com.onegrid.meetmanager.model.Page;

public interface FeeItemService {
	public List<FeeItem> getAllFeeItem();
	public List<FeeItem> getPageFeeItem(Page page);
	public void deleteInstance(FeeItem feeitem);
	public void addInstance(FeeItem feeitem);
	public void deleteSelectInstance(Integer[] selected);
	public FeeItem updateInstance(FeeItem feeitem);
}
