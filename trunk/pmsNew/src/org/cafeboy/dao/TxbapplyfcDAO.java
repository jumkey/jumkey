package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbapplyfc;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbapplyfc entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbapplyfc
 * @author MyEclipse Persistence Tools
 */

public class TxbapplyfcDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbapplyfcDAO.class);
	// property constants
	public static final String MAINRES = "mainres";
	public static final String TOTALCAPACITY = "totalcapacity";
	public static final String USEDCAPACITY = "usedcapacity";
	public static final String RATION = "ration";
	public static final String FOREHAYEARC = "forehayearc";
	public static final String FOREYEARC = "foreyearc";

	public void save(Txbapplyfc transientInstance) {
		log.debug("saving Txbapplyfc instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbapplyfc persistentInstance) {
		log.debug("deleting Txbapplyfc instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbapplyfc findById(java.lang.String id) {
		log.debug("getting Txbapplyfc instance with id: " + id);
		try {
			Txbapplyfc instance = (Txbapplyfc) getSession().get("org.cafeboy.model.Txbapplyfc", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbapplyfc> findByExample(Txbapplyfc instance) {
		log.debug("finding Txbapplyfc instance by example");
		try {
			List<Txbapplyfc> results = (List<Txbapplyfc>) getSession().createCriteria("org.cafeboy.model.Txbapplyfc").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbapplyfc instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbapplyfc as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbapplyfc> findByMainres(Object mainres) {
		return findByProperty(MAINRES, mainres);
	}

	public List<Txbapplyfc> findByTotalcapacity(Object totalcapacity) {
		return findByProperty(TOTALCAPACITY, totalcapacity);
	}

	public List<Txbapplyfc> findByUsedcapacity(Object usedcapacity) {
		return findByProperty(USEDCAPACITY, usedcapacity);
	}

	public List<Txbapplyfc> findByRation(Object ration) {
		return findByProperty(RATION, ration);
	}

	public List<Txbapplyfc> findByForehayearc(Object forehayearc) {
		return findByProperty(FOREHAYEARC, forehayearc);
	}

	public List<Txbapplyfc> findByForeyearc(Object foreyearc) {
		return findByProperty(FOREYEARC, foreyearc);
	}

	public List findAll() {
		log.debug("finding all Txbapplyfc instances");
		try {
			String queryString = "from Txbapplyfc";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbapplyfc merge(Txbapplyfc detachedInstance) {
		log.debug("merging Txbapplyfc instance");
		try {
			Txbapplyfc result = (Txbapplyfc) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbapplyfc instance) {
		log.debug("attaching dirty Txbapplyfc instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbapplyfc instance) {
		log.debug("attaching clean Txbapplyfc instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}