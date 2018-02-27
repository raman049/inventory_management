package com.cubics.im.service.vendor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubics.im.entity.vendor.QueryConstant;
import com.cubics.im.entity.vendor.VendorEntity;
import com.cubics.im.entity.vendor.VendorStatus;
import com.cubics.im.exception.DataNotFound;
import com.cubics.im.exception.DuplicateDataError;
import com.cubics.im.exception.InvalidDataError;
import com.cubics.im.validator.Validator;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private VendorMapper mapper;
	@Autowired
	private Validator validator;

	@Override
	public VendorVO createVendor(VendorVO vo) {
		if (validator.validName(vo.getVendorName()) && validator.email(vo.getEmail())
				&& validator.validCode(vo.getVendorCode())) {
			if (isDuplicate(vo.getVendorCode(), vo.getVendorName())) {
				throw new DuplicateDataError("Duplicate data.");
			} else {
				VendorEntity entity = mapper.mapToVendorEntity(vo);
				em.persist(entity);
				vo.setPk(entity.getId());
				return vo;
			}
		} else {
			throw new InvalidDataError("Invalid data.");
		}
	}

	@Override
	public void updateVendor(VendorVO vo) {
		if (validator.validName(vo.getVendorName()) && validator.email(vo.getEmail())
				&& validator.validCode(vo.getVendorCode())) {
			if (isDuplicate(vo.getVendorCode(), vo.getVendorName())) {
				VendorEntity entity = em.find(VendorEntity.class, vo.getPk());
				entity = mapper.mapToVendorEntity(entity, vo);
				em.persist(entity);
			} else {
				throw new DuplicateDataError("duplicate");
			}
		} else {
			throw new DataNotFound("data does not exit");
		}
	}

	@Override
	public void activateVendor(Long id) {
		final VendorEntity entity = findByIdMethod(id);
		entity.setStatus(VendorStatus.active);
		em.persist(entity);
	}

	@Override
	public void deactivateVendor(Long id) {
		final VendorEntity entity = findByIdMethod(id);
		entity.setStatus(VendorStatus.deactive);
		em.persist(entity);
	}

	@Override
	public VendorVO findById(Long id) {
		final VendorEntity entity = findByIdMethod(id);
		return mapper.mapToVendorVO(entity);
	}

	private VendorEntity findByIdMethod(Long id) {
		final VendorEntity entity = em.find(VendorEntity.class, id);
		if (entity == null) {
			throw new DataNotFound("data does not exist" + id);
		}
		return entity;
	}

	@Override
	public VendorVO findByCode(String code) {
		TypedQuery<VendorEntity> query = em.createNamedQuery(QueryConstant.VENDOR_SEARCH_CODE, VendorEntity.class);
		query.setParameter("code", code);
		final List<VendorEntity> entities = query.getResultList();
		if (!entities.isEmpty()) {
			VendorEntity entity = entities.get(0);
			return mapper.mapToVendorVO(entity);
		} else {
			throw new DataNotFound("data does not exist" + code);
		}

	}

	@Override
	public List<VendorVO> searchActiveVendor() {
		TypedQuery<VendorEntity> query = em.createNamedQuery(QueryConstant.VENDOR_ACTIVE_QUERY, VendorEntity.class);
		query.setParameter("active", "active");
		final List<VendorEntity> entities = query.getResultList();
		List<VendorVO> volist = mapper.mapToVendorVO(entities);
		return volist;
	}

	@Override
	public boolean isDuplicate(String code, String name) {
		TypedQuery<VendorEntity> query1 = em.createNamedQuery(QueryConstant.VENDOR_SEARCH_CODE, VendorEntity.class);
		query1.setParameter("code", code);
		final List<VendorEntity> entities = query1.getResultList();
		TypedQuery<VendorEntity> query2 = em.createNamedQuery(QueryConstant.VENDOR_SEARCH_NAME, VendorEntity.class);
		query2.setParameter("name", name);
		final List<VendorEntity> entities2 = query2.getResultList();
		if (entities.isEmpty() && entities2.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
