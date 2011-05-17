package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txfaprovince;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txfaprovince entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txfaprovince
 * @author MyEclipse Persistence Tools
 */

public class TxfaprovinceDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxfaprovinceDAO.class);
	// property constants
	public static final String PROJECTID = "projectid";
	public static final String GCAGREEMONEY = "gcagreemoney";
	public static final String GCAGREEIDEA = "gcagreeidea";
	public static final String CREATORID = "creatorid";
	public static final String STATE = "state";
	public static final String GREEIDEA = "greeidea";

	public void save(Txfaprovince transientInstance) {
		log.debug("saving Txfaprovince instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txfaprovince persistentInstance) {
		log.debug("deleting Txfaprovince instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txfaprovince findById(java.lang.String id) {
		log.debug("getting Txfaprovince instance with id: " + id);
		try {
			Txfaprovince instance = (Txfaprovince) getSession().get("org.cafeboy.model.Txfaprovince", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txfaprovince> findByExample(Txfaprovince instance) {
		log.debug("finding Txfaprovince instance by example");
		try {
			List<Txfaprovince> results = (List<Txfaprovince>) getSession().createCriteria("org.cafeboy.model.Txfaprovince").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txfaprovince instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txfaprovince as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txfaprovince> findByProjectid(Object projectid) {
		return findByProperty(PROJECTID, projectid);
	}

	public List<Txfaprovince> findByGcagreemoney(Object gcagreemoney) {
		return findByProperty(GCAGREEMONEY, gcagreemoney);
	}

	public List<Txfaprovince> findByGcagreeidea(Object gcagreeidea) {
		return findByProperty(GCAGREEIDEA, gcagreeidea);
	}

	public List<Txfaprovince> findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List<Txfaprovince> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txfaprovince> findByGreeidea(Object greeidea) {
		return findByProperty(GREEIDEA, greeidea);
	}

	public List findAll() {
		log.debug("finding all Txfaprovince instances");
		try {
			String queryString = "from Txfaprovince";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txfaprovince merge(Txfaprovince detachedInstance) {
		log.debug("merging Txfaprovince instance");
		try {
			Txfaprovince result = (Txfaprovince) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txfaprovince instance) {
		log.debug("attaching dirty Txfaprovince instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txfaprovince instance) {
		log.debug("attaching clean Txfaprovince instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}