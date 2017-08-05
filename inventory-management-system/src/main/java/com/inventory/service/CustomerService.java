package com.inventory.service;

import java.util.List;

import com.inventory.common.CustomerSearchCriteria;
import com.inventory.service.DTO.CustomerDto;


/**
 * @author muhammadrefaat
 *
 */
public interface CustomerService {

	/**
	 * add new customer
	 * 
	 * @param customerDto
	 */
	void addCustomer(CustomerDto customerDto);
	
	/** search for customers by some criteria 
	 * 
	 * @param customerSearchCriteria
	 * @return 
	 */
	List<CustomerDto> searh(CustomerSearchCriteria customerSearchCriteria);


}
