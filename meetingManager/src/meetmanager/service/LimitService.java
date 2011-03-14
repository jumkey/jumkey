package meetmanager.service;

import java.util.List;

import meetmanager.model.Limit;
import meetmanager.utils.dao.Page;


public interface LimitService {
	public List<Limit> getPageUser(Page page);

	public void addInstance(Limit limit);

	public Limit updateInstance(Limit limit);

	public void deleteInstance(Limit limit);

	public void deleteSelectInstance(Integer[] selected);
	
	public List<Limit> getAllLimit();
}
