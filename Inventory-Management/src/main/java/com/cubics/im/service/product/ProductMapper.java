package com.cubics.im.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cubics.im.entity.product.ProductEntity;
import com.cubics.im.service.vendor.VendorMapper;
import com.cubics.im.service.vendor.VendorService;

@Component
public class ProductMapper {
	@Autowired
	VendorMapper mapper;
	@Autowired
	VendorService vs;
	public ProductEntity mapToProductEntity(final ProductVO vo) {
		return mapToProductEntity(new ProductEntity(), vo);

	}

	public ProductEntity mapToProductEntity(final ProductEntity entity, final ProductVO vo) {
		entity.setCode(vo.getCode());
		entity.setCreatedDate(vo.getCreatedDate());
		entity.setCurrentQuantity(vo.getCurrentQuantity());
		entity.setDescription(vo.getDescription());
		entity.setModifyDate(vo.getModifyDate());
		entity.setOrderQuantity(vo.getOrderQuantity());
		entity.setPk(vo.getId());
		//entity.setPrimaryVendor(mapper.mapToVendorEntity(vo.getPrimaryVenderVO()));
		entity.setPrimaryVendor(mapper.mapToVendorEntity(vs.findById(vo.getPrimaryVendor())));
		//entity.setSecondaryVendor(mapper.mapToVendorEntity(vo.getSecondaryVendorVO()));
		entity.setSecondaryVendor(mapper.mapToVendorEntity(vs.findById(vo.getSecondaryVendor())));
		//entity.setPrimaryVendor(mapToVendorEntity(vo.getPrimaryVO()));
		entity.setProductName(vo.getProductName());
		entity.setStatus(vo.getStatus());
		//entity.setSecondaryVendor(vo.getSecondaryVendor());
		entity.setThresholdQuantity(vo.getThresholdQuantity());
		return entity;

	}

	public ProductVO mapToProductVO(final ProductEntity entity) {
		ProductVO vo = new ProductVO();
		vo.setCode(entity.getCode());
		vo.setCreatedDate(entity.getCreatedDate());
		vo.setCurrentQuantity(entity.getCurrentQuantity());
		vo.setDescription(entity.getDescription());
		vo.setModifyDate(entity.getModifyDate());
		vo.setOrderQuantity(entity.getOrderQuantity());
		vo.setId(entity.getPk());
	//	vo.setPrimaryVenderVO(mapper.mapToVendorVO(entity.getPrimaryVendor()));
		vo.setPrimaryVendor(mapper.mapToVendorVO(entity.getPrimaryVendor()).getPk());
	//	vo.setSecondaryVendorVO(mapper.mapToVendorVO(entity.getSecondaryVendor()));
		vo.setSecondaryVendor(mapper.mapToVendorVO(entity.getSecondaryVendor()).getPk());
	//	vo.setPrimaryVendor(entity.getPrimaryVendor());
	//	vo.setSecondaryVendor(entity.getSecondaryVendor());
		vo.setProductName(entity.getProductName());
		vo.setStatus(entity.getStatus());
		vo.setThresholdQuantity(entity.getThresholdQuantity());
		return vo;
	}

	public List<ProductVO> mapToVendorVO(final List<ProductEntity> entityList) {
		final List<ProductVO> result = new ArrayList<ProductVO>();
		for (ProductEntity entity : entityList) {
			result.add(mapToProductVO(entity));
		}
		return result;
	}
	

}
