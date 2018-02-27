package com.cubics.im.resources.vendor;

import java.util.List;

import com.cubics.im.service.vendor.VendorVO;

public class VendorSearchResult {

	private List<VendorVO> vendor;

	public VendorSearchResult(List<VendorVO> vendor) {
		super();
		this.vendor = vendor;
	}

	public VendorSearchResult() {
		super();
	}

	public List<VendorVO> getVendor() {
		return vendor;
	}

	public void setVendor(List<VendorVO> vendor) {
		this.vendor = vendor;
	}

}
