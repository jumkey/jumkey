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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Txproject entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPROJECT", schema = "JUMKEY")
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
	@Id
	@GeneratedValue
	@Column(name = "PROJECTID", unique = true, nullable = false, length = 32)
	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID")
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "PROJNAME", length = 50)
	public String getProjname() {
		return this.projname;
	}

	public void setProjname(String projname) {
		this.projname = projname;
	}

	@Column(name = "PROJCODE", length = 30)
	public String getProjcode() {
		return this.projcode;
	}

	public void setProjcode(String projcode) {
		this.projcode = projcode;
	}

	@Column(name = "PROJINVEST", precision = 14)
	public Double getProjinvest() {
		return this.projinvest;
	}

	public void setProjinvest(Double projinvest) {
		this.projinvest = projinvest;
	}

	@Column(name = "CONSTRUCTUNIT", precision = 20, scale = 0)
	public Long getConstructunit() {
		return this.constructunit;
	}

	public void setConstructunit(Long constructunit) {
		this.constructunit = constructunit;
	}

	@Column(name = "BUILDPROPERTY", precision = 1, scale = 0)
	public Long getBuildproperty() {
		return this.buildproperty;
	}

	public void setBuildproperty(Long buildproperty) {
		this.buildproperty = buildproperty;
	}

	@Column(name = "PRINCIPAL", precision = 20, scale = 0)
	public Long getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Long principal) {
		this.principal = principal;
	}

	@Column(name = "TERM", length = 4)
	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
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

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "STATE", precision = 1, scale = 0)
	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	@Column(name = "URGENCYDEGREE", precision = 1, scale = 0)
	public Long getUrgencydegree() {
		return this.urgencydegree;
	}

	public void setUrgencydegree(Long urgencydegree) {
		this.urgencydegree = urgencydegree;
	}

	@Column(name = "APPLYUNIT", precision = 20, scale = 0)
	public Long getApplyunit() {
		return this.applyunit;
	}

	public void setApplyunit(Long applyunit) {
		this.applyunit = applyunit;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txproject")
	public Set<Txprojchanging> getTxprojchangings() {
		return this.txprojchangings;
	}

	public void setTxprojchangings(Set<Txprojchanging> txprojchangings) {
		this.txprojchangings = txprojchangings;
	}

}