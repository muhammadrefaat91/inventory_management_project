package com.inventory.repository;

import org.springframework.stereotype.Repository;

import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.Company;
import com.inventory.repository.entity.QCompany;
import com.inventory.repository.entity.QVendor;
import com.querydsl.core.types.EntityPath;

@Repository
public class JpaCompanyRepository extends DefaultBaseRepository<Company> implements CompanyRepository{

	@Override
	public EntityPath<Company> getDefaultEntityPath() {
		return QCompany.company;
	}
	
	@Override
	public boolean validateUniqueForCompayName(Company company) {
		QCompany qCompany = QCompany.company;
		long count = getJpaQueryFactory().selectFrom(qCompany)
							.where(qCompany.name.eq(company.getName()))
							.fetchCount();
		return count !=0;
	}

	
	@Override
	public boolean isCompanyWithVendor(int companyId) {
		QVendor qVendor = QVendor.vendor;
		QCompany qCompany = QCompany.company;
		long count = getJpaQueryFactory().selectFrom(qVendor)
					.innerJoin(qVendor.company, qCompany)
					.where(qCompany.id.eq(companyId)).fetchCount();
		return count !=0;
	}

}
