package org.cafeboy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Txproject entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txproject implements java.io.Serializable {

	// Fields

	private String projectid;
	private Txbuildapply txbuildapply;
	private String projname;
	private String projcode;
	private Double projinvest;
	private Long constructunit;
	private Long buildproperty;
	private Long principal;
	private String term;
	private Date startdate;
	private Date enddate;
	private String content;
	private Long state;
	private Long urgencydegree;
	private Long applyunit;
	private Set<Txprojchanging> txprojchangings = new HashSet<Txprojchanging>(0);

	// Constructors

	/** default constructor */
	public Txproject() {
	}

	/** full constructor */
	public Txproject(Txbuildapply txbuildapply, String projname, String projcode, Double projinvest, Long constructunit, Long buildproperty, Long principal, String term, Date startdate, Date enddate, String content, Long state, Long urgencydegree, Long applyunit, Set<Txprojchanging> txprojchangings) {
		this.txbuildapply = txbuildapply;
		this.projname = projname;
		this.projcode = projcode;
		this.projinvest = projinvest;
		this.constructunit = constructunit;
		this.buildproperty = buildproperty;
		this.principal = principal;
		this.term = term;
		this.startdate = startdate;
		this.enddate = enddate;
		this.content = content;
		this.state = state;
		this.urgencydegree = urgencydegree;
		this.applyunit = applyunit;
		this.txprojchangings = txprojchangings;
	}

	// Property accessors

	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public String getProjname() {
		return this.projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	public String getProjcode() {
		return this.projcode;
	}

	public void setProjcode(String projcode) {
		this.projcode = projcode;
	}

	public Double getProjinvest() {
		return this.projinvest;
	}

	public void setProjinvest(Double projinvest) {
		this.projinvest = projinvest;
	}

	public Long getConstructunit() {
		return this.constructunit;
	}

	public void setConstructunit(Long constructunit) {
		this.constructunit = constructunit;
	}

	public Long getBuildproperty() {
		return this.buildproperty;
	}

	public void setBuildproperty(Long buildproperty) {
		this.buildproperty = buildproperty;
	}

	public Long getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Long principal) {
		this.principal = principal;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getUrgencydegree() {
		return this.urgencydegree;
	}

	public void setUrgencydegree(Long urgencydegree) {
		this.urgencydegree = urgencydegree;
	}

	public Long getApplyunit() {
		return this.applyunit;
	}

	public void setApplyunit(Long applyunit) {
		this.applyunit = applyunit;
	}

	public Set<Txprojchanging> getTxprojchangings() {
		return this.txprojchangings;
	}

	public void setTxprojchangings(Set<Txprojchanging> txprojchangings) {
		this.txprojchangings = txprojchangings;
	}

}