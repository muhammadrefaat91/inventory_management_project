package com.inventory.repository;

import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.Employee;

public interface EmployeeRepository extends BaseRepository<Employee>{

	boolean validateForUserWithUserNameAndPassword(Employee employee);

}
