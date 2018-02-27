package com.cubics.im.service.vendor;

import java.util.List;

public interface VendorService {

	VendorVO createVendor(final VendorVO vo);

	void updateVendor(final VendorVO vo);

	void activateVendor(final Long id);

	void deactivateVendor(final Long id);

	VendorVO findById(final Long id);

	VendorVO findByCode(final String code);

	List<VendorVO> searchActiveVendor();

	boolean  isDuplicate(String code, String name);
}
