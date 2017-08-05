package com.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.CustomerSearchCriteria;
import com.inventory.common.JMapperBean;
import com.inventory.repository.CustomerRepository;
import com.inventory.repository.entity.Customer;
import com.inventory.service.DTO.CustomerDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultCustomerService implements CustomerService{

	@Autowired private CustomerRepository customerRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	@Transactional
	public void addCustomer(CustomerDto customerDto) {
		Customer customerEntity = mapper.transformFromDestinationToSoure(Customer.class, customerDto, CustomerDto.class);
		customerRepository.add(customerEntity);
	}

	@Override
	public List<CustomerDto> searh(CustomerSearchCriteria customerSearchCriteria) {
		List<Customer> customerListEntities = customerRepository.search(customerSearchCriteria);
		return mapper.transformList(CustomerDto.class, customerListEntities, Customer.class);
	}


}
