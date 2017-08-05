package com.inventory.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.common.CustomerSearchCriteria;
import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.Customer;
import com.inventory.repository.entity.QCustomer;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class JpaCustomerRepository extends DefaultBaseRepository<Customer> implements CustomerRepository{

	@Override
	public EntityPath<Customer> getDefaultEntityPath() {
		return QCustomer.customer;
	}

	@Override
	public List<Customer> search(CustomerSearchCriteria searchCriteria) {
		QCustomer qCustomer = QCustomer.customer;
		BooleanBuilder whereBuilder = new BooleanBuilder();
		JPAQuery<Customer> query = getJpaQueryFactory().selectFrom(qCustomer);
		
		if (searchCriteria != null) {
			if (searchCriteria.getFirstName() != null && searchCriteria.getFirstName() != "") {
				whereBuilder.and(qCustomer.firstName.containsIgnoreCase(searchCriteria.getFirstName()));
			}
			
			if (searchCriteria.getLastName() != null && searchCriteria.getLastName() != "") {
				whereBuilder.and(qCustomer.lastName.containsIgnoreCase(searchCriteria.getLastName()));
			}
			
			if (searchCriteria.getMobile() != null  &&  searchCriteria.getMobile() != "") {
				whereBuilder.and(qCustomer.mobile.containsIgnoreCase(searchCriteria.getMobile()));
			}
			
			if (searchCriteria.getStatus() != null) {
				whereBuilder.and(qCustomer.status.eq(searchCriteria.getStatus()));
			}
		} else {
			query.limit(10);
		}
		
		query.where(whereBuilder);
		return query.fetch();
	}

}
