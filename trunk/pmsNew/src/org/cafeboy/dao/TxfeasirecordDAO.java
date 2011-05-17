package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txfeasirecord;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txfeasirecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txfeasirecord
 * @author MyEclipse Persistence Tools
 */

public class TxfeasirecordDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxfeasirecordDAO.class);
	// property constants
	public static final String PROJECTID = "projectid";
	public static final String REPORTMONEY = "reportmoney";
	public static final String PROJRANGE = "projrange";
	public static final String STATE = "state";
	public static final String CREATORID = "creatorid";
	public static final String CONTENT = "content";

	public void save(Txfeasirecord transientInstance) {
		log.debug("saving Txfeasirecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txfeasirecord persistentInstance) {
		log.debug("deleting Txfeasirecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txfeasirecord findById(java.lang.String id) {
		log.debug("getting Txfeasirecord instance with id: " + id);
		try {
			Txfeasirecord instance = (Txfeasirecord) getSession().get("org.cafeboy.model.Txfeasirecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txfeasirecord> findByExample(Txfeasirecord instance) {
		log.debug("finding Txfeasirecord instance by example");
		try {
			List<Txfeasirecord> results = (List<Txfeasirecord>) getSession().createCriteria("org.cafeboy.model.Txfeasirecord").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txfeasirecord instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txfeasirecord as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txfeasirecord> findByProjectid(Object projectid) {
		return findByProperty(PROJECTID, projectid);
	}

	public List<Txfeasirecord> findByReportmoney(Object reportmoney) {
		return findByProperty(REPORTMONEY, reportmoney);
	}

	public List<Txfeasirecord> findByProjrange(Object projrange) {
		return findByProperty(PROJRANGE, projrange);
	}

	public List<Txfeasirecord> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txfeasirecord> findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List<Txfeasirecord> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Txfeasirecord instances");
		try {
			String queryString = "from Txfeasirecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txfeasirecord merge(Txfeasirecord detachedInstance) {
		log.debug("merging Txfeasirecord instance");
		try {
			Txfeasirecord result = (Txfeasirecord) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txfeasirecord instance) {
		log.debug("attaching dirty Txfeasirecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txfeasirecord instance) {
		log.debug("attaching clean Txfeasirecord instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}