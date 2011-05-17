package org.cafeboy.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Txbuildsplit entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXBUILDSPLIT", schema = "JUMKEY")
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
	@EmbeddedId
	@AttributeOverrides( { @AttributeOverride(name = "buildapplyid", column = @Column(name = "BUILDAPPLYID", nullable = false, length = 32)), @AttributeOverride(name = "parentid", column = @Column(name = "PARENTID", nullable = false, length = 32)) })
	public TxbuildsplitId getId() {
		return this.id;
	}

	public void setId(TxbuildsplitId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENTID", nullable = false, insertable = false, updatable = false)
	public Txbuildapply getTxbuildapplyByParentid() {
		return this.txbuildapplyByParentid;
	}

	public void setTxbuildapplyByParentid(Txbuildapply txbuildapplyByParentid) {
		this.txbuildapplyByParentid = txbuildapplyByParentid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false, insertable = false, updatable = false)
	public Txbuildapply getTxbuildapplyByBuildapplyid() {
		return this.txbuildapplyByBuildapplyid;
	}

	public void setTxbuildapplyByBuildapplyid(Txbuildapply txbuildapplyByBuildapplyid) {
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
	}

}