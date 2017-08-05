package com.inventory.repository;

import org.springframework.stereotype.Repository;

import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.Employee;
import com.inventory.repository.entity.QEmployee;
import com.querydsl.core.types.EntityPath;

@Repository
public class JpaEmployeeRepository extends DefaultBaseRepository<Employee> implements EmployeeRepository{

	@Override
	public EntityPath<Employee> getDefaultEntityPath() {
		return QEmployee.employee;
	}
	
	@Override
	public boolean validateForUserWithUserNameAndPassword(Employee employee) {
		QEmployee qEmployee = QEmployee.employee;
		long count = getJpaQueryFactory().selectFrom(qEmployee)
							.where(qEmployee.userName.eq(employee.getUserName()))
							.fetchCount();
		return count !=0;
	}

}
