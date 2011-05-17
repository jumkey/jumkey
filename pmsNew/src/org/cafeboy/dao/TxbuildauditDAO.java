package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbuildaudit;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbuildaudit entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbuildaudit
 * @author MyEclipse Persistence Tools
 */

public class TxbuildauditDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbuildauditDAO.class);
	// property constants
	public static final String AUDITPERSONID = "auditpersonid";
	public static final String AUDITRESULT = "auditresult";
	public static final String AUDITCOMMENT = "auditcomment";
	public static final String AUDITTYPE = "audittype";
	public static final String STATE = "state";

	public void save(Txbuildaudit transientInstance) {
		log.debug("saving Txbuildaudit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbuildaudit persistentInstance) {
		log.debug("deleting Txbuildaudit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbuildaudit findById(java.lang.String id) {
		log.debug("getting Txbuildaudit instance with id: " + id);
		try {
			Txbuildaudit instance = (Txbuildaudit) getSession().get("org.cafeboy.model.Txbuildaudit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbuildaudit> findByExample(Txbuildaudit instance) {
		log.debug("finding Txbuildaudit instance by example");
		try {
			List<Txbuildaudit> results = (List<Txbuildaudit>) getSession().createCriteria("org.cafeboy.model.Txbuildaudit").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbuildaudit instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbuildaudit as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbuildaudit> findByAuditpersonid(Object auditpersonid) {
		return findByProperty(AUDITPERSONID, auditpersonid);
	}

	public List<Txbuildaudit> findByAuditresult(Object auditresult) {
		return findByProperty(AUDITRESULT, auditresult);
	}

	public List<Txbuildaudit> findByAuditcomment(Object auditcomment) {
		return findByProperty(AUDITCOMMENT, auditcomment);
	}

	public List<Txbuildaudit> findByAudittype(Object audittype) {
		return findByProperty(AUDITTYPE, audittype);
	}

	public List<Txbuildaudit> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Txbuildaudit instances");
		try {
			String queryString = "from Txbuildaudit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbuildaudit merge(Txbuildaudit detachedInstance) {
		log.debug("merging Txbuildaudit instance");
		try {
			Txbuildaudit result = (Txbuildaudit) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbuildaudit instance) {
		log.debug("attaching dirty Txbuildaudit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbuildaudit instance) {
		log.debug("attaching clean Txbuildaudit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}