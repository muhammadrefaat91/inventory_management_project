package com.inventory.repository;

import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.Company;

public interface CompanyRepository extends BaseRepository<Company>{

	boolean isCompanyWithVendor(int companyId);

	boolean validateUniqueForCompayName(Company company);


}
