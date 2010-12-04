package meetmanager.dao;

import java.util.List;

import meetmanager.model.Agreement;


public interface AgreementDAO extends GenericDAO<Agreement,Integer> {
	public List<Agreement> findAgreement();
}
