package com.cubics.im.service.product;

import java.util.List;

public interface ProductService {

	ProductVO createProduct(final ProductVO vo);

	void updateProduct(final ProductVO vo);

	void activateProduct(final Long id);

	void deactivateProduct(final Long id);

	ProductVO addProduct(final String code, final Long quantity);

	ProductVO findByCode(final String code);
	ProductVO findByID(final Long id);

	List<ProductVO> searchActiveProduct();

	boolean isDuplicate(String code, String name);
}
