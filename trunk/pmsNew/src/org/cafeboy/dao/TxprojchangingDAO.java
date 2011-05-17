package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txprojchanging;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txprojchanging entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txprojchanging
 * @author MyEclipse Persistence Tools
 */

public class TxprojchangingDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxprojchangingDAO.class);
	// property constants
	public static final String CHINGTYPE = "chingtype";
	public static final String ORIGINALMONEY = "originalmoney";
	public static final String AFTCMONEY = "aftcmoney";
	public static final String STATE = "state";
	public static final String DESCRIPTION = "description";

	public void save(Txprojchanging transientInstance) {
		log.debug("saving Txprojchanging instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txprojchanging persistentInstance) {
		log.debug("deleting Txprojchanging instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txprojchanging findById(java.lang.String id) {
		log.debug("getting Txprojchanging instance with id: " + id);
		try {
			Txprojchanging instance = (Txprojchanging) getSession().get("org.cafeboy.model.Txprojchanging", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txprojchanging> findByExample(Txprojchanging instance) {
		log.debug("finding Txprojchanging instance by example");
		try {
			List<Txprojchanging> results = (List<Txprojchanging>) getSession().createCriteria("org.cafeboy.model.Txprojchanging").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txprojchanging instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txprojchanging as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txprojchanging> findByChingtype(Object chingtype) {
		return findByProperty(CHINGTYPE, chingtype);
	}

	public List<Txprojchanging> findByOriginalmoney(Object originalmoney) {
		return findByProperty(ORIGINALMONEY, originalmoney);
	}

	public List<Txprojchanging> findByAftcmoney(Object aftcmoney) {
		return findByProperty(AFTCMONEY, aftcmoney);
	}

	public List<Txprojchanging> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txprojchanging> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Txprojchanging instances");
		try {
			String queryString = "from Txprojchanging";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txprojchanging merge(Txprojchanging detachedInstance) {
		log.debug("merging Txprojchanging instance");
		try {
			Txprojchanging result = (Txprojchanging) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txprojchanging instance) {
		log.debug("attaching dirty Txprojchanging instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txprojchanging instance) {
		log.debug("attaching clean Txprojchanging instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}