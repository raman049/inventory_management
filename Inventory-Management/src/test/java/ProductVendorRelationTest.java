import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cubics.im.entity.product.ProductEntity;
import com.cubics.im.entity.product.ProductStatus;
import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;

@Service
@Transactional
public class ProductVendorRelationTest {

	@PersistenceContext
	private static EntityManager em;
	public static void main(String[] args) {
		try {
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

			VendorEntity ve2 = new VendorEntity();
			ve2.setAddress1("2222");
			ve2.setAddress2("22");
			ve2.setCity("22");
			ve2.setEmail("email@email.com");
			ve2.setFax("123932293");
			ve2.setPhone("91919911");
			ve2.setState("Texas");
			ve2.setStatus(VendorStatus.active);
			ve2.setVendorCode("POP9");
			ve2.setVendorName("vendorName");
			ve2.setZip("949490");
			ve2.setId(new Long(21));
		
			ProductEntity pe = new ProductEntity();
			pe.setCode("EOEO");
			pe.setCurrentQuantity("90");
			pe.setDescription("sd");
			pe.setOrderQuantity("90");
		//	pe.getVendorEntity().add(ve);
			//pe.getVendorEntity().add(ve2);
		//	pe.setPrimaryVendor(primaryVendor);
			pe.setProductName("name");
		//	pe.setSecondaryVendor(secondaryVendor);
			pe.setStatus(ProductStatus.active);
			 System.out.println(pe);
			//em.persist(pe);
			em.persist(ve);
			

			// et.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// et.setRollbackOnly();

		} finally {
			if (em != null)
				em.close();
//			if (emf != null)
//				emf.close();

		}
	}

}
