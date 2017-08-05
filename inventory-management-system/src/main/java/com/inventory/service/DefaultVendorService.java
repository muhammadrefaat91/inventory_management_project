package com.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.JMapperBean;
import com.inventory.common.VendorSearchCriteria;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.repository.CompanyRepository;
import com.inventory.repository.VendorRepository;
import com.inventory.repository.entity.Company;
import com.inventory.repository.entity.Vendor;
import com.inventory.service.DTO.VendorDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultVendorService implements VendorService{

	@Autowired private VendorRepository vendorRepository;
	@Autowired private CompanyRepository companyRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	@Transactional
	public void add(VendorDto vendorDto) {
		validateUniquForNameOrCompany(vendorDto);
		Company company = companyRepository.findById(vendorDto.getCompanyId());
		Vendor vendorEntity = mapper.transformFromDestinationToSoure(Vendor.class, vendorDto, VendorDto.class);
		vendorEntity.setCompany(company);
		vendorRepository.add(vendorEntity);
	}
	
	private void validateUniquForNameOrCompany(VendorDto vendorDto) {
		boolean isCompanyWithVendor = companyRepository.isCompanyWithVendor(vendorDto.getCompanyId());
		Vendor vendor = vendorRepository.findVendorByName(vendorDto.getName());
		RuntimeSystemException exception = new RuntimeSystemException();
		if (isCompanyWithVendor) {
			exception.getFieldsMap().put("company", "Company Already Associated With Another Vendor");
		}
		if(vendor != null) {
			exception.getFieldsMap().put("name", "Vendor Name Is Already Exist!");
		}
		if (isCompanyWithVendor || vendor != null) {
			throw exception;
		}
	}

	@Override
	public List<VendorDto> searh(VendorSearchCriteria customerSearchCriteria) {
		List<Vendor> customerListEntities = vendorRepository.search(customerSearchCriteria);
		return mapper.transformList(VendorDto.class, customerListEntities, Vendor.class);
	}
	
	@Override
	public List<VendorDto> findAll() {
		List<Vendor> vendorsList = vendorRepository.findAll();
		return mapper.transformList(VendorDto.class, vendorsList, Vendor.class);
	}

	@Override
	public VendorDto findVendorByName(String name) {
		Vendor vendor = vendorRepository.findVendorByName(name);
		return mapper.transformFromDestinationToSoure(VendorDto.class, vendor, Vendor.class);
	}


}
