package org.cafeboy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Txfeasirecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getFeasiyrecordid() {
		return this.feasiyrecordid;
	}

	public void setFeasiyrecordid(String feasiyrecordid) {
		this.feasiyrecordid = feasiyrecordid;
	}

	public String getProjectid() {
		return this.projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public Date getReportdate() {
		return this.reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}

	public Double getReportmoney() {
		return this.reportmoney;
	}

	public void setReportmoney(Double reportmoney) {
		this.reportmoney = reportmoney;
	}

	public Long getProjrange() {
		return this.projrange;
	}

	public void setProjrange(Long projrange) {
		this.projrange = projrange;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatordate() {
		return this.creatordate;
	}

	public void setCreatordate(Date creatordate) {
		this.creatordate = creatordate;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<Txfagreearea> getTxfagreeareas() {
		return this.txfagreeareas;
	}

	public void setTxfagreeareas(Set<Txfagreearea> txfagreeareas) {
		this.txfagreeareas = txfagreeareas;
	}

	public Set<Txfeasijudge> getTxfeasijudges() {
		return this.txfeasijudges;
	}

	public void setTxfeasijudges(Set<Txfeasijudge> txfeasijudges) {
		this.txfeasijudges = txfeasijudges;
	}

	public Set<Txfaprovince> getTxfaprovinces() {
		return this.txfaprovinces;
	}

	public void setTxfaprovinces(Set<Txfaprovince> txfaprovinces) {
		this.txfaprovinces = txfaprovinces;
	}

}