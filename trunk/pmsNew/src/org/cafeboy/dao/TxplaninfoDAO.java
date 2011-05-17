package org.cafeboy.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txplaninfo;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txplaninfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txplaninfo
 * @author MyEclipse Persistence Tools
 */

public class TxplaninfoDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxplaninfoDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String AREA = "area";
	public static final String STATE = "state";

	public void save(Txplaninfo transientInstance) {
		log.debug("saving Txplaninfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txplaninfo persistentInstance) {
		log.debug("deleting Txplaninfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txplaninfo findById(java.lang.String id) {
		log.debug("getting Txplaninfo instance with id: " + id);
		try {
			Txplaninfo instance = (Txplaninfo) getSession().get("org.cafeboy.model.Txplaninfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txplaninfo> findByExample(Txplaninfo instance) {
		log.debug("finding Txplaninfo instance by example");
		try {
			List<Txplaninfo> results = (List<Txplaninfo>) getSession().createCriteria("org.cafeboy.model.Txplaninfo").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txplaninfo instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txplaninfo as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txplaninfo> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List<Txplaninfo> findByArea(Object area) {
		return findByProperty(AREA, area);
	}

	public List<Txplaninfo> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all Txplaninfo instances");
		try {
			String queryString = "from Txplaninfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txplaninfo merge(Txplaninfo detachedInstance) {
		log.debug("merging Txplaninfo instance");
		try {
			Txplaninfo result = (Txplaninfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txplaninfo instance) {
		log.debug("attaching dirty Txplaninfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txplaninfo instance) {
		log.debug("attaching clean Txplaninfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}