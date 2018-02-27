package com.cubics.im.service.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubics.im.entity.product.ProductEntity;

@Component
public class ProductMapper {

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
		entity.setPrimaryVendor(vo.getPrimaryVendor());
		entity.setProductName(vo.getProductName());
		entity.setStatus(vo.getStatus());
		entity.setSecondaryVendor(vo.getSecondaryVendor());
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
		vo.setPrimaryVendor(entity.getPrimaryVendor());
		vo.setProductName(entity.getProductName());
		vo.setStatus(entity.getStatus());
		vo.setSecondaryVendor(entity.getSecondaryVendor());
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
