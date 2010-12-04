package com.onegrid.meetmanager.service;

import java.util.List;

import com.onegrid.meetmanager.model.Price;
import com.onegrid.meetmanager.model.PriceRoomType;
import com.onegrid.meetmanager.model.RoomType;
import com.onegrid.meetmanager.model.Units;

public interface PriceService {

	public void addInstance(Price price, List<PriceRoomType> prt);

	public void deleteInstance(Price price) throws Exception;

	public void deleteSelectInstance(Integer[] selected) throws Exception;

	public Price updateInstance(Price price) throws Exception;
	
	public Price updateaskprice(Price price);

	public List<Price> getAllPrice();
	
	public List<Price> getPriceAll();

	public String checkUnits(String unitsname);

	public Price getInstance(Integer id);

    public List<RoomType> getAllRoomType();
}
