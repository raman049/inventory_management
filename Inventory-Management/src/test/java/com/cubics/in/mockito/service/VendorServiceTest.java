package com.cubics.in.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.mockito.test.GenerateData;
import com.cubics.im.service.vendor.VendorServiceImpl;
import com.cubics.im.service.vendor.VendorVO;
import com.cubics.im.validator.Validator;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
class VendorServiceTest {

	private VendorEntity entity = null;
	private VendorVO vo = null;

	@Spy
	private VendorServiceImpl mockvs = null;
	@Mock
	EntityManager em;// = mock(EntityManager.class);
	@Mock
	Validator vali;

	@BeforeEach
	void setUp() throws Exception {
		entity = GenerateData.createEntity();
		vo = GenerateData.createVO();
		vali = new Validator();
		MockitoAnnotations.initMocks(this);
		when(mockvs.getEm()).thenReturn(em);
	//	when(mockvs.getValidator()).thenReturn(vali);
	}

	@Test
	public void createVendorTest() {
		// when(mockvs.getEm().persist(VendorVO.class)).thenReturn(vo);
		when(mockvs.createVendor(any(VendorVO.class))).thenReturn(vo);
		VendorVO out = mockvs.createVendor(vo);
		assertEquals(out.getAddress1(), vo.getAddress1());
	}

}
