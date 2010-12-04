package meetmanager.service;

import java.util.List;

import meetmanager.model.Agreement;


public interface AgreementService {

	public List<Agreement> getAllAgreement();

	public Agreement updateInstance(Agreement agreement);

	public void addInstance(Agreement agreement);

	public Agreement getInstance(Agreement agreement);
	
}
