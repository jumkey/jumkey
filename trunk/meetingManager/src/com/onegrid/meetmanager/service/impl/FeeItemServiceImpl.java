package com.onegrid.meetmanager.service.impl;

import java.util.List;

import com.onegrid.meetmanager.dao.FeeItemDAO;
import com.onegrid.meetmanager.model.FeeItem;
import com.onegrid.meetmanager.model.Page;
import com.onegrid.meetmanager.service.FeeItemService;

public class FeeItemServiceImpl implements FeeItemService {
	private FeeItemDAO feeItemDAO;

	public FeeItemDAO getFeeItemDAO() {
		return feeItemDAO;
	}

	public void setFeeItemDAO(FeeItemDAO feeItemDAO) {
		this.feeItemDAO = feeItemDAO;
	}

	public void addInstance(FeeItem feeitem) {
		feeItemDAO.save(feeitem);
	}

	public void deleteInstance(FeeItem feeitem) {
		feeItemDAO.delete(feeitem);
	}

	public void deleteSelectInstance(Integer[] selected) {
		for (int id : selected) {
			feeItemDAO.delete(feeItemDAO.get(id));
		}
	}

	public FeeItem updateInstance(FeeItem feeitem) {
		FeeItem sysa = feeItemDAO.get(feeitem.getId());
		// PropertyUtils.copyProperties
		// BeanUtils.copyProperties(sysa, account);
		sysa.setName(feeitem.getName());
		sysa.setType(feeitem.getType());
		sysa.setStartfee(feeitem.getStartfee());
		sysa.setNature(feeitem.getNature());
		return sysa;
	}

	public List<FeeItem> getAllFeeItem() {
		return feeItemDAO.findAll();
	}

	public List<FeeItem> getPageFeeItem(Page page) {
		page.setTotalNum(feeItemDAO.getCountByQuery("from FeeItem"));
		return feeItemDAO.findByPagination("from FeeItem", page);
	}

}
