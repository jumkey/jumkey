package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Sypermission;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sypermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Sypermission
 * @author MyEclipse Persistence Tools
 */

public class SypermissionDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SypermissionDAO.class);

	// property constants

	public void save(Sypermission transientInstance) {
		log.debug("saving Sypermission instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sypermission persistentInstance) {
		log.debug("deleting Sypermission instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sypermission findById(java.lang.String id) {
		log.debug("getting Sypermission instance with id: " + id);
		try {
			Sypermission instance = (Sypermission) getSession().get("org.cafeboy.model.Sypermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sypermission> findByExample(Sypermission instance) {
		log.debug("finding Sypermission instance by example");
		try {
			List<Sypermission> results = (List<Sypermission>) getSession().createCriteria("org.cafeboy.model.Sypermission").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sypermission instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Sypermission as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Sypermission instances");
		try {
			String queryString = "from Sypermission";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sypermission merge(Sypermission detachedInstance) {
		log.debug("merging Sypermission instance");
		try {
			Sypermission result = (Sypermission) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sypermission instance) {
		log.debug("attaching dirty Sypermission instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sypermission instance) {
		log.debug("attaching clean Sypermission instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}