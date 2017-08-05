package com.inventory.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.common.JMapperBean;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.repository.CompanyRepository;
import com.inventory.repository.entity.Company;
import com.inventory.service.DTO.CompanyDto;

/**
 * @author muhammadrefaat
 *
 */
@Service
public class DefaultCompanyService implements CompanyService{

	@Autowired private CompanyRepository companyRepository;
	@Autowired private JMapperBean mapper;
	
	
	@Override
	@Transactional
	public void add(CompanyDto companyDto) {
		Company company = mapper.transformFromDestinationToSoure(Company.class, companyDto, CompanyDto.class);
		validateUniqueForCompanyName(companyDto,company);
		companyRepository.add(company);
	}
	
	public void validateUniqueForCompanyName(CompanyDto companyDto, Company company) {
		boolean isCompanyNameExist = companyRepository.validateUniqueForCompayName(company);
		RuntimeSystemException exception = new RuntimeSystemException();
		if (isCompanyNameExist) {
			exception.getFieldsMap().put("name", "Comapny Name Is Already Exist!");
			throw exception;
		}
 
	}

	
	@Override
	public List<CompanyDto> findAll() {
		return mapper.transformList(CompanyDto.class, companyRepository.findAll(), Company.class);
	}
	
	@Override
	public CompanyDto findById(int id) {
		return mapper.transformFromDestinationToSoure(CompanyDto.class, companyRepository.findById(id), Company.class);
	}


}
