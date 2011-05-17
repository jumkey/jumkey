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
 * Txclientsplit entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TXCLIENTSPLIT", schema = "JUMKEY")
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
	@EmbeddedId
	@AttributeOverrides( { @AttributeOverride(name = "buildapplyid", column = @Column(name = "BUILDAPPLYID", nullable = false, length = 32)), @AttributeOverride(name = "relateid", column = @Column(name = "RELATEID", nullable = false, length = 32)) })
	public TxclientsplitId getId() {
		return this.id;
	}

	public void setId(TxclientsplitId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUILDAPPLYID", nullable = false, insertable = false, updatable = false)
	public Txbuildapply getTxbuildapplyByBuildapplyid() {
		return this.txbuildapplyByBuildapplyid;
	}

	public void setTxbuildapplyByBuildapplyid(Txbuildapply txbuildapplyByBuildapplyid) {
		this.txbuildapplyByBuildapplyid = txbuildapplyByBuildapplyid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RELATEID", nullable = false, insertable = false, updatable = false)
	public Txbuildapply getTxbuildapplyByRelateid() {
		return this.txbuildapplyByRelateid;
	}

	public void setTxbuildapplyByRelateid(Txbuildapply txbuildapplyByRelateid) {
		this.txbuildapplyByRelateid = txbuildapplyByRelateid;
	}

}