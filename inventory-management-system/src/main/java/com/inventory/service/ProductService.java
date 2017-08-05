package com.inventory.service;

import java.util.List;

import com.inventory.common.ProductSearchCriteria;
import com.inventory.repository.entity.Product;
import com.inventory.service.DTO.ProductDto;


/**
 * @author muhammadrefaat
 *
 */
public interface ProductService {

	/**
	 * add new Product
	 * 
	 * @param ProductDto
	 */
	void add(ProductDto vendorDto);
	
	/** search for Products by some criteria 
	 * 
	 * @param searchCriteria
	 * @return 
	 */
	List<ProductDto> searh(ProductSearchCriteria searchCriteria);

	/** Find All Products
	 * @return
	 */
	List<Product> findAll();


}
