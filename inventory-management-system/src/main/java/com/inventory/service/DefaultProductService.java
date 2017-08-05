package com.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.JMapperBean;
import com.inventory.common.ProductSearchCriteria;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.repository.ProductRepository;
import com.inventory.repository.VendorRepository;
import com.inventory.repository.entity.Product;
import com.inventory.repository.entity.Vendor;
import com.inventory.service.DTO.ProductDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultProductService implements ProductService{

	@Autowired private ProductRepository productRepository;
	@Autowired private VendorRepository vendorRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	@Transactional
	public void add(ProductDto productDto) {
		Product product = productRepository.findProductByName(productDto.getName());
		if(product != null) {
			RuntimeSystemException exception = new RuntimeSystemException();
			exception.getFieldsMap().put("name", "Product Name Is Already Exist!");
			throw exception;
		}
		Vendor vendor = vendorRepository.findById(productDto.getVendorId());
		Product productEntity = mapper.transformFromDestinationToSoure(Product.class, productDto, ProductDto.class);
		productEntity.setVendor(vendor);
		productRepository.add(productEntity);
	}

	@Override
	public List<ProductDto> searh(ProductSearchCriteria customerSearchCriteria) {
		List<Product> customerListEntities = productRepository.search(customerSearchCriteria);
		return mapper.transformList(ProductDto.class, customerListEntities, Product.class);
	}
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}


}
