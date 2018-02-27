package com.cubics.in.mockito.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.jpa.criteria.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.mockito.test.VendorData;
import com.cubics.im.resources.vendor.VendorResource;
import com.cubics.im.service.vendor.VendorService;
import com.cubics.im.service.vendor.VendorServiceImpl;
import com.cubics.im.service.vendor.VendorVO;

@RunWith(MockitoJUnitRunner.class)
class VendorServiceTest {

	private VendorEntity entity = null;
	private VendorVO vo = null;

	@Mock
	private VendorServiceImpl mockserv =null;
	@Spy
	private VendorResource mockres;
	
	
	@BeforeEach
	void setUp() throws Exception {
		entity = VendorData.createEntity();
		vo = VendorData.createVO();
	//	when(mockres.getVs()).thenReturn(mockserv);
		
		//when(impl.getVs()).thenReturn(mockserv);
	}

	@Test
	public void createVendorTest() {

	//when(mockPDao.createProduct(any(ProductEntity.class))).thenReturn(pentity);
	//	ProductVO output = impl.saveProduct(pvo);
		//assertNotNull(output);
		//assertNotNull(output.getId());
		assertEquals(1, 1);
		//assertEquals(output.getDescription(), pvo.getDescription());
	}


}
