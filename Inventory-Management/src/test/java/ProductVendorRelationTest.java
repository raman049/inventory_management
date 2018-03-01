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

//			ProductEntity pe = new ProductEntity();
//			pe.setCode("11OP");
//			pe.setCurrentQuantity("1010");
//			pe.setDescription("k1111kl");
//			pe.setOrderQuantity("11010");
//			pe.setProductName("111111");
//			pe.setStatus(ProductStatus.active);
//			pe.setThresholdQuantity("1100");
//			pe.setModifyDate(new Date());
//			pe.setCreatedDate(new Date());
//			ve2.getProductEntity().add(pe);
//			ve.getProductEntity().add(pe);
//			pe.setPrimaryVendor(ve);
//			pe.setSecondaryVendor(ve2);
			//em.persist(ve);
			//em.persist(ve2);
		//	em.persist(pe);
			 ProductEntity pe2 = new ProductEntity();
			 pe2.setCode("OP2P");
			 pe2.setCurrentQuantity("100");
			 pe2.setDescription("kkl");
			 pe2.setOrderQuantity("1010");
			 pe2.setProductName("name");
			 pe2.setStatus(ProductStatus.active);
			 pe2.setThresholdQuantity("100");
			 pe2.setModifyDate(new Date());
			 pe2.setCreatedDate(new Date());
			// ve2.getProductEntity().add(pe2);
			 //ve.getProductEntity().add(pe2);
			 pe2.setPrimaryVendor(em.find(VendorEntity.class, new Long(1070)));
			 pe2.setSecondaryVendor(em.find(VendorEntity.class, new Long(951)));
			 em.persist(pe2);
			// em.persist(ve2);
			// em.persist(ve);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			et.setRollbackOnly();
		} finally {

		}
	}

}
