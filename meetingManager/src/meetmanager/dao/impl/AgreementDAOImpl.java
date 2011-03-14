package meetmanager.dao.impl;

import java.util.Date;
import java.util.List;

import meetmanager.dao.AgreementDAO;
import meetmanager.model.Agreement;
import meetmanager.utils.dao.GenericDAOHibernate;


public class AgreementDAOImpl extends GenericDAOHibernate<Agreement,Integer> implements AgreementDAO {

	public List<Agreement> findAgreement() {
		return find("from Agreement where meetingInfo.notices.size=0 and date>"+new Date().getTime());
	}

}
