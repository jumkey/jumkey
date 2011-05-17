package org.cafeboy.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Msphase;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Msphase entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Msphase
 * @author MyEclipse Persistence Tools
 */

public class MsphaseDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MsphaseDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";

	public void save(Msphase transientInstance) {
		log.debug("saving Msphase instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Msphase persistentInstance) {
		log.debug("deleting Msphase instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Msphase findById(java.lang.String id) {
		log.debug("getting Msphase instance with id: " + id);
		try {
			Msphase instance = (Msphase) getSession().get("org.cafeboy.model.Msphase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Msphase> findByExample(Msphase instance) {
		log.debug("finding Msphase instance by example");
		try {
			List<Msphase> results = (List<Msphase>) getSession().createCriteria("org.cafeboy.model.Msphase").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Msphase instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Msphase as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Msphase> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Msphase> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		log.debug("finding all Msphase instances");
		try {
			String queryString = "from Msphase";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Msphase merge(Msphase detachedInstance) {
		log.debug("merging Msphase instance");
		try {
			Msphase result = (Msphase) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Msphase instance) {
		log.debug("attaching dirty Msphase instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Msphase instance) {
		log.debug("attaching clean Msphase instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}