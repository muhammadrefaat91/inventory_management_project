package com.inventory.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.JMapperBean;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.repository.EmployeeRepository;
import com.inventory.repository.UserRepository;
import com.inventory.repository.entity.Employee;
import com.inventory.repository.entity.User;
import com.inventory.service.DTO.EmployeeDto;
import com.inventory.service.DTO.UserDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultUserService implements UserService{

	@Autowired private UserRepository userRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	public void validateLoginForUserWithUserNameAndPassword(String userName, String password) {
		User user = userRepository.validateLoginForUserWithUserNameAndPassword(userName, password);
		if (user != null) {
			UserDto userDto = mapper.transformFromDestinationToSoure(UserDto.class, user, User.class);
		
		} else if (user == null) {
			RuntimeSystemException exception = new RuntimeSystemException();
			exception.getFieldsMap().put("userName", "Incorrect User Name and Password");
			throw exception;
		}
	}
	
	
	

}
