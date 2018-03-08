package com.cubics.im.mockito.test;

import java.util.Date;

import com.cubics.im.entity.product.ProductEntity;
import com.cubics.im.entity.product.ProductStatus;
import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.service.product.ProductVO;
import com.cubics.im.service.vendor.VendorVO;

public class GenerateData {

	public static VendorEntity createEntity() {
		VendorEntity ve = new VendorEntity();
		ve.setAddress1("address1");
		ve.setAddress2("address2");
		ve.setCity("Dallas");
		ve.setEmail("email@email.com");
		ve.setFax("1239393");
		ve.setPhone("91919911");
		ve.setState("Texas");
		ve.setStatus(VendorStatus.active);
		ve.setVendorCode("IOP9");
		ve.setVendorName("vendorName");
		ve.setZip("949490");
		ve.setId(new Long(21));
		return ve;
	}

	public static VendorVO createVO() {
		VendorVO vo = new VendorVO();
		vo.setAddress1("address1");
		vo.setAddress2("address2");
		vo.setCity("Dallas");
		vo.setEmail("email@email.com");
		vo.setFax("1239393");
		vo.setPhone("91919911");
		vo.setState("Texas");
		vo.setStatus(VendorStatus.active);
		vo.setVendorCode("IOP9");
		vo.setVendorName("vendorName");
		vo.setZip("949490");
		vo.setPk(new Long(21));
		return vo;
	}

	public static ProductEntity createProductEntity() {
		ProductEntity pe = new ProductEntity();
		pe.setCode("11OP");
		pe.setCurrentQuantity("1010");
		pe.setDescription("k1111kl");
		pe.setOrderQuantity("11010");
		pe.setProductName("111111");
		pe.setStatus(ProductStatus.active);
		pe.setThresholdQuantity("1100");
		pe.setModifyDate(new Date());
		pe.setCreatedDate(new Date());
		pe.setPrimaryVendor(createEntity());
		pe.setSecondaryVendor(createEntity());
		pe.setPk(new Long(100));
		return pe;
	}

	public static ProductVO createProductVO() {
		ProductVO pvo = new ProductVO();
		pvo.setCode("RRRR");
		pvo.setCreatedDate(new Date());
		pvo.setCurrentQuantity("100");
		pvo.setDescription("Hola");
		pvo.setId(new Long(9));
		pvo.setModifyDate(new Date());
		pvo.setOrderQuantity("100");
		pvo.setPrimaryVendor(new Long(21));
		pvo.setSecondaryVendor(new Long(21));
		pvo.setStatus(ProductStatus.active);
		pvo.setThresholdQuantity("100");
		pvo.setId(new Long(100));
		return pvo;
	}
}
