package meetmanager.dao.impl;

import java.sql.SQLException;
import java.util.List;

import meetmanager.dao.GenericDAOHibernate;
import meetmanager.dao.RegisterDAO;
import meetmanager.model.Reach;
import meetmanager.model.Register;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;


public class RegisterDAOImpl extends GenericDAOHibernate<Register, Integer>
		implements RegisterDAO {

	public void saveOrUpdate(Register register) {
		saveOrUpdate(register);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reach> findReachs(final String string) {
		List<Reach> l = (List<Reach>) getHibernateTemplate().execute(new HibernateCallback() {
			public List<Reach> doInHibernate(final Session s)
					throws HibernateException, SQLException {
				// <STRONG>执行普通sql</STRONG>
				// Query query = s.createSQLQuery(string);
				// <STRONG>执行hql</STRONG>
				Query query = s.createQuery(string);
				return query.list();
			}
		});
		return l;
	}

}
