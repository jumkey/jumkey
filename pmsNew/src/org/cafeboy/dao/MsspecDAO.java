package org.cafeboy.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Msspec;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Msspec entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Msspec
 * @author MyEclipse Persistence Tools
 */

public class MsspecDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(MsspecDAO.class);
	// property constants
	public static final String CODE = "code";
	public static final String NAME = "name";
	public static final String SHORTNAME = "shortname";

	public void save(Msspec transientInstance) {
		log.debug("saving Msspec instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Msspec persistentInstance) {
		log.debug("deleting Msspec instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Msspec findById(java.lang.String id) {
		log.debug("getting Msspec instance with id: " + id);
		try {
			Msspec instance = (Msspec) getSession().get("org.cafeboy.model.Msspec", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Msspec> findByExample(Msspec instance) {
		log.debug("finding Msspec instance by example");
		try {
			List<Msspec> results = (List<Msspec>) getSession().createCriteria("org.cafeboy.model.Msspec").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Msspec instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Msspec as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Msspec> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<Msspec> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Msspec> findByShortname(Object shortname) {
		return findByProperty(SHORTNAME, shortname);
	}

	public List findAll() {
		log.debug("finding all Msspec instances");
		try {
			String queryString = "from Msspec";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Msspec merge(Msspec detachedInstance) {
		log.debug("merging Msspec instance");
		try {
			Msspec result = (Msspec) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Msspec instance) {
		log.debug("attaching dirty Msspec instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Msspec instance) {
		log.debug("attaching clean Msspec instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}