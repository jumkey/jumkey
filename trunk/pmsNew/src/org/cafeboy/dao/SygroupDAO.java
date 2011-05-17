package org.cafeboy.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Sygroup;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Sygroup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Sygroup
 * @author MyEclipse Persistence Tools
 */

public class SygroupDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SygroupDAO.class);
	// property constants
	public static final String GROUPNAME = "groupname";
	public static final String GDELETES = "gdeletes";
	public static final String GROUPTYPE = "grouptype";
	public static final String DEPARTMENT = "department";

	public void save(Sygroup transientInstance) {
		log.debug("saving Sygroup instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sygroup persistentInstance) {
		log.debug("deleting Sygroup instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sygroup findById(java.lang.String id) {
		log.debug("getting Sygroup instance with id: " + id);
		try {
			Sygroup instance = (Sygroup) getSession().get("org.cafeboy.model.Sygroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Sygroup> findByExample(Sygroup instance) {
		log.debug("finding Sygroup instance by example");
		try {
			List<Sygroup> results = (List<Sygroup>) getSession().createCriteria("org.cafeboy.model.Sygroup").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Sygroup instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Sygroup as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Sygroup> findByGroupname(Object groupname) {
		return findByProperty(GROUPNAME, groupname);
	}

	public List<Sygroup> findByGdeletes(Object gdeletes) {
		return findByProperty(GDELETES, gdeletes);
	}

	public List<Sygroup> findByGrouptype(Object grouptype) {
		return findByProperty(GROUPTYPE, grouptype);
	}

	public List<Sygroup> findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findAll() {
		log.debug("finding all Sygroup instances");
		try {
			String queryString = "from Sygroup";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sygroup merge(Sygroup detachedInstance) {
		log.debug("merging Sygroup instance");
		try {
			Sygroup result = (Sygroup) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sygroup instance) {
		log.debug("attaching dirty Sygroup instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sygroup instance) {
		log.debug("attaching clean Sygroup instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}