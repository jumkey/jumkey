package meetmanager.dao;

import java.util.List;

import meetmanager.model.Agreement;
import meetmanager.utils.dao.GenericDAO;


public interface AgreementDAO extends GenericDAO<Agreement,Integer> {
	public List<Agreement> findAgreement();
}
