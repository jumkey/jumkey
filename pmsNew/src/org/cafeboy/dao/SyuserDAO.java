package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Syuser;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Syuser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Syuser
 * @author MyEclipse Persistence Tools
 */

public class SyuserDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SyuserDAO.class);
	// property constants
	public static final String LOGINNAME = "loginname";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String ACTIVESYMBOL = "activesymbol";
	public static final String DELETESYMBOL = "deletesymbol";
	public static final String OFFICENUMBER = "officenumber";
	public static final String MOBILENUMBER = "mobilenumber";
	public static final String EMAIL = "email";

	public void save(Syuser transientInstance) {
		log.debug("saving Syuser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Syuser persistentInstance) {
		log.debug("deleting Syuser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Syuser findById(java.lang.String id) {
		log.debug("getting Syuser instance with id: " + id);
		try {
			Syuser instance = (Syuser) getSession().get("org.cafeboy.model.Syuser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Syuser> findByExample(Syuser instance) {
		log.debug("finding Syuser instance by example");
		try {
			List<Syuser> results = (List<Syuser>) getSession().createCriteria("org.cafeboy.model.Syuser").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Syuser instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Syuser as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Syuser> findByLoginname(Object loginname) {
		return findByProperty(LOGINNAME, loginname);
	}

	public List<Syuser> findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List<Syuser> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Syuser> findByActivesymbol(Object activesymbol) {
		return findByProperty(ACTIVESYMBOL, activesymbol);
	}

	public List<Syuser> findByDeletesymbol(Object deletesymbol) {
		return findByProperty(DELETESYMBOL, deletesymbol);
	}

	public List<Syuser> findByOfficenumber(Object officenumber) {
		return findByProperty(OFFICENUMBER, officenumber);
	}

	public List<Syuser> findByMobilenumber(Object mobilenumber) {
		return findByProperty(MOBILENUMBER, mobilenumber);
	}

	public List<Syuser> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findAll() {
		log.debug("finding all Syuser instances");
		try {
			String queryString = "from Syuser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Syuser merge(Syuser detachedInstance) {
		log.debug("merging Syuser instance");
		try {
			Syuser result = (Syuser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Syuser instance) {
		log.debug("attaching dirty Syuser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Syuser instance) {
		log.debug("attaching clean Syuser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}