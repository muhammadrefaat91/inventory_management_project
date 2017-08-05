package com.inventory.service;

import java.util.List;

import com.inventory.service.DTO.CompanyDto;


/**
 * @author muhammadrefaat
 *
 */
public interface CompanyService {

	/**
	 * add new Company
	 * 
	 * @param vendorDto
	 */
	void add(CompanyDto companyDto);

	/** Find All Companies
	 * @return
	 */
	List<CompanyDto> findAll();

	/** find company by id
	 * @param id
	 * @return
	 */
	CompanyDto findById(int id);



}
