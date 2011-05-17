package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbapplyinvest;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbapplyinvest entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbapplyinvest
 * @author MyEclipse Persistence Tools
 */

public class TxbapplyinvestDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbapplyinvestDAO.class);
	// property constants
	public static final String PROJCONTENT = "projcontent";
	public static final String INVESTMENT = "investment";
	public static final String THISINVEST = "thisinvest";
	public static final String FORWARDINVEST = "forwardinvest";

	public void save(Txbapplyinvest transientInstance) {
		log.debug("saving Txbapplyinvest instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbapplyinvest persistentInstance) {
		log.debug("deleting Txbapplyinvest instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbapplyinvest findById(java.lang.String id) {
		log.debug("getting Txbapplyinvest instance with id: " + id);
		try {
			Txbapplyinvest instance = (Txbapplyinvest) getSession().get("org.cafeboy.model.Txbapplyinvest", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbapplyinvest> findByExample(Txbapplyinvest instance) {
		log.debug("finding Txbapplyinvest instance by example");
		try {
			List<Txbapplyinvest> results = (List<Txbapplyinvest>) getSession().createCriteria("org.cafeboy.model.Txbapplyinvest").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbapplyinvest instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbapplyinvest as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbapplyinvest> findByProjcontent(Object projcontent) {
		return findByProperty(PROJCONTENT, projcontent);
	}

	public List<Txbapplyinvest> findByInvestment(Object investment) {
		return findByProperty(INVESTMENT, investment);
	}

	public List<Txbapplyinvest> findByThisinvest(Object thisinvest) {
		return findByProperty(THISINVEST, thisinvest);
	}

	public List<Txbapplyinvest> findByForwardinvest(Object forwardinvest) {
		return findByProperty(FORWARDINVEST, forwardinvest);
	}

	public List findAll() {
		log.debug("finding all Txbapplyinvest instances");
		try {
			String queryString = "from Txbapplyinvest";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbapplyinvest merge(Txbapplyinvest detachedInstance) {
		log.debug("merging Txbapplyinvest instance");
		try {
			Txbapplyinvest result = (Txbapplyinvest) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbapplyinvest instance) {
		log.debug("attaching dirty Txbapplyinvest instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbapplyinvest instance) {
		log.debug("attaching clean Txbapplyinvest instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}