package com.inventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.JMapperBean;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.repository.EmployeeRepository;
import com.inventory.repository.entity.Employee;
import com.inventory.service.DTO.EmployeeDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultEmployeeService implements EmployeeService{

	@Autowired private EmployeeRepository employeeRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	@Transactional
	public void add(EmployeeDto employeeDto) {
		Employee employeeEntity = mapper.transformFromDestinationToSoure(Employee.class, employeeDto, EmployeeDto.class);
		validateUniqueForEmployeeName(employeeDto, employeeEntity);
		employeeRepository.add(employeeEntity);
	}
	
	
	private void validateUniqueForEmployeeName(EmployeeDto employeeDto, Employee employee) {
		boolean isEmployeeNameExist = employeeRepository.validateForUserWithUserNameAndPassword(employee);
		RuntimeSystemException exception = new RuntimeSystemException();
		if (isEmployeeNameExist) {
			exception.getFieldsMap().put("userName", "Employee User Name Is Already Exist!");
			throw exception;
		}
 
	}


}
