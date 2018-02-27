package com.cubics.im.mockito.test;

import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.service.vendor.VendorVO;

public class VendorData {

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
		return vo;
	}
}
