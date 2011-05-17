package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbuildjudge;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbuildjudge entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbuildjudge
 * @author MyEclipse Persistence Tools
 */

public class TxbuildjudgeDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbuildjudgeDAO.class);
	// property constants
	public static final String JUDGEPERSONID = "judgepersonid";
	public static final String JUDGERESULT = "judgeresult";
	public static final String JUDGECOMMENT = "judgecomment";
	public static final String JUDGEROLE = "judgerole";

	public void save(Txbuildjudge transientInstance) {
		log.debug("saving Txbuildjudge instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbuildjudge persistentInstance) {
		log.debug("deleting Txbuildjudge instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbuildjudge findById(java.lang.String id) {
		log.debug("getting Txbuildjudge instance with id: " + id);
		try {
			Txbuildjudge instance = (Txbuildjudge) getSession().get("org.cafeboy.model.Txbuildjudge", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbuildjudge> findByExample(Txbuildjudge instance) {
		log.debug("finding Txbuildjudge instance by example");
		try {
			List<Txbuildjudge> results = (List<Txbuildjudge>) getSession().createCriteria("org.cafeboy.model.Txbuildjudge").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbuildjudge instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbuildjudge as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbuildjudge> findByJudgepersonid(Object judgepersonid) {
		return findByProperty(JUDGEPERSONID, judgepersonid);
	}

	public List<Txbuildjudge> findByJudgeresult(Object judgeresult) {
		return findByProperty(JUDGERESULT, judgeresult);
	}

	public List<Txbuildjudge> findByJudgecomment(Object judgecomment) {
		return findByProperty(JUDGECOMMENT, judgecomment);
	}

	public List<Txbuildjudge> findByJudgerole(Object judgerole) {
		return findByProperty(JUDGEROLE, judgerole);
	}

	public List findAll() {
		log.debug("finding all Txbuildjudge instances");
		try {
			String queryString = "from Txbuildjudge";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbuildjudge merge(Txbuildjudge detachedInstance) {
		log.debug("merging Txbuildjudge instance");
		try {
			Txbuildjudge result = (Txbuildjudge) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbuildjudge instance) {
		log.debug("attaching dirty Txbuildjudge instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbuildjudge instance) {
		log.debug("attaching clean Txbuildjudge instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}