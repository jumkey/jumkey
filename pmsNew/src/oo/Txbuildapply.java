package org.cafeboy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Txbuildapply entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBUILDAPPLY", schema = "JUMKEY")
public class Txbuildapply implements java.io.Serializable {

	// Fields

	private String buildapplyid;
	private Long year;
	private String name;
	private String code;
	private String term;
	private Long applyunit;
	private Long chargeunit;
	private Long constructunit;
	private Long mianbody;
	private Double totalinvest;
	private Double totalmarkinvest;
	private Double totalnotmi;
	private Long investretsort;
	private Long areainvestsort;
	private Date startdate;
	private Date enddate;
	private Long urgencydegree;
	private Long isinbudget;
	private String projcode;
	private String archicode;
	private String motive;
	private Double incomeyear1;
	private Double incomeyear2;
	private Double incomeyear3;
	private Double incomeyear4;
	private Double incomeyear5;
	private Double incomeyear6;
	private Double incomeyear7;
	private Double costyear1;
	private Double costyear2;
	private Double costyear3;
	private Double costyear4;
	private Double costyear5;
	private Double costyear6;
	private Double costyear7;
	private Double irr;
	private Double npv;
	private Long callbackterm;
	private String result;
	private Long projmanager;
	private Long ageneralm;
	private Long intfperson;
	private Long state;
	private Long judged;
	private String layoutcode;
	private Long investattri;
	private Long splitstate;
	private Long custprojtype;
	private Long isfeasible;
	private Long isodd;
	private Long iscust;
	private Long constructprop;
	private Long isprovproj;
	private Date applydate;
	private Long investsort;
	private Long ismovealert;
	private String paraspecs;
	private Long isneedsplit;
	private Long applyperson;
	private Date replydate;
	private String reply;
	private Set<Txproject> txprojects = new HashSet<Txproject>(0);
	private Set<Txclientsplit> txclientsplitsForRelateid = new HashSet<Txclientsplit>(0);
	private Set<Txnotifyplan> txnotifyplans = new HashSet<Txnotifyplan>(0);
	private Set<Txclientsplit> txclientsplitsForBuildapplyid = new HashSet<Txclientsplit>(0);
	private Set<Txbuildsplit> txbuildsplitsForParentid = new HashSet<Txbuildsplit>(0);
	private Set<Txbuildjudge> txbuildjudges = new HashSet<Txbuildjudge>(0);
	private Set<Txbapplyinvest> txbapplyinvests = new HashSet<Txbapplyinvest>(0);
	private Set<Txbuildaudit> txbuildaudits = new HashSet<Txbuildaudit>(0);
	private Set<Txbapplyfc> txbapplyfcs = new HashSet<Txbapplyfc>(0);
	private Set<Txbapplycontent> txbapplycontents = new HashSet<Txbapplycontent>(0);
	private Set<Txbuildsplit> txbuildsplitsForBuildapplyid = new HashSet<Txbuildsplit>(0);

	// Constructors

	/** default constructor */
	public Txbuildapply() {
	}

