package com.cubics.im.service.vendor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubics.im.entity.vendor.VendorEntity;

@Component
public class VendorMapper {

	public VendorEntity mapToVendorEntity(final VendorVO vo) {
		return mapToVendorEntity(new VendorEntity(), vo);

	}

	public VendorEntity mapToVendorEntity(final VendorEntity entity, final VendorVO vo) {
		entity.setVendorName(vo.getVendorName());
		entity.setAddress1(vo.getAddress1());
		entity.setAddress2(vo.getAddress2());
		entity.setCity(vo.getCity());
		entity.setEmail(vo.getEmail());
		entity.setFax(vo.getFax());
		entity.setPhone(vo.getPhone());
		entity.setState(vo.getState());
		entity.setStatus(vo.getStatus());
		entity.setVendorCode(vo.getVendorCode());
		entity.setZip(vo.getZip());
		return entity;

	}

	public VendorVO mapToVendorVO(final VendorEntity entity) {
		VendorVO vo = new VendorVO();
		vo.setVendorName(entity.getVendorName());
		vo.setAddress1(entity.getAddress1());
		vo.setAddress2(entity.getAddress2());
		vo.setCity(entity.getCity());
		vo.setEmail(entity.getEmail());
		vo.setFax(entity.getFax());
		vo.setPhone(entity.getPhone());
		vo.setState(entity.getState());
		vo.setStatus(entity.getStatus());
		vo.setVendorCode(entity.getVendorCode());
		vo.setZip(entity.getZip());
		vo.setPk(entity.getId());
		return vo;
	}

	public List<VendorVO> mapToVendorVO(final List<VendorEntity> entityList) {
		final List<VendorVO> result = new ArrayList<VendorVO>();
		for (VendorEntity entity : entityList) {
			result.add(mapToVendorVO(entity));
		}
		return result;

	}
}
