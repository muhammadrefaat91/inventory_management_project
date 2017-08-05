package com.inventory.repository;

import java.util.List;

import com.inventory.common.CustomerSearchCriteria;
import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.Customer;

public interface CustomerRepository extends BaseRepository<Customer>{

	/** search for customers
	 * @param customerSearchCriteria
	 * @return
	 */
	List<Customer> search(CustomerSearchCriteria customerSearchCriteria);

}
