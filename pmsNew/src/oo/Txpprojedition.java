package org.cafeboy.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Txpprojedition entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXPPROJEDITION", schema = "JUMKEY")
public class Txpprojedition implements java.io.Serializable {

	// Fields

	private String planpeid;
	private Msspec msspec;
	private Txplaninfo txplaninfo;
	private Long edno;
	private String name;
	private String code;
	private String content;
	private Long type;
	private Long investattri;
	private Date startdate;
	private Date enddate;
	private Double totalinvest;
	private Double thisinvest;
	private Double nextinvest;
	private Long priority;
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
	private Long projtype;

	// Constructors

	/** default constructor */
	public Txpprojedition() {
	}

	/** full constructor */
	public Txpprojedition(Msspec msspec, Txplaninfo txplaninfo, Long edno, String name, String code, String content, Long type, Long investattri, Date startdate, Date enddate, Double totalinvest, Double thisinvest, Double nextinvest, Long priority, Double expendjan, Double expendfeb, Double expendmar, Double expendapr, Double expendmay, Double expendjun, Double expendjul, Double expendaug, Double expendsep, Double expendoct, Double expendnov, Double expenddec, Long projtype) {
		this.msspec = msspec;
		this.txplaninfo = txplaninfo;
		this.edno = edno;
		this.name = name;
		this.code = code;
		this.content = content;
		this.type = type;
		this.investattri = investattri;
		this.startdate = startdate;
		this.enddate = enddate;
		this.totalinvest = totalinvest;
		this.thisinvest = thisinvest;
		this.nextinvest = nextinvest;
		this.priority = priority;
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
		this.projtype = projtype;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "PLANPEID", unique = true, nullable = false, length = 32)
	public String getPlanpeid() {
		return this.planpeid;
	}

	public void setPlanpeid(String planpeid) {
		this.planpeid = planpeid;
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

	@Column(name = "EDNO", precision = 1, scale = 0)
	public Long getEdno() {
		return this.edno;
	}

	public void setEdno(Long edno) {
		this.edno = edno;
	}

	@Column(name = "NAME", length = 50)
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

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "TYPE", precision = 1, scale = 0)
	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	@Column(name = "INVESTATTRI", precision = 1, scale = 0)
	public Long getInvestattri() {
		return this.investattri;
	}

	public void setInvestattri(Long investattri) {
		this.investattri = investattri;
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

	@Column(name = "TOTALINVEST", precision = 14)
	public Double getTotalinvest() {
		return this.totalinvest;
	}

	public void setTotalinvest(Double totalinvest) {
		this.totalinvest = totalinvest;
	}

	@Column(name = "THISINVEST", precision = 14)
	public Double getThisinvest() {
		return this.thisinvest;
	}

	public void setThisinvest(Double thisinvest) {
		this.thisinvest = thisinvest;
	}

	@Column(name = "NEXTINVEST", precision = 14)
	public Double getNextinvest() {
		return this.nextinvest;
	}

	public void setNextinvest(Double nextinvest) {
		this.nextinvest = nextinvest;
	}

	@Column(name = "PRIORITY", precision = 4, scale = 0)
	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
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

	@Column(name = "PROJTYPE", precision = 1, scale = 0)
	public Long getProjtype() {
		return this.projtype;
	}

	public void setProjtype(Long projtype) {
		this.projtype = projtype;
	}

}