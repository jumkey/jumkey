package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txproject;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txproject entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txproject
 * @author MyEclipse Persistence Tools
 */

public class TxprojectDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxprojectDAO.class);
	// property constants
	public static final String PROJNAME = "projname";
	public static final String PROJCODE = "projcode";
	public static final String PROJINVEST = "projinvest";
	public static final String CONSTRUCTUNIT = "constructunit";
	public static final String BUILDPROPERTY = "buildproperty";
	public static final String PRINCIPAL = "principal";
	public static final String TERM = "term";
	public static final String CONTENT = "content";
	public static final String STATE = "state";
	public static final String URGENCYDEGREE = "urgencydegree";
	public static final String APPLYUNIT = "applyunit";

	public void save(Txproject transientInstance) {
		log.debug("saving Txproject instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txproject persistentInstance) {
		log.debug("deleting Txproject instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txproject findById(java.lang.String id) {
		log.debug("getting Txproject instance with id: " + id);
		try {
			Txproject instance = (Txproject) getSession().get("org.cafeboy.model.Txproject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txproject> findByExample(Txproject instance) {
		log.debug("finding Txproject instance by example");
		try {
			List<Txproject> results = (List<Txproject>) getSession().createCriteria("org.cafeboy.model.Txproject").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txproject instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txproject as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txproject> findByProjname(Object projname) {
		return findByProperty(PROJNAME, projname);
	}

	public List<Txproject> findByProjcode(Object projcode) {
		return findByProperty(PROJCODE, projcode);
	}

	public List<Txproject> findByProjinvest(Object projinvest) {
		return findByProperty(PROJINVEST, projinvest);
	}

	public List<Txproject> findByConstructunit(Object constructunit) {
		return findByProperty(CONSTRUCTUNIT, constructunit);
	}

	public List<Txproject> findByBuildproperty(Object buildproperty) {
		return findByProperty(BUILDPROPERTY, buildproperty);
	}

	public List<Txproject> findByPrincipal(Object principal) {
		return findByProperty(PRINCIPAL, principal);
	}

	public List<Txproject> findByTerm(Object term) {
		return findByProperty(TERM, term);
	}

	public List<Txproject> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Txproject> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txproject> findByUrgencydegree(Object urgencydegree) {
		return findByProperty(URGENCYDEGREE, urgencydegree);
	}

	public List<Txproject> findByApplyunit(Object applyunit) {
		return findByProperty(APPLYUNIT, applyunit);
	}

	public List findAll() {
		log.debug("finding all Txproject instances");
		try {
			String queryString = "from Txproject";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txproject merge(Txproject detachedInstance) {
		log.debug("merging Txproject instance");
		try {
			Txproject result = (Txproject) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txproject instance) {
		log.debug("attaching dirty Txproject instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txproject instance) {
		log.debug("attaching clean Txproject instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}