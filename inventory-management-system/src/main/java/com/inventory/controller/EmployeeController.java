package com.inventory.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inventory.common.CommonUtils;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.service.EmployeeService;
import com.inventory.service.DTO.CustomerDto;
import com.inventory.service.DTO.EmployeeDto;

/**
 * @author muhammadrefaat
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/add.htm",method = RequestMethod.GET)
	public String bindAddCutomerForm(Map<String, Object> model) {
		EmployeeDto employee = new EmployeeDto();
		model.put("employee", employee);
		return "/employee/add";
	}
	
	
	/*
	 * This method will be called on add-employee form submission, handling POST request It
	 * also validates the employee data
	 */
	@RequestMapping(value = "/add.htm",method = RequestMethod.POST)
	public String saveCustomer( @Valid @ModelAttribute("employee") EmployeeDto employee,
			BindingResult result, Map<String, Object> model) {

		if (result.hasErrors()) {
			return "/employee/add";
		}
		
		try {
			employeeService.add(employee);
			model.put("success", "Employee  " + employee.getUserName()
					+ " , Added Successfully");
			model.put("employee", new EmployeeDto());
		} catch (RuntimeSystemException ex) {
			CommonUtils.handleException(ex, model);
		}

		return "/employee/add";
	}
	


}