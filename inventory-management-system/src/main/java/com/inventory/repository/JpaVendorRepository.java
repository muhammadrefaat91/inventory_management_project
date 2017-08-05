package com.inventory.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.common.CommonUtils;
import com.inventory.common.VendorSearchCriteria;
import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.QVendor;
import com.inventory.repository.entity.Vendor;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class JpaVendorRepository extends DefaultBaseRepository<Vendor> implements VendorRepository{

	@Override
	public EntityPath<Vendor> getDefaultEntityPath() {
		return QVendor.vendor;
	}
	
	@Override
	public Vendor findVendorByName(String name) {
		QVendor qVendor = QVendor.vendor;
		JPAQuery<Vendor> query = getJpaQueryFactory().selectFrom(qVendor).where(qVendor.name.eq(name));
		return query.fetchOne();
	}


	@Override
	public List<Vendor> search(VendorSearchCriteria searchCriteria) {
		QVendor qVendor = QVendor.vendor;
		BooleanBuilder whereBuilder = new BooleanBuilder();
		JPAQuery<Vendor> query = getJpaQueryFactory().selectFrom(qVendor);
		
		if (searchCriteria != null) {
			if (!CommonUtils.isEmpty(searchCriteria.getName())) {
				whereBuilder.and(qVendor.name.containsIgnoreCase(searchCriteria.getName()));
			}
			
			if (!CommonUtils.isEmpty(searchCriteria.getCountry())) {
				whereBuilder.and(qVendor.country.eq(searchCriteria.getCountry()));
			}
			
			if (!CommonUtils.isEmpty(searchCriteria.getCity())) {
				whereBuilder.and(qVendor.city.eq(searchCriteria.getCity()));
			}
			
			if (searchCriteria.getStatus() != null) {
				whereBuilder.and(qVendor.status.eq(searchCriteria.getStatus()));
			}
			
			if (searchCriteria.getCompanyId() != 0) {
				whereBuilder.and(qVendor.company.id.eq(searchCriteria.getCompanyId()));
			}
		} else {
			query.limit(10);
		}
		
		query.where(whereBuilder);
		return query.fetch();
	}

}
