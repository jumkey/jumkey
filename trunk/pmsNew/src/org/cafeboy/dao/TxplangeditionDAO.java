package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txplangedition;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txplangedition entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txplangedition
 * @author MyEclipse Persistence Tools
 */

public class TxplangeditionDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxplangeditionDAO.class);
	// property constants
	public static final String EDNO = "edno";
	public static final String CONTINUETOTAL = "continuetotal";
	public static final String CONTIISHED = "contiished";
	public static final String NEWTOTAL = "newtotal";
	public static final String EXPENDJAN = "expendjan";
	public static final String EXPENDFEB = "expendfeb";
	public static final String EXPENDMAR = "expendmar";
	public static final String EXPENDAPR = "expendapr";
	public static final String EXPENDMAY = "expendmay";
	public static final String EXPENDJUN = "expendjun";
	public static final String EXPENDJUL = "expendjul";
	public static final String EXPENDAUG = "expendaug";
	public static final String EXPENDSEP = "expendsep";
	public static final String EXPENDOCT = "expendoct";
	public static final String EXPENDNOV = "expendnov";
	public static final String EXPENDDEC = "expenddec";

	public void save(Txplangedition transientInstance) {
		log.debug("saving Txplangedition instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txplangedition persistentInstance) {
		log.debug("deleting Txplangedition instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txplangedition findById(java.lang.String id) {
		log.debug("getting Txplangedition instance with id: " + id);
		try {
			Txplangedition instance = (Txplangedition) getSession().get("org.cafeboy.model.Txplangedition", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txplangedition> findByExample(Txplangedition instance) {
		log.debug("finding Txplangedition instance by example");
		try {
			List<Txplangedition> results = (List<Txplangedition>) getSession().createCriteria("org.cafeboy.model.Txplangedition").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txplangedition instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txplangedition as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txplangedition> findByEdno(Object edno) {
		return findByProperty(EDNO, edno);
	}

	public List<Txplangedition> findByContinuetotal(Object continuetotal) {
		return findByProperty(CONTINUETOTAL, continuetotal);
	}

	public List<Txplangedition> findByContiished(Object contiished) {
		return findByProperty(CONTIISHED, contiished);
	}

	public List<Txplangedition> findByNewtotal(Object newtotal) {
		return findByProperty(NEWTOTAL, newtotal);
	}

	public List<Txplangedition> findByExpendjan(Object expendjan) {
		return findByProperty(EXPENDJAN, expendjan);
	}

	public List<Txplangedition> findByExpendfeb(Object expendfeb) {
		return findByProperty(EXPENDFEB, expendfeb);
	}

	public List<Txplangedition> findByExpendmar(Object expendmar) {
		return findByProperty(EXPENDMAR, expendmar);
	}

	public List<Txplangedition> findByExpendapr(Object expendapr) {
		return findByProperty(EXPENDAPR, expendapr);
	}

	public List<Txplangedition> findByExpendmay(Object expendmay) {
		return findByProperty(EXPENDMAY, expendmay);
	}

	public List<Txplangedition> findByExpendjun(Object expendjun) {
		return findByProperty(EXPENDJUN, expendjun);
	}

	public List<Txplangedition> findByExpendjul(Object expendjul) {
		return findByProperty(EXPENDJUL, expendjul);
	}

	public List<Txplangedition> findByExpendaug(Object expendaug) {
		return findByProperty(EXPENDAUG, expendaug);
	}

	public List<Txplangedition> findByExpendsep(Object expendsep) {
		return findByProperty(EXPENDSEP, expendsep);
	}

	public List<Txplangedition> findByExpendoct(Object expendoct) {
		return findByProperty(EXPENDOCT, expendoct);
	}

	public List<Txplangedition> findByExpendnov(Object expendnov) {
		return findByProperty(EXPENDNOV, expendnov);
	}

	public List<Txplangedition> findByExpenddec(Object expenddec) {
		return findByProperty(EXPENDDEC, expenddec);
	}

	public List findAll() {
		log.debug("finding all Txplangedition instances");
		try {
			String queryString = "from Txplangedition";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txplangedition merge(Txplangedition detachedInstance) {
		log.debug("merging Txplangedition instance");
		try {
			Txplangedition result = (Txplangedition) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txplangedition instance) {
		log.debug("attaching dirty Txplangedition instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txplangedition instance) {
		log.debug("attaching clean Txplangedition instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}