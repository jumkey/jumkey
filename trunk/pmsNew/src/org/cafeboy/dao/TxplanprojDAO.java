package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txplanproj;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txplanproj entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txplanproj
 * @author MyEclipse Persistence Tools
 */

public class TxplanprojDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxplanprojDAO.class);
	// property constants
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
	public static final String ADJUESTED = "adjuested";

	public void save(Txplanproj transientInstance) {
		log.debug("saving Txplanproj instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txplanproj persistentInstance) {
		log.debug("deleting Txplanproj instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txplanproj findById(java.lang.String id) {
		log.debug("getting Txplanproj instance with id: " + id);
		try {
			Txplanproj instance = (Txplanproj) getSession().get("org.cafeboy.model.Txplanproj", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txplanproj> findByExample(Txplanproj instance) {
		log.debug("finding Txplanproj instance by example");
		try {
			List<Txplanproj> results = (List<Txplanproj>) getSession().createCriteria("org.cafeboy.model.Txplanproj").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txplanproj instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txplanproj as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txplanproj> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Txplanproj> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<Txplanproj> findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List<Txplanproj> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List<Txplanproj> findByInvestattri(Object investattri) {
		return findByProperty(INVESTATTRI, investattri);
	}

	public List<Txplanproj> findByTotalinvest(Object totalinvest) {
		return findByProperty(TOTALINVEST, totalinvest);
	}

	public List<Txplanproj> findByThisinvest(Object thisinvest) {
		return findByProperty(THISINVEST, thisinvest);
	}

	public List<Txplanproj> findByNextinvest(Object nextinvest) {
		return findByProperty(NEXTINVEST, nextinvest);
	}

	public List<Txplanproj> findByPriority(Object priority) {
		return findByProperty(PRIORITY, priority);
	}

	public List<Txplanproj> findByExpendjan(Object expendjan) {
		return findByProperty(EXPENDJAN, expendjan);
	}

	public List<Txplanproj> findByExpendfeb(Object expendfeb) {
		return findByProperty(EXPENDFEB, expendfeb);
	}

	public List<Txplanproj> findByExpendmar(Object expendmar) {
		return findByProperty(EXPENDMAR, expendmar);
	}

	public List<Txplanproj> findByExpendapr(Object expendapr) {
		return findByProperty(EXPENDAPR, expendapr);
	}

	public List<Txplanproj> findByExpendmay(Object expendmay) {
		return findByProperty(EXPENDMAY, expendmay);
	}

	public List<Txplanproj> findByExpendjun(Object expendjun) {
		return findByProperty(EXPENDJUN, expendjun);
	}

	public List<Txplanproj> findByExpendjul(Object expendjul) {
		return findByProperty(EXPENDJUL, expendjul);
	}

	public List<Txplanproj> findByExpendaug(Object expendaug) {
		return findByProperty(EXPENDAUG, expendaug);
	}

	public List<Txplanproj> findByExpendsep(Object expendsep) {
		return findByProperty(EXPENDSEP, expendsep);
	}

	public List<Txplanproj> findByExpendoct(Object expendoct) {
		return findByProperty(EXPENDOCT, expendoct);
	}

	public List<Txplanproj> findByExpendnov(Object expendnov) {
		return findByProperty(EXPENDNOV, expendnov);
	}

	public List<Txplanproj> findByExpenddec(Object expenddec) {
		return findByProperty(EXPENDDEC, expenddec);
	}

	public List<Txplanproj> findByProjtype(Object projtype) {
		return findByProperty(PROJTYPE, projtype);
	}

	public List<Txplanproj> findByAdjuested(Object adjuested) {
		return findByProperty(ADJUESTED, adjuested);
	}

	public List findAll() {
		log.debug("finding all Txplanproj instances");
		try {
			String queryString = "from Txplanproj";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txplanproj merge(Txplanproj detachedInstance) {
		log.debug("merging Txplanproj instance");
		try {
			Txplanproj result = (Txplanproj) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txplanproj instance) {
		log.debug("attaching dirty Txplanproj instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txplanproj instance) {
		log.debug("attaching clean Txplanproj instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}