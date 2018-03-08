package com.cubics.im.service.product;

import java.util.Date;

import com.cubics.im.entity.product.ProductStatus;
import com.cubics.im.service.vendor.VendorVO;

public class ProductVO {

	private long id;
	private String productName;
	private String description;
	private String code;
	private String currentQuantity;
	private String orderQuantity;
	private String thresholdQuantity;
	private ProductStatus status;
	private Date createdDate;
	private Date modifyDate;
    private long primaryVendor;
	private long secondaryVendor;
	//private VendorVO primaryVenderVO;
	//private VendorVO secondaryVendorVO;

	
//	public VendorVO getPrimaryVenderVO() {
//		return primaryVenderVO;
//	}
//
//	public void setPrimaryVenderVO(VendorVO primaryVenderVO) {
//		this.primaryVenderVO = primaryVenderVO;
//	}
//
//	public VendorVO getSecondaryVendorVO() {
//		return secondaryVendorVO;
//	}
//
//	public void setSecondaryVendorVO(VendorVO secondaryVendorVO) {
//		this.secondaryVendorVO = secondaryVendorVO;
//	}

	public long getPrimaryVendor() {
		return primaryVendor;
	}

	public void setPrimaryVendor(long primaryVendor) {
		this.primaryVendor = primaryVendor;
	}

	public long getSecondaryVendor() {
		return secondaryVendor;
	}

	public void setSecondaryVendor(long secondaryVendor) {
		this.secondaryVendor = secondaryVendor;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	// public String getPrimaryVendor() {
	// return primaryVendor;
	// }
	//
	// public void setPrimaryVendor(String primaryVendor) {
	// this.primaryVendor = primaryVendor;
	// }
	//
	// public String getSecondaryVendor() {
	// return secondaryVendor;
	// }
	//
	// public void setSecondaryVendor(String secondaryVendor) {
	// this.secondaryVendor = secondaryVendor;
	// }

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", productName=" + productName + ", description=" + description + ", code="
				+ code + ", currentQuantity=" + currentQuantity + ", orderQuantity=" + orderQuantity
				+ ", thresholdQuantity=" + thresholdQuantity + ", satatus=" + status + ", createdDate=" + createdDate
				+ ", modifyDate=" + modifyDate + ", primaryVendor=" + ", secondaryVendor=" + "]";
	}

}
