package meetmanager.service;

import java.util.List;

import meetmanager.model.Page;
import meetmanager.model.RoomType;


public interface RoomTypeService {
	public List<RoomType> getPageRoomType(Page page);
	
	public void addInstance(RoomType roomType);

	public RoomType updateInstance(RoomType roomType);

	public void deleteInstance(RoomType roomType);

	public void deleteSelectInstance(Integer[] selected);
	
	public List<RoomType> getAllRoomType();
}
