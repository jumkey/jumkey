package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txfagreearea;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txfagreearea entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txfagreearea
 * @author MyEclipse Persistence Tools
 */

public class TxfagreeareaDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxfagreeareaDAO.class);
	// property constants
	public static final String PROJECTID = "projectid";
	public static final String PCOMPANYAM = "pcompanyam";
	public static final String PCAGREEIDEA = "pcagreeidea";
	public static final String CREATORID = "creatorid";
	public static final String STATE = "state";
	public static final String APIDEA = "apidea";

	public void save(Txfagreearea transientInstance) {
		log.debug("saving Txfagreearea instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txfagreearea persistentInstance) {
		log.debug("deleting Txfagreearea instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txfagreearea findById(java.lang.String id) {
		log.debug("getting Txfagreearea instance with id: " + id);
		try {
			Txfagreearea instance = (Txfagreearea) getSession().get("org.cafeboy.model.Txfagreearea", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txfagreearea> findByExample(Txfagreearea instance) {
		log.debug("finding Txfagreearea instance by example");
		try {
			List<Txfagreearea> results = (List<Txfagreearea>) getSession().createCriteria("org.cafeboy.model.Txfagreearea").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txfagreearea instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txfagreearea as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txfagreearea> findByProjectid(Object projectid) {
		return findByProperty(PROJECTID, projectid);
	}

	public List<Txfagreearea> findByPcompanyam(Object pcompanyam) {
		return findByProperty(PCOMPANYAM, pcompanyam);
	}

	public List<Txfagreearea> findByPcagreeidea(Object pcagreeidea) {
		return findByProperty(PCAGREEIDEA, pcagreeidea);
	}

	public List<Txfagreearea> findByCreatorid(Object creatorid) {
		return findByProperty(CREATORID, creatorid);
	}

	public List<Txfagreearea> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txfagreearea> findByApidea(Object apidea) {
		return findByProperty(APIDEA, apidea);
	}

	public List findAll() {
		log.debug("finding all Txfagreearea instances");
		try {
			String queryString = "from Txfagreearea";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txfagreearea merge(Txfagreearea detachedInstance) {
		log.debug("merging Txfagreearea instance");
		try {
			Txfagreearea result = (Txfagreearea) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txfagreearea instance) {
		log.debug("attaching dirty Txfagreearea instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txfagreearea instance) {
		log.debug("attaching clean Txfagreearea instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}