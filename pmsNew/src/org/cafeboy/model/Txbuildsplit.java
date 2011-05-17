package org.cafeboy.model;

/**
 * Txbuildsplit entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Txbuildsplit implements java.io.Serializable {

	// Fields

	private TxbuildsplitId id;
	private Txbuildapply txbuildapplyByParentid;
	private Txbuildapply txbuildapplyByBuildapplyid;

	// Constructors

	/** default constructor */
	public Txbuildsplit() {
	}

	/** full constructor */
	public Txbuildsplit(TxbuildsplitId id, Txbuildapply txbuildapplyByParentid, Txbuildapply txbuildapplyByBuildapplyid) {
		this.id = id;
		this.txbuildapplyByParentid = txbuildapplyByParentid;
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
	}

	// Property accessors

	public TxbuildsplitId getId() {
		return this.id;
	}

	public void setId(TxbuildsplitId id) {
		this.id = id;
	}

	public Txbuildapply getTxbuildapplyByParentid() {
		return this.txbuildapplyByParentid;
	}

	public void setTxbuildapplyByParentid(Txbuildapply txbuildapplyByParentid) {
		this.txbuildapplyByParentid = txbuildapplyByParentid;
	}

	public Txbuildapply getTxbuildapplyByBuildapplyid() {
		return this.txbuildapplyByBuildapplyid;
	}

	public void setTxbuildapplyByBuildapplyid(Txbuildapply txbuildapplyByBuildapplyid) {
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
	}

}