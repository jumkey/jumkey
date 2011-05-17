package org.cafeboy.model;

/**
 * Txclientsplit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txclientsplit implements java.io.Serializable {

	// Fields

	private TxclientsplitId id;
	private Txbuildapply txbuildapplyByBuildapplyid;
	private Txbuildapply txbuildapplyByRelateid;

	// Constructors

	/** default constructor */
	public Txclientsplit() {
	}

	/** full constructor */
	public Txclientsplit(TxclientsplitId id, Txbuildapply txbuildapplyByBuildapplyid, Txbuildapply txbuildapplyByRelateid) {
		this.id = id;
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
		this.txbuildapplyByRelateid = txbuildapplyByRelateid;
	}

	// Property accessors

	public TxclientsplitId getId() {
		return this.id;
	}

	public void setId(TxclientsplitId id) {
		this.id = id;
	}

	public Txbuildapply getTxbuildapplyByBuildapplyid() {
		return this.txbuildapplyByBuildapplyid;
	}

	public void setTxbuildapplyByBuildapplyid(Txbuildapply txbuildapplyByBuildapplyid) {
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
	}

	public Txbuildapply getTxbuildapplyByRelateid() {
		return this.txbuildapplyByRelateid;
	}

	public void setTxbuildapplyByRelateid(Txbuildapply txbuildapplyByRelateid) {
		this.txbuildapplyByRelateid = txbuildapplyByRelateid;
	}

}