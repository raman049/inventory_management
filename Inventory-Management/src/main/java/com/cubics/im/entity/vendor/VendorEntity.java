package com.cubics.im.entity.vendor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubics.im.entity.product.ProductEntity;

@Entity
@Table(name = "VENDOR")
@NamedQueries({
		@NamedQuery(name = QueryConstant.VENDOR_SEARCH_NAME, query = "select c from VendorEntity c where UPPER (c.vendorName) like UPPER(:name)"),
		@NamedQuery(name = QueryConstant.VENDOR_SEARCH_CODE, query = "select c from VendorEntity c where UPPER (c.vendorCode) like UPPER(:code)"),
		@NamedQuery(name = QueryConstant.VENDOR_ACTIVE_QUERY, query = "select c from VendorEntity c where UPPER (c.status) like UPPER(:active)") })
public class VendorEntity {

	@Id
	@Column(name = "PK")
	@GeneratedValue(generator = "VSeq")
	@SequenceGenerator(name = "VSeq", sequenceName = "INVENTORYSEQUENCE")
	private Long id;

	@Column(name = "VENDOR_NAME")
	private String vendorName;
	@Column(name = "ADDRESS1")
	private String address1;
	@Column(name = "ADDRESS2")
	private String address2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "ZIPCODE")
	private String zip;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "FAX")
	private String fax;
	@Column(name = "VENDOR_CODE")
	private String vendorCode;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS")
	private VendorStatus status;
	@Column(name = "EMAIL")
	private String email;

//	@ManyToOne
//	@JoinColumn(name = "PRIMARY_VENDOR")
//	private ProductEntity productEntity;
//
//	public ProductEntity getProductEntity() {
//		return productEntity;
//	}
//
//	public void setProductEntity(ProductEntity productEntity) {
//		this.productEntity = productEntity;
//	}

	 @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="vendorEntity")
	 private List<ProductEntity> productEntity = null;
	
	 public List<ProductEntity> getProductEntity() {
	 if (this.productEntity==null) {
	 this.productEntity=new ArrayList<ProductEntity>();
	 }
	 return productEntity;
	 }
	
	 public void setProductEntity(List<ProductEntity> productEntity) {
	 this.productEntity = productEntity;
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getVendorCode() {
		return vendorCode;
	}

	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}

	public VendorStatus getStatus() {
		return status;
	}

	public void setStatus(VendorStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VendorEntity [pk=" + id + ", vendorName=" + vendorName + ", address1=" + address1 + ", address2="
				+ address2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", fax="
				+ fax + ", vendorCode=" + vendorCode + ", status=" + status + ", email=" + email + "]";
	}

}
