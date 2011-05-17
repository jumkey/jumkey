package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbuildsplit;
import org.cafeboy.model.TxbuildsplitId;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbuildsplit entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbuildsplit
 * @author MyEclipse Persistence Tools
 */

public class TxbuildsplitDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbuildsplitDAO.class);

	// property constants

	public void save(Txbuildsplit transientInstance) {
		log.debug("saving Txbuildsplit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbuildsplit persistentInstance) {
		log.debug("deleting Txbuildsplit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbuildsplit findById(org.cafeboy.model.TxbuildsplitId id) {
		log.debug("getting Txbuildsplit instance with id: " + id);
		try {
			Txbuildsplit instance = (Txbuildsplit) getSession().get("org.cafeboy.model.Txbuildsplit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbuildsplit> findByExample(Txbuildsplit instance) {
		log.debug("finding Txbuildsplit instance by example");
		try {
			List<Txbuildsplit> results = (List<Txbuildsplit>) getSession().createCriteria("org.cafeboy.model.Txbuildsplit").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbuildsplit instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbuildsplit as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Txbuildsplit instances");
		try {
			String queryString = "from Txbuildsplit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbuildsplit merge(Txbuildsplit detachedInstance) {
		log.debug("merging Txbuildsplit instance");
		try {
			Txbuildsplit result = (Txbuildsplit) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbuildsplit instance) {
		log.debug("attaching dirty Txbuildsplit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbuildsplit instance) {
		log.debug("attaching clean Txbuildsplit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}