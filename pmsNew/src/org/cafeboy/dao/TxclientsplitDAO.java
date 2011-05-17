package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txclientsplit;
import org.cafeboy.model.TxclientsplitId;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txclientsplit entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txclientsplit
 * @author MyEclipse Persistence Tools
 */

public class TxclientsplitDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxclientsplitDAO.class);

	// property constants

	public void save(Txclientsplit transientInstance) {
		log.debug("saving Txclientsplit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txclientsplit persistentInstance) {
		log.debug("deleting Txclientsplit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txclientsplit findById(org.cafeboy.model.TxclientsplitId id) {
		log.debug("getting Txclientsplit instance with id: " + id);
		try {
			Txclientsplit instance = (Txclientsplit) getSession().get("org.cafeboy.model.Txclientsplit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txclientsplit> findByExample(Txclientsplit instance) {
		log.debug("finding Txclientsplit instance by example");
		try {
			List<Txclientsplit> results = (List<Txclientsplit>) getSession().createCriteria("org.cafeboy.model.Txclientsplit").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txclientsplit instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txclientsplit as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Txclientsplit instances");
		try {
			String queryString = "from Txclientsplit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txclientsplit merge(Txclientsplit detachedInstance) {
		log.debug("merging Txclientsplit instance");
		try {
			Txclientsplit result = (Txclientsplit) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txclientsplit instance) {
		log.debug("attaching dirty Txclientsplit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txclientsplit instance) {
		log.debug("attaching clean Txclientsplit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}