package com.cubics.im.JunitTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.mockito.test.GenerateData;
import com.cubics.im.service.vendor.VendorMapper;
import com.cubics.im.service.vendor.VendorVO;

class VendorMapperTest {

	
	VendorMapper mapper = new VendorMapper();

	GenerateData data = new GenerateData();

	private VendorVO vendorVO1 = data.createVO();
	private VendorEntity vendorEntity1 = data.createEntity();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	
	@Test
	public void mapToVendorEntityTest() {
		VendorEntity result1 = mapper.mapToVendorEntity(vendorEntity1, vendorVO1);
		assertEquals(vendorEntity1, result1);
		//different entity
		vendorEntity1.setAddress1("sdkfj");
		vendorEntity1.setStatus(VendorStatus.active);
		VendorEntity result2 = mapper.mapToVendorEntity(vendorEntity1, vendorVO1);
		assertEquals(vendorEntity1, result2);
	}

}
