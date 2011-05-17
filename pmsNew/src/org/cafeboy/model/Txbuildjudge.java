package org.cafeboy.model;

import java.util.Date;

/**
 * Txbuildjudge entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
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

	public String getBuildjudgeid() {
		return this.buildjudgeid;
	}

	public void setBuildjudgeid(String buildjudgeid) {
		this.buildjudgeid = buildjudgeid;
	}

	public Txbuildaudit getTxbuildaudit() {
		return this.txbuildaudit;
	}

	public void setTxbuildaudit(Txbuildaudit txbuildaudit) {
		this.txbuildaudit = txbuildaudit;
	}

	public Txbuildapply getTxbuildapply() {
		return this.txbuildapply;
	}

	public void setTxbuildapply(Txbuildapply txbuildapply) {
		this.txbuildapply = txbuildapply;
	}

	public String getJudgepersonid() {
		return this.judgepersonid;
	}

	public void setJudgepersonid(String judgepersonid) {
		this.judgepersonid = judgepersonid;
	}

	public Long getJudgeresult() {
		return this.judgeresult;
	}

	public void setJudgeresult(Long judgeresult) {
		this.judgeresult = judgeresult;
	}

	public String getJudgecomment() {
		return this.judgecomment;
	}

	public void setJudgecomment(String judgecomment) {
		this.judgecomment = judgecomment;
	}

	public Date getJudgedate() {
		return this.judgedate;
	}

	public void setJudgedate(Date judgedate) {
		this.judgedate = judgedate;
	}

	public String getJudgerole() {
		return this.judgerole;
	}

	public void setJudgerole(String judgerole) {
		this.judgerole = judgerole;
	}

}