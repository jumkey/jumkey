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
 * Txfeasirecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXFEASIRECORD", schema = "JUMKEY")
public class Txfeasirecord implements java.io.Serializable {

	// Fields

	private String feasiyrecordid;
	private String projectid;
	private Date reportdate;
	private Double reportmoney;
	private Long projrange;
	private Long state;
	private Long creatorid;
	private Date creatordate;
	private String content;
	private Set<Txfagreearea> txfagreeareas = new HashSet<Txfagreearea>(0);
	private Set<Txfeasijudge> txfeasijudges = new HashSet<Txfeasijudge>(0);
	private Set<Txfaprovince> txfaprovinces = new HashSet<Txfaprovince>(0);

	// Constructors

	/** default constructor */
	public Txfeasirecord() {
	}

	/** full constructor */
	public Txfeasirecord(String projectid, Date reportdate, Double reportmoney, Long projrange, Long state, Long creatorid, Date creatordate, String content, Set<Txfagreearea> txfagreeareas, Set<Txfeasijudge> txfeasijudges, Set<Txfaprovince> txfaprovinces) {
		this.projectid = projectid;
		this.reportdate = reportdate;
		this.reportmoney = reportmoney;
		this.projrange = projrange;
		this.state = state;
		this.creatorid = creatorid;
		this.creatordate = creatordate;
		this.content = content;
		this.txfagreeareas = txfagreeareas;
		this.txfeasijudges = txfeasijudges;
		this.txfaprovinces = txfaprovinces;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "FEASIYRECORDID", unique = true, nullable = false, length = 32)
	public String getFeasiyrecordid() {
		return this.feasiyrecordid;
	}

	public void setFeasiyrecordid(String feasiyrecordid) {
		this.feasiyrecordid = feasiyrecordid;
	}

	@Column(name = "PROJECTID", length = 32)
	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORTDATE", length = 7)
	public Date getReportdate() {
		return this.reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}

	@Column(name = "REPORTMONEY", precision = 14)
	public Double getReportmoney() {
		return this.reportmoney;
	}

	public void setReportmoney(Double reportmoney) {
		this.reportmoney = reportmoney;
	}

	@Column(name = "PROJRANGE", precision = 1, scale = 0)
	public Long getProjrange() {
		return this.projrange;
	}

	public void setProjrange(Long projrange) {
		this.projrange = projrange;
	}

	@Column(name = "STATE", precision = 1, scale = 0)
	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	@Column(name = "CREATORID", precision = 20, scale = 0)
	public Long getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATORDATE", length = 7)
	public Date getCreatordate() {
		return this.creatordate;
	}

	public void setCreatordate(Date creatordate) {
		this.creatordate = creatordate;
	}

	@Column(name = "CONTENT", length = 511)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txfeasirecord")
	public Set<Txfagreearea> getTxfagreeareas() {
		return this.txfagreeareas;
	}

	public void setTxfagreeareas(Set<Txfagreearea> txfagreeareas) {
		this.txfagreeareas = txfagreeareas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txfeasirecord")
	public Set<Txfeasijudge> getTxfeasijudges() {
		return this.txfeasijudges;
	}

	public void setTxfeasijudges(Set<Txfeasijudge> txfeasijudges) {
		this.txfeasijudges = txfeasijudges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "txfeasirecord")
	public Set<Txfaprovince> getTxfaprovinces() {
		return this.txfaprovinces;
	}

	public void setTxfaprovinces(Set<Txfaprovince> txfaprovinces) {
		this.txfaprovinces = txfaprovinces;
	}

}