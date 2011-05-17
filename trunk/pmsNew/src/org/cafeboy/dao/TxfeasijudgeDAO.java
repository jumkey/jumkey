package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txfeasijudge;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txfeasijudge entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txfeasijudge
 * @author MyEclipse Persistence Tools
 */

public class TxfeasijudgeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxfeasijudgeDAO.class);
	// property constants
	public static final String PROJECTID = "projectid";
	public static final String PCAGREEMONEY = "pcagreemoney";
	public static final String PCAGREEIDEA = "pcagreeidea";
	public static final String CREATORID = "creatorid";
	public static final String STATE = "state";
	public static final String JUDGEIDEA = "judgeidea";

	public void save(Txfeasijudge transientInstance) {
		log.debug("saving Txfeasijudge instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txfeasijudge persistentInstance) {
		log.debug("deleting Txfeasijudge instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txfeasijudge findById(java.lang.String id) {
		log.debug("getting Txfeasijudge instance with id: " + id);
		try {
			Txfeasijudge instance = (Txfeasijudge) getSession().get("org.cafeboy.model.Txfeasijudge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txfeasijudge> findByExample(Txfeasijudge instance) {
		log.debug("finding Txfeasijudge instance by example");
		try {
			List<Txfeasijudge> results = (List<Txfeasijudge>) getSession().createCriteria("org.cafeboy.model.Txfeasijudge").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txfeasijudge instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txfeasijudge as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txfeasijudge> findByProjectid(Object projectid) {
		return findByProperty(PROJECTID, projectid);
	}

	public List<Txfeasijudge> findByPcagreemoney(Object pcagreemoney) {
		return findByProperty(PCAGREEMONEY, pcagreemoney);
	}

	public List<Txfeasijudge> findByPcagreeidea(Object pcagreeidea) {
		return findByProperty(PCAGREEIDEA, pcagreeidea);
	}

	public List<Txfeasijudge> findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List<Txfeasijudge> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txfeasijudge> findByJudgeidea(Object judgeidea) {
		return findByProperty(JUDGEIDEA, judgeidea);
	}

	public List findAll() {
		log.debug("finding all Txfeasijudge instances");
		try {
			String queryString = "from Txfeasijudge";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txfeasijudge merge(Txfeasijudge detachedInstance) {
		log.debug("merging Txfeasijudge instance");
		try {
			Txfeasijudge result = (Txfeasijudge) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txfeasijudge instance) {
		log.debug("attaching dirty Txfeasijudge instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txfeasijudge instance) {
		log.debug("attaching clean Txfeasijudge instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}