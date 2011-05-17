package org.cafeboy.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.cafeboy.model.Txbuildapply;
import org.hibernate.LockMode;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;

/**
 * A data access object (DAO) providing persistence and search support for
 * Txbuildapply entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.cafeboy.model.Txbuildapply
 * @author MyEclipse Persistence Tools
 */

public class TxbuildapplyDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TxbuildapplyDAO.class);
	// property constants
	public static final String YEAR = "year";
	public static final String NAME = "name";
	public static final String CODE = "code";
	public static final String TERM = "term";
	public static final String APPLYUNIT = "applyunit";
	public static final String CHARGEUNIT = "chargeunit";
	public static final String CONSTRUCTUNIT = "constructunit";
	public static final String MIANBODY = "mianbody";
	public static final String TOTALINVEST = "totalinvest";
	public static final String TOTALMARKINVEST = "totalmarkinvest";
	public static final String TOTALNOTMI = "totalnotmi";
	public static final String INVESTRETSORT = "investretsort";
	public static final String AREAINVESTSORT = "areainvestsort";
	public static final String URGENCYDEGREE = "urgencydegree";
	public static final String ISINBUDGET = "isinbudget";
	public static final String PROJCODE = "projcode";
	public static final String ARCHICODE = "archicode";
	public static final String MOTIVE = "motive";
	public static final String INCOMEYEAR1 = "incomeyear1";
	public static final String INCOMEYEAR2 = "incomeyear2";
	public static final String INCOMEYEAR3 = "incomeyear3";
	public static final String INCOMEYEAR4 = "incomeyear4";
	public static final String INCOMEYEAR5 = "incomeyear5";
	public static final String INCOMEYEAR6 = "incomeyear6";
	public static final String INCOMEYEAR7 = "incomeyear7";
	public static final String COSTYEAR1 = "costyear1";
	public static final String COSTYEAR2 = "costyear2";
	public static final String COSTYEAR3 = "costyear3";
	public static final String COSTYEAR4 = "costyear4";
	public static final String COSTYEAR5 = "costyear5";
	public static final String COSTYEAR6 = "costyear6";
	public static final String COSTYEAR7 = "costyear7";
	public static final String IRR = "irr";
	public static final String NPV = "npv";
	public static final String CALLBACKTERM = "callbackterm";
	public static final String RESULT = "result";
	public static final String PROJMANAGER = "projmanager";
	public static final String AGENERALM = "ageneralm";
	public static final String INTFPERSON = "intfperson";
	public static final String STATE = "state";
	public static final String JUDGED = "judged";
	public static final String LAYOUTCODE = "layoutcode";
	public static final String INVESTATTRI = "investattri";
	public static final String SPLITSTATE = "splitstate";
	public static final String CUSTPROJTYPE = "custprojtype";
	public static final String ISFEASIBLE = "isfeasible";
	public static final String ISODD = "isodd";
	public static final String ISCUST = "iscust";
	public static final String CONSTRUCTPROP = "constructprop";
	public static final String ISPROVPROJ = "isprovproj";
	public static final String INVESTSORT = "investsort";
	public static final String ISMOVEALERT = "ismovealert";
	public static final String PARASPECS = "paraspecs";
	public static final String ISNEEDSPLIT = "isneedsplit";
	public static final String APPLYPERSON = "applyperson";
	public static final String REPLY = "reply";

	public void save(Txbuildapply transientInstance) {
		log.debug("saving Txbuildapply instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Txbuildapply persistentInstance) {
		log.debug("deleting Txbuildapply instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Txbuildapply findById(java.lang.String id) {
		log.debug("getting Txbuildapply instance with id: " + id);
		try {
			Txbuildapply instance = (Txbuildapply) getSession().get("org.cafeboy.model.Txbuildapply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Txbuildapply> findByExample(Txbuildapply instance) {
		log.debug("finding Txbuildapply instance by example");
		try {
			List<Txbuildapply> results = (List<Txbuildapply>) getSession().createCriteria("org.cafeboy.model.Txbuildapply").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Txbuildapply instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Txbuildapply as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Txbuildapply> findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List<Txbuildapply> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Txbuildapply> findByCode(Object code) {
		return findByProperty(CODE, code);
	}

	public List<Txbuildapply> findByTerm(Object term) {
		return findByProperty(TERM, term);
	}

	public List<Txbuildapply> findByApplyunit(Object applyunit) {
		return findByProperty(APPLYUNIT, applyunit);
	}

	public List<Txbuildapply> findByChargeunit(Object chargeunit) {
		return findByProperty(CHARGEUNIT, chargeunit);
	}

	public List<Txbuildapply> findByConstructunit(Object constructunit) {
		return findByProperty(CONSTRUCTUNIT, constructunit);
	}

	public List<Txbuildapply> findByMianbody(Object mianbody) {
		return findByProperty(MIANBODY, mianbody);
	}

	public List<Txbuildapply> findByTotalinvest(Object totalinvest) {
		return findByProperty(TOTALINVEST, totalinvest);
	}

	public List<Txbuildapply> findByTotalmarkinvest(Object totalmarkinvest) {
		return findByProperty(TOTALMARKINVEST, totalmarkinvest);
	}

	public List<Txbuildapply> findByTotalnotmi(Object totalnotmi) {
		return findByProperty(TOTALNOTMI, totalnotmi);
	}

	public List<Txbuildapply> findByInvestretsort(Object investretsort) {
		return findByProperty(INVESTRETSORT, investretsort);
	}

	public List<Txbuildapply> findByAreainvestsort(Object areainvestsort) {
		return findByProperty(AREAINVESTSORT, areainvestsort);
	}

	public List<Txbuildapply> findByUrgencydegree(Object urgencydegree) {
		return findByProperty(URGENCYDEGREE, urgencydegree);
	}

	public List<Txbuildapply> findByIsinbudget(Object isinbudget) {
		return findByProperty(ISINBUDGET, isinbudget);
	}

	public List<Txbuildapply> findByProjcode(Object projcode) {
		return findByProperty(PROJCODE, projcode);
	}

	public List<Txbuildapply> findByArchicode(Object archicode) {
		return findByProperty(ARCHICODE, archicode);
	}

	public List<Txbuildapply> findByMotive(Object motive) {
		return findByProperty(MOTIVE, motive);
	}

	public List<Txbuildapply> findByIncomeyear1(Object incomeyear1) {
		return findByProperty(INCOMEYEAR1, incomeyear1);
	}

	public List<Txbuildapply> findByIncomeyear2(Object incomeyear2) {
		return findByProperty(INCOMEYEAR2, incomeyear2);
	}

	public List<Txbuildapply> findByIncomeyear3(Object incomeyear3) {
		return findByProperty(INCOMEYEAR3, incomeyear3);
	}

	public List<Txbuildapply> findByIncomeyear4(Object incomeyear4) {
		return findByProperty(INCOMEYEAR4, incomeyear4);
	}

	public List<Txbuildapply> findByIncomeyear5(Object incomeyear5) {
		return findByProperty(INCOMEYEAR5, incomeyear5);
	}

	public List<Txbuildapply> findByIncomeyear6(Object incomeyear6) {
		return findByProperty(INCOMEYEAR6, incomeyear6);
	}

	public List<Txbuildapply> findByIncomeyear7(Object incomeyear7) {
		return findByProperty(INCOMEYEAR7, incomeyear7);
	}

	public List<Txbuildapply> findByCostyear1(Object costyear1) {
		return findByProperty(COSTYEAR1, costyear1);
	}

	public List<Txbuildapply> findByCostyear2(Object costyear2) {
		return findByProperty(COSTYEAR2, costyear2);
	}

	public List<Txbuildapply> findByCostyear3(Object costyear3) {
		return findByProperty(COSTYEAR3, costyear3);
	}

	public List<Txbuildapply> findByCostyear4(Object costyear4) {
		return findByProperty(COSTYEAR4, costyear4);
	}

	public List<Txbuildapply> findByCostyear5(Object costyear5) {
		return findByProperty(COSTYEAR5, costyear5);
	}

	public List<Txbuildapply> findByCostyear6(Object costyear6) {
		return findByProperty(COSTYEAR6, costyear6);
	}

	public List<Txbuildapply> findByCostyear7(Object costyear7) {
		return findByProperty(COSTYEAR7, costyear7);
	}

	public List<Txbuildapply> findByIrr(Object irr) {
		return findByProperty(IRR, irr);
	}

	public List<Txbuildapply> findByNpv(Object npv) {
		return findByProperty(NPV, npv);
	}

	public List<Txbuildapply> findByCallbackterm(Object callbackterm) {
		return findByProperty(CALLBACKTERM, callbackterm);
	}

	public List<Txbuildapply> findByResult(Object result) {
		return findByProperty(RESULT, result);
	}

	public List<Txbuildapply> findByProjmanager(Object projmanager) {
		return findByProperty(PROJMANAGER, projmanager);
	}

	public List<Txbuildapply> findByAgeneralm(Object ageneralm) {
		return findByProperty(AGENERALM, ageneralm);
	}

	public List<Txbuildapply> findByIntfperson(Object intfperson) {
		return findByProperty(INTFPERSON, intfperson);
	}

	public List<Txbuildapply> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Txbuildapply> findByJudged(Object judged) {
		return findByProperty(JUDGED, judged);
	}

	public List<Txbuildapply> findByLayoutcode(Object layoutcode) {
		return findByProperty(LAYOUTCODE, layoutcode);
	}

	public List<Txbuildapply> findByInvestattri(Object investattri) {
		return findByProperty(INVESTATTRI, investattri);
	}

	public List<Txbuildapply> findBySplitstate(Object splitstate) {
		return findByProperty(SPLITSTATE, splitstate);
	}

	public List<Txbuildapply> findByCustprojtype(Object custprojtype) {
		return findByProperty(CUSTPROJTYPE, custprojtype);
	}

	public List<Txbuildapply> findByIsfeasible(Object isfeasible) {
		return findByProperty(ISFEASIBLE, isfeasible);
	}

	public List<Txbuildapply> findByIsodd(Object isodd) {
		return findByProperty(ISODD, isodd);
	}

	public List<Txbuildapply> findByIscust(Object iscust) {
		return findByProperty(ISCUST, iscust);
	}

	public List<Txbuildapply> findByConstructprop(Object constructprop) {
		return findByProperty(CONSTRUCTPROP, constructprop);
	}

	public List<Txbuildapply> findByIsprovproj(Object isprovproj) {
		return findByProperty(ISPROVPROJ, isprovproj);
	}

	public List<Txbuildapply> findByInvestsort(Object investsort) {
		return findByProperty(INVESTSORT, investsort);
	}

	public List<Txbuildapply> findByIsmovealert(Object ismovealert) {
		return findByProperty(ISMOVEALERT, ismovealert);
	}

	public List<Txbuildapply> findByParaspecs(Object paraspecs) {
		return findByProperty(PARASPECS, paraspecs);
	}

	public List<Txbuildapply> findByIsneedsplit(Object isneedsplit) {
		return findByProperty(ISNEEDSPLIT, isneedsplit);
	}

	public List<Txbuildapply> findByApplyperson(Object applyperson) {
		return findByProperty(APPLYPERSON, applyperson);
	}

	public List<Txbuildapply> findByReply(Object reply) {
		return findByProperty(REPLY, reply);
	}

	public List findAll() {
		log.debug("finding all Txbuildapply instances");
		try {
			String queryString = "from Txbuildapply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Txbuildapply merge(Txbuildapply detachedInstance) {
		log.debug("merging Txbuildapply instance");
		try {
			Txbuildapply result = (Txbuildapply) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Txbuildapply instance) {
		log.debug("attaching dirty Txbuildapply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Txbuildapply instance) {
		log.debug("attaching clean Txbuildapply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}