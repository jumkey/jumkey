package org.cafeboy.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txplangather;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txplangather entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txplangather
 * @author MyEclipse Persistence Tools
 */

public class TxplangatherDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxplangatherDAO.class);
	// property constants
	public static final String CONTINUETOTAL = "continuetotal";
	public static final String CONTINSHED = "continshed";
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

	public void save(Txplangather transientInstance) {
		log.debug("saving Txplangather instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txplangather persistentInstance) {
		log.debug("deleting Txplangather instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txplangather findById(java.lang.String id) {
		log.debug("getting Txplangather instance with id: " + id);
		try {
			Txplangather instance = (Txplangather) getSession().get("org.cafeboy.model.Txplangather", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txplangather> findByExample(Txplangather instance) {
		log.debug("finding Txplangather instance by example");
		try {
			List<Txplangather> results = (List<Txplangather>) getSession().createCriteria("org.cafeboy.model.Txplangather").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txplangather instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txplangather as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txplangather> findByContinuetotal(Object continuetotal) {
		return findByProperty(CONTINUETOTAL, continuetotal);
	}

	public List<Txplangather> findByContinshed(Object continshed) {
		return findByProperty(CONTINSHED, continshed);
	}

	public List<Txplangather> findByNewtotal(Object newtotal) {
		return findByProperty(NEWTOTAL, newtotal);
	}

	public List<Txplangather> findByExpendjan(Object expendjan) {
		return findByProperty(EXPENDJAN, expendjan);
	}

	public List<Txplangather> findByExpendfeb(Object expendfeb) {
		return findByProperty(EXPENDFEB, expendfeb);
	}

	public List<Txplangather> findByExpendmar(Object expendmar) {
		return findByProperty(EXPENDMAR, expendmar);
	}

	public List<Txplangather> findByExpendapr(Object expendapr) {
		return findByProperty(EXPENDAPR, expendapr);
	}

	public List<Txplangather> findByExpendmay(Object expendmay) {
		return findByProperty(EXPENDMAY, expendmay);
	}

	public List<Txplangather> findByExpendjun(Object expendjun) {
		return findByProperty(EXPENDJUN, expendjun);
	}

	public List<Txplangather> findByExpendjul(Object expendjul) {
		return findByProperty(EXPENDJUL, expendjul);
	}

	public List<Txplangather> findByExpendaug(Object expendaug) {
		return findByProperty(EXPENDAUG, expendaug);
	}

	public List<Txplangather> findByExpendsep(Object expendsep) {
		return findByProperty(EXPENDSEP, expendsep);
	}

	public List<Txplangather> findByExpendoct(Object expendoct) {
		return findByProperty(EXPENDOCT, expendoct);
	}

	public List<Txplangather> findByExpendnov(Object expendnov) {
		return findByProperty(EXPENDNOV, expendnov);
	}

	public List<Txplangather> findByExpenddec(Object expenddec) {
		return findByProperty(EXPENDDEC, expenddec);
	}

	public List findAll() {
		log.debug("finding all Txplangather instances");
		try {
			String queryString = "from Txplangather";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txplangather merge(Txplangather detachedInstance) {
		log.debug("merging Txplangather instance");
		try {
			Txplangather result = (Txplangather) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txplangather instance) {
		log.debug("attaching dirty Txplangather instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txplangather instance) {
		log.debug("attaching clean Txplangather instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}