package org.cafeboy.model;

/**
 * Txplangedition entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txplangedition implements java.io.Serializable {

	// Fields

	private String pgathereid;
	private Msspec msspec;
	private Txplaninfo txplaninfo;
	private Long edno;
	private Double continuetotal;
	private Double contiished;
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
	public Txplangedition() {
	}

	/** full constructor */
	public Txplangedition(Msspec msspec, Txplaninfo txplaninfo, Long edno, Double continuetotal, Double contiished, Double newtotal, Double expendjan, Double expendfeb, Double expendmar, Double expendapr, Double expendmay, Double expendjun, Double expendjul, Double expendaug, Double expendsep, Double expendoct, Double expendnov, Double expenddec) {
		this.msspec = msspec;
		this.txplaninfo = txplaninfo;
		this.edno = edno;
		this.continuetotal = continuetotal;
		this.contiished = contiished;
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

	public String getPgathereid() {
		return this.pgathereid;
	}

	public void setPgathereid(String pgathereid) {
		this.pgathereid = pgathereid;
	}

	public Msspec getMsspec() {
		return this.msspec;
	}

	public void setMsspec(Msspec msspec) {
		this.msspec = msspec;
	}

	public Txplaninfo getTxplaninfo() {
		return this.txplaninfo;
	}

	public void setTxplaninfo(Txplaninfo txplaninfo) {
		this.txplaninfo = txplaninfo;
	}

	public Long getEdno() {
		return this.edno;
	}

	public void setEdno(Long edno) {
		this.edno = edno;
	}

	public Double getContinuetotal() {
		return this.continuetotal;
	}

	public void setContinuetotal(Double continuetotal) {
		this.continuetotal = continuetotal;
	}

	public Double getContiished() {
		return this.contiished;
	}

	public void setContiished(Double contiished) {
		this.contiished = contiished;
	}

	public Double getNewtotal() {
		return this.newtotal;
	}

	public void setNewtotal(Double newtotal) {
		this.newtotal = newtotal;
	}

	public Double getExpendjan() {
		return this.expendjan;
	}

	public void setExpendjan(Double expendjan) {
		this.expendjan = expendjan;
	}

	public Double getExpendfeb() {
		return this.expendfeb;
	}

	public void setExpendfeb(Double expendfeb) {
		this.expendfeb = expendfeb;
	}

	public Double getExpendmar() {
		return this.expendmar;
	}

	public void setExpendmar(Double expendmar) {
		this.expendmar = expendmar;
	}

	public Double getExpendapr() {
		return this.expendapr;
	}

	public void setExpendapr(Double expendapr) {
		this.expendapr = expendapr;
	}

	public Double getExpendmay() {
		return this.expendmay;
	}

	public void setExpendmay(Double expendmay) {
		this.expendmay = expendmay;
	}

	public Double getExpendjun() {
		return this.expendjun;
	}

	public void setExpendjun(Double expendjun) {
		this.expendjun = expendjun;
	}

	public Double getExpendjul() {
		return this.expendjul;
	}

	public void setExpendjul(Double expendjul) {
		this.expendjul = expendjul;
	}

	public Double getExpendaug() {
		return this.expendaug;
	}

	public void setExpendaug(Double expendaug) {
		this.expendaug = expendaug;
	}

	public Double getExpendsep() {
		return this.expendsep;
	}

	public void setExpendsep(Double expendsep) {
		this.expendsep = expendsep;
	}

	public Double getExpendoct() {
		return this.expendoct;
	}

	public void setExpendoct(Double expendoct) {
		this.expendoct = expendoct;
	}

	public Double getExpendnov() {
		return this.expendnov;
	}

	public void setExpendnov(Double expendnov) {
		this.expendnov = expendnov;
	}

	public Double getExpenddec() {
		return this.expenddec;
	}

	public void setExpenddec(Double expenddec) {
		this.expenddec = expenddec;
	}

}