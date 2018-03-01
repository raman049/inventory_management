package com.cubics.im.service.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubics.im.entity.product.ProductEntity;
import com.cubics.im.entity.product.ProductStatus;
import com.cubics.im.entity.vendor.QueryConstant;
import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.exception.DataNotFound;
import com.cubics.im.exception.DuplicateDataError;
import com.cubics.im.exception.InvalidDataError;
import com.cubics.im.validator.Validator;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private ProductMapper mapper;
	@Autowired
	private Validator validator;

	@Override
	public ProductVO createProduct(ProductVO vo) {
		if (validator.validName(vo.getProductName()) && validator.validCode(vo.getCode())) {

			if (isDuplicate(vo.getCode(), vo.getProductName())) {
				throw new DuplicateDataError("Product already exist.");
			} else {
				ProductEntity entity = mapper.mapToProductEntity(vo);
				entity.setPrimaryVendor(em.find(VendorEntity.class, vo.getPrimaryVendor()));
				entity.setSecondaryVendor(em.find(VendorEntity.class, vo.getSecondaryVendor()));
				em.persist(entity);
				vo.setId(entity.getPk());
				return vo;
			}
		} else {
			throw new InvalidDataError("Invalid product name or product code.");
		}
	}

	@Override
	public void updateProduct(ProductVO vo) {
		if (validator.validName(vo.getProductName()) && validator.validCode(vo.getCode())) {
			if (isDuplicate(vo.getCode(), vo.getProductName())) {
				ProductEntity entity = em.find(ProductEntity.class, vo.getId());
				entity = mapper.mapToProductEntity(entity, vo);
				entity.setPrimaryVendor(em.find(VendorEntity.class, vo.getPrimaryVendor()));
				entity.setSecondaryVendor(em.find(VendorEntity.class, vo.getSecondaryVendor()));
				

				em.persist(entity);
			} else {
				throw new DuplicateDataError("Product already exist.");
			}
		} else {
			throw new InvalidDataError("Invalid product name or product code.");
		}
	}

	@Override
	public void activateProduct(Long id) {
		ProductEntity entity = em.find(ProductEntity.class, id);
		entity.setStatus(ProductStatus.active);
		em.persist(entity);
	}

	@Override
	public void deactivateProduct(Long id) {
		ProductEntity entity = em.find(ProductEntity.class, id);
		entity.setStatus(ProductStatus.inactive);
		em.persist(entity);
	}

	@Override
	public ProductVO addProduct(String code, Long quantity) {
		Query query = em.createNamedQuery(QueryConstant.PRODUCT_SEARCH_CODE);
		query.setParameter("code", code);
		ProductEntity entity = (ProductEntity) query.getSingleResult();
		long a = Long.valueOf(entity.getCurrentQuantity()) + quantity;
		entity.setCurrentQuantity(String.valueOf(a));
		em.persist(entity);
		return mapper.mapToProductVO(entity);
	}

	@Override
	public ProductVO findByID(Long id) {
		return mapper.mapToProductVO(em.find(ProductEntity.class, id));
	}

	@Override
	public ProductVO findByCode(String code) {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstant.PRODUCT_SEARCH_CODE, ProductEntity.class);
		query.setParameter("code", code);
		final List<ProductEntity> entities = query.getResultList();
		if (!entities.isEmpty()) {
			ProductEntity entity = entities.get(0);
			// entity.getVendorEntity()
			// entity.setPrimaryVendor(entity.getVendorEntity().getCity());

			return mapper.mapToProductVO(entity);
		} else {
			throw new DataNotFound("data does not exist" + code);
		}
	}

	@Override
	public List<ProductVO> searchActiveProduct() {
		TypedQuery<ProductEntity> query = em.createNamedQuery(QueryConstant.PRODUCT_ACTIVE_QUERY, ProductEntity.class);
		query.setParameter("active", "active");
		final List<ProductEntity> entities = query.getResultList();
		List<ProductVO> voList = mapper.mapToVendorVO(entities);// new ArrayList<ProductVO>();

		return voList;
	}

	@Override
	public boolean isDuplicate(String code, String name) {
		TypedQuery<ProductEntity> query1 = em.createNamedQuery(QueryConstant.PRODUCT_SEARCH_NAME, ProductEntity.class);
		query1.setParameter("name", name);
		final List<ProductEntity> entity1 = query1.getResultList();
		TypedQuery<ProductEntity> query2 = em.createNamedQuery(QueryConstant.PRODUCT_SEARCH_CODE, ProductEntity.class);
		query2.setParameter("code", code);
		final List<ProductEntity> entity2 = query2.getResultList();
		if (entity1.isEmpty() && entity2.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
