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
 * Txbuildjudge entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBUILDJUDGE", schema = "JUMKEY")
public class Txbuildjudge implements java.io.Serializable {

	// Fields

	private String buildjudgeid;
	private Txbuildaudit txbuildaudit;
	private Txbuildapply txbuildapply;
	private String judgepersonid;
	private Long judgeresult;
	private String judgecomment;
	private Date judgedate;
	private String judgerole;

	// Constructors

	/** default constructor */
	public Txbuildjudge() {
	}

	/** full constructor */
	public Txbuildjudge(Txbuildaudit txbuildaudit, Txbuildapply txbuildapply, String judgepersonid, Long judgeresult, String judgecomment, Date judgedate, String judgerole) {
		this.txbuildaudit = txbuildaudit;
		this.txbuildapply = txbuildapply;
		this.judgepersonid = judgepersonid;
		this.judgeresult = judgeresult;
		this.judgecomment = judgecomment;
		this.judgedate = judgedate;
		this.judgerole = judgerole;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "BUILDJUDGEID", unique = true, nullable = false, length = 32)
	public String getBuildjudgeid() {
		return this.buildjudgeid;
	}

	public void setBuildjudgeid(String buildjudgeid) {
		this.buildjudgeid = buildjudgeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLANAUDITID")
	public Txbuildaudit getTxbuildaudit() {
		return this.txbuildaudit;
	}

	public void setTxbuildaudit(Txbuildaudit txbuildaudit) {
		this.txbuildaudit = txbuildaudit;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID")
	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	@Column(name = "JUDGEPERSONID", length = 32)
	public String getJudgepersonid() {
		return this.judgepersonid;
	}

	public void setJudgepersonid(String judgepersonid) {
		this.judgepersonid = judgepersonid;
	}

	@Column(name = "JUDGERESULT", precision = 1, scale = 0)
	public Long getJudgeresult() {
		return this.judgeresult;
	}

	public void setJudgeresult(Long judgeresult) {
		this.judgeresult = judgeresult;
	}

	@Column(name = "JUDGECOMMENT", length = 500)
	public String getJudgecomment() {
		return this.judgecomment;
	}

	public void setJudgecomment(String judgecomment) {
		this.judgecomment = judgecomment;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "JUDGEDATE", length = 7)
	public Date getJudgedate() {
		return this.judgedate;
	}

	public void setJudgedate(Date judgedate) {
		this.judgedate = judgedate;
	}

	@Column(name = "JUDGEROLE", length = 32)
	public String getJudgerole() {
		return this.judgerole;
	}

	public void setJudgerole(String judgerole) {
		this.judgerole = judgerole;
	}

}