package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txplanprojaudit;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txplanprojaudit entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txplanprojaudit
 * @author MyEclipse Persistence Tools
 */

public class TxplanprojauditDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxplanprojauditDAO.class);
	// property constants
	public static final String AUDITPERSONID = "auditpersonid";
	public static final String AUDITRESULT = "auditresult";
	public static final String AUDITCOMMENT = "auditcomment";
	public static final String STATE = "state";

	public void save(Txplanprojaudit transientInstance) {
		log.debug("saving Txplanprojaudit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txplanprojaudit persistentInstance) {
		log.debug("deleting Txplanprojaudit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txplanprojaudit findById(java.lang.String id) {
		log.debug("getting Txplanprojaudit instance with id: " + id);
		try {
			Txplanprojaudit instance = (Txplanprojaudit) getSession().get("org.cafeboy.model.Txplanprojaudit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txplanprojaudit> findByExample(Txplanprojaudit instance) {
		log.debug("finding Txplanprojaudit instance by example");
		try {
			List<Txplanprojaudit> results = (List<Txplanprojaudit>) getSession().createCriteria("org.cafeboy.model.Txplanprojaudit").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txplanprojaudit instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txplanprojaudit as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txplanprojaudit> findByAuditpersonid(Object auditpersonid) {
		return findByProperty(AUDITPERSONID, auditpersonid);
	}

	public List<Txplanprojaudit> findByAuditresult(Object auditresult) {
		return findByProperty(AUDITRESULT, auditresult);
	}

	public List<Txplanprojaudit> findByAuditcomment(Object auditcomment) {
		return findByProperty(AUDITCOMMENT, auditcomment);
	}

	public List<Txplanprojaudit> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Txplanprojaudit instances");
		try {
			String queryString = "from Txplanprojaudit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txplanprojaudit merge(Txplanprojaudit detachedInstance) {
		log.debug("merging Txplanprojaudit instance");
		try {
			Txplanprojaudit result = (Txplanprojaudit) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txplanprojaudit instance) {
		log.debug("attaching dirty Txplanprojaudit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txplanprojaudit instance) {
		log.debug("attaching clean Txplanprojaudit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}