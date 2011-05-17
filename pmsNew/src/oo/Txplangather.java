package org.cafeboy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Txplangather entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPLANGATHER", schema = "JUMKEY")
public class Txplangather implements java.io.Serializable {

	// Fields

	private String plangatherid;
	private Msspec msspec;
	private Txplaninfo txplaninfo;
	private Double continuetotal;
	private Double continshed;
	private Double newtotal;
	private Double expendjan;
	private Double expendfeb;
	private Double expendmar;
	private Double expendapr;
	private Double expendmay;
	private Double expendjun;
	private Double expendjul;
	private Double expendaug;
	private Double expendsep;
	private Double expendoct;
	private Double expendnov;
	private Double expenddec;

	// Constructors

	/** default constructor */
	public Txplangather() {
	}

	/** full constructor */
	public Txplangather(Msspec msspec, Txplaninfo txplaninfo, Double continuetotal, Double continshed, Double newtotal, Double expendjan, Double expendfeb, Double expendmar, Double expendapr, Double expendmay, Double expendjun, Double expendjul, Double expendaug, Double expendsep, Double expendoct, Double expendnov, Double expenddec) {
		this.msspec = msspec;
		this.txplaninfo = txplaninfo;
		this.continuetotal = continuetotal;
		this.continshed = continshed;
		this.newtotal = newtotal;
		this.expendjan = expendjan;
		this.expendfeb = expendfeb;
		this.expendmar = expendmar;
		this.expendapr = expendapr;
		this.expendmay = expendmay;
		this.expendjun = expendjun;
		this.expendjul = expendjul;
		this.expendaug = expendaug;
		this.expendsep = expendsep;
		this.expendoct = expendoct;
		this.expendnov = expendnov;
		this.expenddec = expenddec;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PLANGATHERID", unique = true, nullable = false, length = 32)
	public String getPlangatherid() {
		return this.plangatherid;
	}

	public void setPlangatherid(String plangatherid) {
		this.plangatherid = plangatherid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPECID")
	public Msspec getMsspec() {
		return this.msspec;
	}

	public void setMsspec(Msspec msspec) {
		this.msspec = msspec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BASICINFOID")
	public Txplaninfo getTxplaninfo() {
		return this.txplaninfo;
	}

	public void setTxplaninfo(Txplaninfo txplaninfo) {
		this.txplaninfo = txplaninfo;
	}

	@Column(name = "CONTINUETOTAL", precision = 14)
	public Double getContinuetotal() {
		return this.continuetotal;
	}

	public void setContinuetotal(Double continuetotal) {
		this.continuetotal = continuetotal;
	}

	@Column(name = "CONTINSHED", precision = 14)
	public Double getContinshed() {
		return this.continshed;
	}

	public void setContinshed(Double continshed) {
		this.continshed = continshed;
	}

	@Column(name = "NEWTOTAL", precision = 14)
	public Double getNewtotal() {
		return this.newtotal;
	}

	public void setNewtotal(Double newtotal) {
		this.newtotal = newtotal;
	}

	@Column(name = "EXPENDJAN", precision = 14)
	public Double getExpendjan() {
		return this.expendjan;
	}

	public void setExpendjan(Double expendjan) {
		this.expendjan = expendjan;
	}

	@Column(name = "EXPENDFEB", precision = 14)
	public Double getExpendfeb() {
		return this.expendfeb;
	}

	public void setExpendfeb(Double expendfeb) {
		this.expendfeb = expendfeb;
	}

	@Column(name = "EXPENDMAR", precision = 14)
	public Double getExpendmar() {
		return this.expendmar;
	}

	public void setExpendmar(Double expendmar) {
		this.expendmar = expendmar;
	}

	@Column(name = "EXPENDAPR", precision = 14)
	public Double getExpendapr() {
		return this.expendapr;
	}

	public void setExpendapr(Double expendapr) {
		this.expendapr = expendapr;
	}

	@Column(name = "EXPENDMAY", precision = 14)
	public Double getExpendmay() {
		return this.expendmay;
	}

	public void setExpendmay(Double expendmay) {
		this.expendmay = expendmay;
	}

	@Column(name = "EXPENDJUN", precision = 14)
	public Double getExpendjun() {
		return this.expendjun;
	}

	public void setExpendjun(Double expendjun) {
		this.expendjun = expendjun;
	}

	@Column(name = "EXPENDJUL", precision = 14)
	public Double getExpendjul() {
		return this.expendjul;
	}

	public void setExpendjul(Double expendjul) {
		this.expendjul = expendjul;
	}

	@Column(name = "EXPENDAUG", precision = 14)
	public Double getExpendaug() {
		return this.expendaug;
	}

	public void setExpendaug(Double expendaug) {
		this.expendaug = expendaug;
	}

	@Column(name = "EXPENDSEP", precision = 14)
	public Double getExpendsep() {
		return this.expendsep;
	}

	public void setExpendsep(Double expendsep) {
		this.expendsep = expendsep;
	}

	@Column(name = "EXPENDOCT", precision = 14)
	public Double getExpendoct() {
		return this.expendoct;
	}

	public void setExpendoct(Double expendoct) {
		this.expendoct = expendoct;
	}

	@Column(name = "EXPENDNOV", precision = 14)
	public Double getExpendnov() {
		return this.expendnov;
	}

	public void setExpendnov(Double expendnov) {
		this.expendnov = expendnov;
	}

	@Column(name = "EXPENDDEC", precision = 14)
	public Double getExpenddec() {
		return this.expenddec;
	}

	public void setExpenddec(Double expenddec) {
		this.expenddec = expenddec;
	}

}