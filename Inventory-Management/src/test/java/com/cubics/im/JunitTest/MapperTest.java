package com.cubics.im.JunitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.mockito.test.GenerateData;
import com.cubics.im.service.vendor.VendorMapper;
import com.cubics.im.service.vendor.VendorVO;

class MapperTest {

	VendorMapper mapper = new VendorMapper();

	// GenerateData data = new GenerateData();

	private static VendorVO vendorVO1 = GenerateData.createVO();
	private static VendorEntity vendorEntity1 = GenerateData.createEntity();
	private static VendorEntity vendorEntity2 = GenerateData.createEntity();

	@BeforeEach
	void setUp() throws Exception {
		vendorEntity2.setAddress1("add1");
		vendorEntity2.setAddress2("add2");
		vendorEntity2.setCity("city2");
		vendorEntity2.setFax("fax");
		vendorEntity2.setStatus(VendorStatus.pending);
	}

	@Test
	public void mapToVendorEntityTest() {
		// VendorEntity result = mapper.mapToVendorEntity(vendorVO1);
		// assertEquals(vendorEntity1, result);
		VendorEntity result1 = mapper.mapToVendorEntity(vendorEntity1, vendorVO1);
		assertEquals(vendorEntity1, result1);
		// different entity
		VendorEntity result2 = mapper.mapToVendorEntity(vendorEntity2, vendorVO1);
		//System.out.println(result2);
		//System.out.println(vendorEntity2);
		assertEquals(vendorEntity1.toString(), result2.toString());

	}

	@Test
	public void mapToVendorVOTest() {
		VendorVO result = mapper.mapToVendorVO(vendorEntity1);
		assertEquals(vendorVO1.toString(), result.toString());
	}

	@Test
	public void mapToVendorVOListTest() {
		List<VendorVO> listVO = new ArrayList<VendorVO>();
		listVO.add(vendorVO1);
		List<VendorEntity> listEntity = new ArrayList<VendorEntity>();
		listEntity.add(vendorEntity1);
		List<VendorVO> result = mapper.mapToVendorVO(listEntity);
		System.out.println(vendorVO1.toString());
		System.out.println(vendorEntity1.toString());
		assertEquals(vendorVO1.toString(), result.toString());
	}

}