	/** full constructor */
	public Txbuildapply(Long year, String name, String code, String term, Long applyunit, Long chargeunit, Long constructunit, Long mianbody, Double totalinvest, Double totalmarkinvest, Double totalnotmi, Long investretsort, Long areainvestsort, Date startdate, Date enddate, Long urgencydegree, Long isinbudget, String projcode, String archicode, String motive, Double incomeyear1, Double incomeyear2, Double incomeyear3, Double incomeyear4, Double incomeyear5, Double incomeyear6, Double incomeyear7, Double costyear1, Double costyear2, Double costyear3, Double costyear4, Double costyear5, Double costyear6, Double costyear7, Double irr, Double npv, Long callbackterm, String result, Long projmanager, Long ageneralm, Long intfperson, Long state, Long judged, String layoutcode, Long investattri,
			Long splitstate, Long custprojtype, Long isfeasible, Long isodd, Long iscust, Long constructprop, Long isprovproj, Date applydate, Long investsort, Long ismovealert, String paraspecs, Long isneedsplit, Long applyperson, Date replydate, String reply, Set<Txproject> txprojects, Set<Txclientsplit> txclientsplitsForRelateid, Set<Txnotifyplan> txnotifyplans, Set<Txclientsplit> txclientsplitsForBuildapplyid, Set<Txbuildsplit> txbuildsplitsForParentid, Set<Txbuildjudge> txbuildjudges, Set<Txbapplyinvest> txbapplyinvests, Set<Txbuildaudit> txbuildaudits, Set<Txbapplyfc> txbapplyfcs, Set<Txbapplycontent> txbapplycontents, Set<Txbuildsplit> txbuildsplitsForBuildapplyid) {
		this.year = year;
		this.name = name;
		this.code = code;
		this.term = term;
		this.applyunit = applyunit;
		this.chargeunit = chargeunit;
		this.constructunit = constructunit;
		this.mianbody = mianbody;
		this.totalinvest = totalinvest;
		this.totalmarkinvest = totalmarkinvest;
		this.totalnotmi = totalnotmi;
		this.investretsort = investretsort;
		this.areainvestsort = areainvestsort;
		this.startdate = startdate;
		this.enddate = enddate;
		this.urgencydegree = urgencydegree;
		this.isinbudget = isinbudget;
		this.projcode = projcode;
		this.archicode = archicode;
		this.motive = motive;
		this.incomeyear1 = incomeyear1;
		this.incomeyear2 = incomeyear2;
		this.incomeyear3 = incomeyear3;
		this.incomeyear4 = incomeyear4;
		this.incomeyear5 = incomeyear5;
		this.incomeyear6 = incomeyear6;
		this.incomeyear7 = incomeyear7;
		this.costyear1 = costyear1;
		this.costyear2 = costyear2;
		this.costyear3 = costyear3;
		this.costyear4 = costyear4;
		this.costyear5 = costyear5;
		this.costyear6 = costyear6;
		this.costyear7 = costyear7;
		this.irr = irr;
		this.npv = npv;
		this.callbackterm = callbackterm;
		this.result = result;
		this.projmanager = projmanager;
		this.ageneralm = ageneralm;
		this.intfperson = intfperson;
		this.state = state;
		this.judged = judged;
		this.layoutcode = layoutcode;
		this.investattri = investattri;
		this.splitstate = splitstate;
		this.custprojtype = custprojtype;
		this.isfeasible = isfeasible;
		this.isodd = isodd;
		this.iscust = iscust;
		this.constructprop = constructprop;
		this.isprovproj = isprovproj;
		this.applydate = applydate;
		this.investsort = investsort;
		this.ismovealert = ismovealert;
		this.paraspecs = paraspecs;
		this.isneedsplit = isneedsplit;
		this.applyperson = applyperson;
		this.replydate = replydate;
		this.reply = reply;
		this.txprojects = txprojects;
		this.txclientsplitsForRelateid = txclientsplitsForRelateid;
		this.txnotifyplans = txnotifyplans;
		this.txclientsplitsForBuildapplyid = txclientsplitsForBuildapplyid;
		this.txbuildsplitsForParentid = txbuildsplitsForParentid;
		this.txbuildjudges = txbuildjudges;
		this.txbapplyinvests = txbapplyinvests;
		this.txbuildaudits = txbuildaudits;
		this.txbapplyfcs = txbapplyfcs;
		this.txbapplycontents = txbapplycontents;
		this.txbuildsplitsForBuildapplyid = txbuildsplitsForBuildapplyid;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BUILDAPPLYID", unique = true, nullable = false, length = 32)
	public String getBuildapplyid() {
		return this.buildapplyid;
	}

	public void setBuildapplyid(String buildapplyid) {
		this.buildapplyid = buildapplyid;
	}

	@Column(name = "YEAR", precision = 4, scale = 0)
	public Long getYear() {
		return this.year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CODE", length = 50)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "TERM", length = 4)
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Column(name = "APPLYUNIT", precision = 20, scale = 0)
	public Long getApplyunit() {
		return this.applyunit;
	}

	public void setApplyunit(Long applyunit) {
		this.applyunit = applyunit;
	}

	@Column(name = "CHARGEUNIT", precision = 1, scale = 0)
	public Long getChargeunit() {
		return this.chargeunit;
	}

	public void setChargeunit(Long chargeunit) {
		this.chargeunit = chargeunit;
	}

	@Column(name = "CONSTRUCTUNIT", precision = 20, scale = 0)
	public Long getConstructunit() {
		return this.constructunit;
	}

	public void setConstructunit(Long constructunit) {
		this.constructunit = constructunit;
	}

	@Column(name = "MIANBODY", precision = 1, scale = 0)
	public Long getMianbody() {
		return this.mianbody;
	}

	public void setMianbody(Long mianbody) {
		this.mianbody = mianbody;
	}

	@Column(name = "TOTALINVEST", precision = 14)
	public Double getTotalinvest() {
		return this.totalinvest;
	}

	public void setTotalinvest(Double totalinvest) {
		this.totalinvest = totalinvest;
	}

	@Column(name = "TOTALMARKINVEST", precision = 14)
	public Double getTotalmarkinvest() {
		return this.totalmarkinvest;
	}

	public void setTotalmarkinvest(Double totalmarkinvest) {
		this.totalmarkinvest = totalmarkinvest;
	}

	@Column(name = "TOTALNOTMI", precision = 14)
	public Double getTotalnotmi() {
		return this.totalnotmi;
	}

	public void setTotalnotmi(Double totalnotmi) {
		this.totalnotmi = totalnotmi;
	}

	@Column(name = "INVESTRETSORT", precision = 1, scale = 0)
	public Long getInvestretsort() {
		return this.investretsort;
	}

	public void setInvestretsort(Long investretsort) {
		this.investretsort = investretsort;
	}

	@Column(name = "AREAINVESTSORT", precision = 1, scale = 0)
	public Long getAreainvestsort() {
		return this.areainvestsort;
	}

	public void setAreainvestsort(Long areainvestsort) {
		this.areainvestsort = areainvestsort;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "URGENCYDEGREE", precision = 1, scale = 0)
	public Long getUrgencydegree() {
		return this.urgencydegree;
	}

	public void setUrgencydegree(Long urgencydegree) {
		this.urgencydegree = urgencydegree;
	}

	@Column(name = "ISINBUDGET", precision = 1, scale = 0)
	public Long getIsinbudget() {
		return this.isinbudget;
	}

	public void setIsinbudget(Long isinbudget) {
		this.isinbudget = isinbudget;
	}

	@Column(name = "PROJCODE", length = 50)
	public String getProjcode() {
		return this.projcode;
	}

	public void setProjcode(String projcode) {
		this.projcode = projcode;
	}

	@Column(name = "ARCHICODE", length = 50)
	public String getArchicode() {
		return this.archicode;
	}

	public void setArchicode(String archicode) {
		this.archicode = archicode;
	}

	@Column(name = "MOTIVE", length = 500)
	public String getMotive() {
		return this.motive;
	}

	public void setMotive(String motive) {
		this.motive = motive;
	}

	@Column(name = "INCOMEYEAR1", precision = 14)
	public Double getIncomeyear1() {
		return this.incomeyear1;
	}

	public void setIncomeyear1(Double incomeyear1) {
		this.incomeyear1 = incomeyear1;
	}

	@Column(name = "INCOMEYEAR2", precision = 14)
	public Double getIncomeyear2() {
		return this.incomeyear2;
	}

	public void setIncomeyear2(Double incomeyear2) {
		this.incomeyear2 = incomeyear2;
	}

	@Column(name = "INCOMEYEAR3", precision = 14)
	public Double getIncomeyear3() {
		return this.incomeyear3;
	}

	public void setIncomeyear3(Double incomeyear3) {
		this.incomeyear3 = incomeyear3;
	}

	@Column(name = "INCOMEYEAR4", precision = 14)
	public Double getIncomeyear4() {
		return this.incomeyear4;
	}

	public void setIncomeyear4(Double incomeyear4) {
		this.incomeyear4 = incomeyear4;
	}

	@Column(name = "INCOMEYEAR5", precision = 14)
	public Double getIncomeyear5() {
		return this.incomeyear5;
	}

	public void setIncomeyear5(Double incomeyear5) {
		this.incomeyear5 = incomeyear5;
	}

	@Column(name = "INCOMEYEAR6", precision = 14)
	public Double getIncomeyear6() {
		return this.incomeyear6;
	}

	public void setIncomeyear6(Double incomeyear6) {
		this.incomeyear6 = incomeyear6;
	}

	@Column(name = "INCOMEYEAR7", precision = 14)
	public Double getIncomeyear7() {
		return this.incomeyear7;
	}

	public void setIncomeyear7(Double incomeyear7) {
		this.incomeyear7 = incomeyear7;
	}

	@Column(name = "COSTYEAR1", precision = 14)
	public Double getCostyear1() {
		return this.costyear1;
	}

	public void setCostyear1(Double costyear1) {
		this.costyear1 = costyear1;
	}

	@Column(name = "COSTYEAR2", precision = 14)
	public Double getCostyear2() {
		return this.costyear2;
	}

	public void setCostyear2(Double costyear2) {
		this.costyear2 = costyear2;
	}

	@Column(name = "COSTYEAR3", precision = 14)
	public Double getCostyear3() {
		return this.costyear3;
	}

	public void setCostyear3(Double costyear3) {
		this.costyear3 = costyear3;
	}

	@Column(name = "COSTYEAR4", precision = 14)
	public Double getCostyear4() {
		return this.costyear4;
	}

	public void setCostyear4(Double costyear4) {
		this.costyear4 = costyear4;
	}

	@Column(name = "COSTYEAR5", precision = 14)
	public Double getCostyear5() {
		return this.costyear5;
	}

	public void setCostyear5(Double costyear5) {
		this.costyear5 = costyear5;
	}

	@Column(name = "COSTYEAR6", precision = 14)
	public Double getCostyear6() {
		return this.costyear6;
	}

	public void setCostyear6(Double costyear6) {
		this.costyear6 = costyear6;
	}

	@Column(name = "COSTYEAR7", precision = 14)
	public Double getCostyear7() {
		return this.costyear7;
	}

	public void setCostyear7(Double costyear7) {
		this.costyear7 = costyear7;
	}

	@Column(name = "IRR", precision = 5)
	public Double getIrr() {
		return this.irr;
	}

	public void setIrr(Double irr) {
		this.irr = irr;
	}

	@Column(name = "NPV", precision = 5)
	public Double getNpv() {
		return this.npv;
	}

	public void setNpv(Double npv) {
		this.npv = npv;
	}

	@Column(name = "CALLBACKTERM", precision = 5, scale = 0)
	public Long getCallbackterm() {
		return this.callbackterm;
	}

	public void setCallbackterm(Long callbackterm) {
		this.callbackterm = callbackterm;
	}

	@Column(name = "RESULT", length = 500)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "PROJMANAGER", precision = 20, scale = 0)
	public Long getProjmanager() {
		return this.projmanager;
	}

	public void setProjmanager(Long projmanager) {
		this.projmanager = projmanager;
	}

	@Column(name = "AGENERALM", precision = 20, scale = 0)
	public Long getAgeneralm() {
		return this.ageneralm;
	}

	public void setAgeneralm(Long ageneralm) {
		this.ageneralm = ageneralm;
	}

	@Column(name = "INTFPERSON", precision = 20, scale = 0)
	public Long getIntfperson() {
		return this.intfperson;
	}

	public void setIntfperson(Long intfperson) {
		this.intfperson = intfperson;
	}

	@Column(name = "STATE", precision = 1, scale = 0)
	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	@Column(name = "JUDGED", precision = 1, scale = 0)
	public Long getJudged() {
		return this.judged;
	}

	public void setJudged(Long judged) {
		this.judged = judged;
	}

	@Column(name = "LAYOUTCODE", length = 50)
	public String getLayoutcode() {
		return this.layoutcode;
	}

	public void setLayoutcode(String layoutcode) {
		this.layoutcode = layoutcode;
	}

	@Column(name = "INVESTATTRI", precision = 1, scale = 0)
	public Long getInvestattri() {
		return this.investattri;
	}

	public void setInvestattri(Long investattri) {
		this.investattri = investattri;
	}

	@Column(name = "SPLITSTATE", precision = 1, scale = 0)
	public Long getSplitstate() {
		return this.splitstate;
	}

	public void setSplitstate(Long splitstate) {
		this.splitstate = splitstate;
	}

	@Column(name = "CUSTPROJTYPE", precision = 1, scale = 0)
	public Long getCustprojtype() {
		return this.custprojtype;
	}

	public void setCustprojtype(Long custprojtype) {
		this.custprojtype = custprojtype;
	}

	@Column(name = "ISFEASIBLE", precision = 1, scale = 0)
	public Long getIsfeasible() {
		return this.isfeasible;
	}

	public void setIsfeasible(Long isfeasible) {
		this.isfeasible = isfeasible;
	}

	@Column(name = "ISODD", precision = 1, scale = 0)
	public Long getIsodd() {
		return this.isodd;
	}

	public void setIsodd(Long isodd) {
		this.isodd = isodd;
	}

	@Column(name = "ISCUST", precision = 1, scale = 0)
	public Long getIscust() {
		return this.iscust;
	}

	public void setIscust(Long iscust) {
		this.iscust = iscust;
	}

	@Column(name = "CONSTRUCTPROP", precision = 1, scale = 0)
	public Long getConstructprop() {
		return this.constructprop;
	}

	public void setConstructprop(Long constructprop) {
		this.constructprop = constructprop;
	}

	@Column(name = "ISPROVPROJ", precision = 1, scale = 0)
	public Long getIsprovproj() {
		return this.isprovproj;
	}

	public void setIsprovproj(Long isprovproj) {
		this.isprovproj = isprovproj;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "APPLYDATE", length = 7)
	public Date getApplydate() {
		return this.applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	@Column(name = "INVESTSORT", precision = 1, scale = 0)
	public Long getInvestsort() {
		return this.investsort;
	}

	public void setInvestsort(Long investsort) {
		this.investsort = investsort;
	}

	@Column(name = "ISMOVEALERT", precision = 1, scale = 0)
	public Long getIsmovealert() {
		return this.ismovealert;
	}

	public void setIsmovealert(Long ismovealert) {
		this.ismovealert = ismovealert;
	}

	@Column(name = "PARASPECS", length = 30)
	public String getParaspecs() {
		return this.paraspecs;
	}

	public void setParaspecs(String paraspecs) {
		this.paraspecs = paraspecs;
	}

	@Column(name = "ISNEEDSPLIT", precision = 1, scale = 0)
	public Long getIsneedsplit() {
		return this.isneedsplit;
	}

	public void setIsneedsplit(Long isneedsplit) {
		this.isneedsplit = isneedsplit;
	}

	@Column(name = "APPLYPERSON", precision = 20, scale = 0)
	public Long getApplyperson() {
		return this.applyperson;
	}

	public void setApplyperson(Long applyperson) {
		this.applyperson = applyperson;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REPLYDATE", length = 7)
	public Date getReplydate() {
		return this.replydate;
	}

	public void setReplydate(Date replydate) {
		this.replydate = replydate;
	}

	@Column(name = "REPLY", length = 1023)
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txproject> getTxprojects() {
		return this.txprojects;
	}

	public void setTxprojects(Set<Txproject> txprojects) {
		this.txprojects = txprojects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapplyByRelateid")
	public Set<Txclientsplit> getTxclientsplitsForRelateid() {
		return this.txclientsplitsForRelateid;
	}

	public void setTxclientsplitsForRelateid(Set<Txclientsplit> txclientsplitsForRelateid) {
		this.txclientsplitsForRelateid = txclientsplitsForRelateid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txnotifyplan> getTxnotifyplans() {
		return this.txnotifyplans;
	}

	public void setTxnotifyplans(Set<Txnotifyplan> txnotifyplans) {
		this.txnotifyplans = txnotifyplans;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapplyByBuildapplyid")
	public Set<Txclientsplit> getTxclientsplitsForBuildapplyid() {
		return this.txclientsplitsForBuildapplyid;
	}

	public void setTxclientsplitsForBuildapplyid(Set<Txclientsplit> txclientsplitsForBuildapplyid) {
		this.txclientsplitsForBuildapplyid = txclientsplitsForBuildapplyid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapplyByParentid")
	public Set<Txbuildsplit> getTxbuildsplitsForParentid() {
		return this.txbuildsplitsForParentid;
	}

	public void setTxbuildsplitsForParentid(Set<Txbuildsplit> txbuildsplitsForParentid) {
		this.txbuildsplitsForParentid = txbuildsplitsForParentid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txbuildjudge> getTxbuildjudges() {
		return this.txbuildjudges;
	}

	public void setTxbuildjudges(Set<Txbuildjudge> txbuildjudges) {
		this.txbuildjudges = txbuildjudges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txbapplyinvest> getTxbapplyinvests() {
		return this.txbapplyinvests;
	}

	public void setTxbapplyinvests(Set<Txbapplyinvest> txbapplyinvests) {
		this.txbapplyinvests = txbapplyinvests;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txbuildaudit> getTxbuildaudits() {
		return this.txbuildaudits;
	}

	public void setTxbuildaudits(Set<Txbuildaudit> txbuildaudits) {
		this.txbuildaudits = txbuildaudits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txbapplyfc> getTxbapplyfcs() {
		return this.txbapplyfcs;
	}

	public void setTxbapplyfcs(Set<Txbapplyfc> txbapplyfcs) {
		this.txbapplyfcs = txbapplyfcs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapply")
	public Set<Txbapplycontent> getTxbapplycontents() {
		return this.txbapplycontents;
	}

	public void setTxbapplycontents(Set<Txbapplycontent> txbapplycontents) {
		this.txbapplycontents = txbapplycontents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txbuildapplyByBuildapplyid")
	public Set<Txbuildsplit> getTxbuildsplitsForBuildapplyid() {
		return this.txbuildsplitsForBuildapplyid;
	}

	public void setTxbuildsplitsForBuildapplyid(Set<Txbuildsplit> txbuildsplitsForBuildapplyid) {
		this.txbuildsplitsForBuildapplyid = txbuildsplitsForBuildapplyid;
	}

}