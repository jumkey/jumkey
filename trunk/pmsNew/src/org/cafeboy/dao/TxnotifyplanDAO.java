package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txnotifyplan;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txnotifyplan entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txnotifyplan
 * @author MyEclipse Persistence Tools
 */

public class TxnotifyplanDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxnotifyplanDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String INVESTSORTID = "investsortid";
	public static final String INVESTMONEY = "investmoney";

	public void save(Txnotifyplan transientInstance) {
		log.debug("saving Txnotifyplan instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txnotifyplan persistentInstance) {
		log.debug("deleting Txnotifyplan instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txnotifyplan findById(java.lang.String id) {
		log.debug("getting Txnotifyplan instance with id: " + id);
		try {
			Txnotifyplan instance = (Txnotifyplan) getSession().get("org.cafeboy.model.Txnotifyplan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txnotifyplan> findByExample(Txnotifyplan instance) {
		log.debug("finding Txnotifyplan instance by example");
		try {
			List<Txnotifyplan> results = (List<Txnotifyplan>) getSession().createCriteria("org.cafeboy.model.Txnotifyplan").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txnotifyplan instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txnotifyplan as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txnotifyplan> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List<Txnotifyplan> findByInvestsortid(Object investsortid) {
		return findByProperty(INVESTSORTID, investsortid);
	}

	public List<Txnotifyplan> findByInvestmoney(Object investmoney) {
		return findByProperty(INVESTMONEY, investmoney);
	}

	public List findAll() {
		log.debug("finding all Txnotifyplan instances");
		try {
			String queryString = "from Txnotifyplan";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txnotifyplan merge(Txnotifyplan detachedInstance) {
		log.debug("merging Txnotifyplan instance");
		try {
			Txnotifyplan result = (Txnotifyplan) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txnotifyplan instance) {
		log.debug("attaching dirty Txnotifyplan instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txnotifyplan instance) {
		log.debug("attaching clean Txnotifyplan instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}