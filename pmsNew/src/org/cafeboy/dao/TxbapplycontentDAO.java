package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbapplycontent;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbapplycontent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbapplycontent
 * @author MyEclipse Persistence Tools
 */

public class TxbapplycontentDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbapplycontentDAO.class);
	// property constants
	public static final String CCONTENT = "ccontent";
	public static final String SCALE = "scale";
	public static final String TERM = "term";
	public static final String CYCLE = "cycle";

	public void save(Txbapplycontent transientInstance) {
		log.debug("saving Txbapplycontent instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbapplycontent persistentInstance) {
		log.debug("deleting Txbapplycontent instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbapplycontent findById(java.lang.String id) {
		log.debug("getting Txbapplycontent instance with id: " + id);
		try {
			Txbapplycontent instance = (Txbapplycontent) getSession().get("org.cafeboy.model.Txbapplycontent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbapplycontent> findByExample(Txbapplycontent instance) {
		log.debug("finding Txbapplycontent instance by example");
		try {
			List<Txbapplycontent> results = (List<Txbapplycontent>) getSession().createCriteria("org.cafeboy.model.Txbapplycontent").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbapplycontent instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbapplycontent as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbapplycontent> findByCcontent(Object ccontent) {
		return findByProperty(CCONTENT, ccontent);
	}

	public List<Txbapplycontent> findByScale(Object scale) {
		return findByProperty(SCALE, scale);
	}

	public List<Txbapplycontent> findByTerm(Object term) {
		return findByProperty(TERM, term);
	}

	public List<Txbapplycontent> findByCycle(Object cycle) {
		return findByProperty(CYCLE, cycle);
	}

	public List findAll() {
		log.debug("finding all Txbapplycontent instances");
		try {
			String queryString = "from Txbapplycontent";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbapplycontent merge(Txbapplycontent detachedInstance) {
		log.debug("merging Txbapplycontent instance");
		try {
			Txbapplycontent result = (Txbapplycontent) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbapplycontent instance) {
		log.debug("attaching dirty Txbapplycontent instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbapplycontent instance) {
		log.debug("attaching clean Txbapplycontent instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}