import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cubics.im.entity.product.ProductEntity;
import com.cubics.im.entity.product.ProductStatus;
import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.service.vendor.VendorVO;

public class ProductVendorRelationTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			emf = Persistence.createEntityManagerFactory("OracleUnit");
			em = emf.createEntityManager();
			System.out.println("connected to database");
			et = em.getTransaction();
			et.begin();
			VendorEntity ve = new VendorEntity();
			ve.setAddress1("address1");
			ve.setAddress2("address2");
			ve.setCity("Dallas");
			ve.setEmail("email@email.com");
			ve.setFax("1239393");
			ve.setPhone("91919911");
			ve.setState("Texas");
			ve.setStatus(VendorStatus.active);
			ve.setVendorCode("IO99");
			ve.setVendorName("vendrName");
			ve.setZip("949490");
			// ve.setId(new Long(21));
			// return ve;
			VendorEntity ve2 = new VendorEntity();
			ve2.setAddress1("address21");
			ve2.setAddress2("address22");
			ve2.setCity("Dallas2");
			ve2.setEmail("email@email.com");
			ve2.setFax("1239393");
			ve2.setPhone("91919911");
			ve2.setState("Texas");
			ve2.setStatus(VendorStatus.active);
			ve2.setVendorCode("2O99");
			ve2.setVendorName("vendr2Name");
			ve2.setZip("949490");

			ProductEntity pe = new ProductEntity();
			pe.setCode("OPOP");
			pe.setCurrentQuantity("100");
			pe.setDescription("kkl");
			pe.setOrderQuantity("1010");
			// pe.setPrimaryVendor("pv");
			pe.setProductName("nam2e");
			//pe.setSecondaryVendor("sv");
			pe.setStatus(ProductStatus.active);
			pe.setThresholdQuantity("100");
			pe.setModifyDate(new Date());
			pe.setCreatedDate(new Date());
			//pe.setVendorEntity(new VendorEntity());
		//	pe.setVendorEntity2(new VendorEntity());
			
			ProductEntity pe2 = new ProductEntity();
			pe2.setCode("OP2P");
			pe2.setCurrentQuantity("100");
			pe2.setDescription("kkl");
			pe2.setOrderQuantity("1010");
			// pe2.setPrimaryVendor("pv");
			pe2.setProductName("name");
			//pe2.setSecondaryVendor("sv");
			pe2.setStatus(ProductStatus.active);
			pe2.setThresholdQuantity("100");
			pe2.setModifyDate(new Date());
			pe2.setCreatedDate(new Date());
			ve2.getProductEntity().add(pe2);
			 ve.getProductEntity().add(pe2);
			pe2.setVendorEntity(ve);
			pe2.setVendorEntity2(ve2);
			//pe2.getVendorEntity();
		//.persist(pe);
			em.persist(ve2);
			em.persist(ve);
//			ProductEntity e = new ProductEntity();
//			e= em.find(ProductEntity.class, new Long(960));
//			System.out.println("\n");
//			System.out.println(e.getVendorEntity());
//			System.out.println("\n");		
//			System.out.println(e.getVendorEntity2());
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.setRollbackOnly();
		} finally {

		}
	}

}
