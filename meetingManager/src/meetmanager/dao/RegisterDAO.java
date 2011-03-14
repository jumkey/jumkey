package meetmanager.dao;

import java.util.List;

import meetmanager.model.Reach;
import meetmanager.model.Register;
import meetmanager.utils.dao.GenericDAO;


public interface RegisterDAO extends GenericDAO<Register,Integer> {

	public void saveOrUpdate(Register register);

	public List<Reach> findReachs(String string);
	
}
