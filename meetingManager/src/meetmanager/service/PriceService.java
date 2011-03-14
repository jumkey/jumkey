package meetmanager.service;

import java.util.List;

import meetmanager.model.Price;
import meetmanager.model.PriceRoomType;
import meetmanager.model.RoomType;


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
