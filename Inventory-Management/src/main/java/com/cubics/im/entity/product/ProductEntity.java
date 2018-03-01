package com.cubics.im.entity.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cubics.im.entity.vendor.QueryConstant;
import com.cubics.im.entity.vendor.VendorEntity;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({
		@NamedQuery(name = QueryConstant.PRODUCT_SEARCH_NAME, query = "select c from ProductEntity c where UPPER (c.productName) like UPPER(:name)"),
		@NamedQuery(name = QueryConstant.PRODUCT_SEARCH_CODE, query = "select c from ProductEntity c where UPPER (c.code) like UPPER(:code)"),
		@NamedQuery(name = QueryConstant.PRODUCT_ACTIVE_QUERY, query = "select c from ProductEntity c where UPPER (c.status) like UPPER(:active)") })
public class ProductEntity {

	@Id
	@Column(name = "PK")
	@GeneratedValue(generator = "VSeq")
	@SequenceGenerator(name = "VSeq", sequenceName = "INVENTORYSEQUENCE")
	private long pk;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CODE")
	private String code;
	@Column(name = "CURRENT_QUANTITY")
	private String currentQuantity;
	@Column(name = "ORDER_QUANTITY")
	private String orderQuantity;
	@Column(name = "THRESHOLD_QUANTITY")
	private String thresholdQuantity;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private ProductStatus status;
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;// = new Date();
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;
	//@OneToMany(fetch=FetchType.LAZY)
	//@JoinColumn(name = "PRIMARY_VENDOR")
	//@Column(name="PRIMARY_VENDOR")
	//private String primaryVendor;
//	@Column(name = "SECONDARY_VENDOR")
//	private String secondaryVendor;

	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name="PRIMARY_VENDOR")
	private VendorEntity primaryVendor;

	@ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.PERSIST)
	@JoinColumn(name="SECONDARY_VENDOR")
	private VendorEntity secondaryVendor;

	public VendorEntity getPrimaryVendor() {
		return primaryVendor;
	}

	public void setPrimaryVendor(VendorEntity primaryVendor) {
		this.primaryVendor = primaryVendor;
	}

	public VendorEntity getSecondaryVendor() {
		return secondaryVendor;
	}

	public void setSecondaryVendor(VendorEntity secondaryVendor) {
		this.secondaryVendor = secondaryVendor;
	}

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(String currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getThresholdQuantity() {
		return thresholdQuantity;
	}

	public void setThresholdQuantity(String thresholdQuantity) {
		this.thresholdQuantity = thresholdQuantity;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

//	public String getPrimaryVendor() {
//		return primaryVendor;
//	}
//
//	public void setPrimaryVendor(String primaryVendor) {
//		this.primaryVendor = primaryVendor;
//	}

//	public String getSecondaryVendor() {
//		return secondaryVendor;
//	}
//
//	public void setSecondaryVendor(String secondaryVendor) {
//		this.secondaryVendor = secondaryVendor;
//	}

	@Override
	public String toString() {
		return "ProductEntity [pk=" + pk + ", productName=" + productName + ", description=" + description + ", code="
				+ code + ", currentQuantity=" + currentQuantity + ", orderQuantity=" + orderQuantity
				+ ", threshodQuantity=" + thresholdQuantity + ", satatus=" + status + ", createdDate=" + createdDate
				+ ", modifyDate=" + modifyDate + ", primaryVendor="  + ", secondaryVendor="
				+  "]";
	}

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}

}
