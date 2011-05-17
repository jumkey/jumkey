package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txpprojedition;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txpprojedition entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txpprojedition
 * @author MyEclipse Persistence Tools
 */

public class TxpprojeditionDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxpprojeditionDAO.class);
	// property constants
	public static final String EDNO = "edno";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String CONTENT = "content";
	public static final String TYPE = "type";
	public static final String INVESTATTRI = "investattri";
	public static final String TOTALINVEST = "totalinvest";
	public static final String THISINVEST = "thisinvest";
	public static final String NEXTINVEST = "nextinvest";
	public static final String PRIORITY = "priority";
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
	public static final String PROJTYPE = "projtype";

	public void save(Txpprojedition transientInstance) {
		log.debug("saving Txpprojedition instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txpprojedition persistentInstance) {
		log.debug("deleting Txpprojedition instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txpprojedition findById(java.lang.String id) {
		log.debug("getting Txpprojedition instance with id: " + id);
		try {
			Txpprojedition instance = (Txpprojedition) getSession().get("org.cafeboy.model.Txpprojedition", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txpprojedition> findByExample(Txpprojedition instance) {
		log.debug("finding Txpprojedition instance by example");
		try {
			List<Txpprojedition> results = (List<Txpprojedition>) getSession().createCriteria("org.cafeboy.model.Txpprojedition").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txpprojedition instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txpprojedition as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txpprojedition> findByEdno(Object edno) {
		return findByProperty(EDNO, edno);
	}

	public List<Txpprojedition> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Txpprojedition> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<Txpprojedition> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Txpprojedition> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Txpprojedition> findByInvestattri(Object investattri) {
		return findByProperty(INVESTATTRI, investattri);
	}

	public List<Txpprojedition> findByTotalinvest(Object totalinvest) {
		return findByProperty(TOTALINVEST, totalinvest);
	}

	public List<Txpprojedition> findByThisinvest(Object thisinvest) {
		return findByProperty(THISINVEST, thisinvest);
	}

	public List<Txpprojedition> findByNextinvest(Object nextinvest) {
		return findByProperty(NEXTINVEST, nextinvest);
	}

	public List<Txpprojedition> findByPriority(Object priority) {
		return findByProperty(PRIORITY, priority);
	}

	public List<Txpprojedition> findByExpendjan(Object expendjan) {
		return findByProperty(EXPENDJAN, expendjan);
	}

	public List<Txpprojedition> findByExpendfeb(Object expendfeb) {
		return findByProperty(EXPENDFEB, expendfeb);
	}

	public List<Txpprojedition> findByExpendmar(Object expendmar) {
		return findByProperty(EXPENDMAR, expendmar);
	}

	public List<Txpprojedition> findByExpendapr(Object expendapr) {
		return findByProperty(EXPENDAPR, expendapr);
	}

	public List<Txpprojedition> findByExpendmay(Object expendmay) {
		return findByProperty(EXPENDMAY, expendmay);
	}

	public List<Txpprojedition> findByExpendjun(Object expendjun) {
		return findByProperty(EXPENDJUN, expendjun);
	}

	public List<Txpprojedition> findByExpendjul(Object expendjul) {
		return findByProperty(EXPENDJUL, expendjul);
	}

	public List<Txpprojedition> findByExpendaug(Object expendaug) {
		return findByProperty(EXPENDAUG, expendaug);
	}

	public List<Txpprojedition> findByExpendsep(Object expendsep) {
		return findByProperty(EXPENDSEP, expendsep);
	}

	public List<Txpprojedition> findByExpendoct(Object expendoct) {
		return findByProperty(EXPENDOCT, expendoct);
	}

	public List<Txpprojedition> findByExpendnov(Object expendnov) {
		return findByProperty(EXPENDNOV, expendnov);
	}

	public List<Txpprojedition> findByExpenddec(Object expenddec) {
		return findByProperty(EXPENDDEC, expenddec);
	}

	public List<Txpprojedition> findByProjtype(Object projtype) {
		return findByProperty(PROJTYPE, projtype);
	}

	public List findAll() {
		log.debug("finding all Txpprojedition instances");
		try {
			String queryString = "from Txpprojedition";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txpprojedition merge(Txpprojedition detachedInstance) {
		log.debug("merging Txpprojedition instance");
		try {
			Txpprojedition result = (Txpprojedition) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txpprojedition instance) {
		log.debug("attaching dirty Txpprojedition instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txpprojedition instance) {
		log.debug("attaching clean Txpprojedition instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}