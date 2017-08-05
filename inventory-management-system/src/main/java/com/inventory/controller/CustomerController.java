package com.inventory.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inventory.common.CustomerSearchCriteria;
import com.inventory.service.CustomerService;
import com.inventory.service.DTO.CustomerDto;

/**
 * @author muhammadrefaat
 *
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/add.htm",method = RequestMethod.GET)
	public String bindAddCutomerForm(Map<String, Object> model) {
		CustomerDto customer = new CustomerDto();
		model.put("customer", customer);
		return "/customer/add";
	}
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.GET)
	public String bindSearchCutomerForm(Map<String, Object> model) throws JsonGenerationException, JsonMappingException, IOException {
		List<CustomerDto> customerList = customerService.searh(null);
		if (!customerList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			model.put("customerList", mapper.writeValueAsString(customerList));
		}
		
		model.put("searchCriteria", new CustomerSearchCriteria());
		return "/customer/search";
	}
	
	
	/*
	 * This method will be called on add-customer form submission, handling POST request It
	 * also validates the customer data
	 */
	@RequestMapping(value = "/add.htm",method = RequestMethod.POST)
	public String saveCustomer( @Valid @ModelAttribute("customer") CustomerDto customer,
			BindingResult result, Map<String, Object> model) {

		if (result.hasErrors()) {
			return "/customer/add";
		}
		customerService.addCustomer(customer);
		model.put("success", "Customer  " + customer.getFirstName()
				+ " , Added successfully");
		model.put("customer", new CustomerDto());
		return "/customer/add";
	}
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.POST)
	public String searchCustomers( @ModelAttribute("searchCriteria") CustomerSearchCriteria searchCriteria,
		 Map<String, Object> model) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<CustomerDto> customerList = customerService.searh(searchCriteria);
		if (!customerList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
	        model.put("customerList", mapper.writeValueAsString(customerList));
		} else {
			model.put("noResults", "No Data Found Match You Search Criteria");
		}
		
		return "/customer/search";
	}

}