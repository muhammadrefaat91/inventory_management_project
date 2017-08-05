package com.inventory.service;

import java.util.List;

import com.inventory.common.VendorSearchCriteria;
import com.inventory.service.DTO.VendorDto;


/**
 * @author muhammadrefaat
 *
 */
public interface VendorService {

	/**
	 * add new Vendor
	 * 
	 * @param vendorDto
	 */
	void add(VendorDto vendorDto);
	
	/** search for Vendors by some criteria 
	 * 
	 * @param searchCriteria
	 * @return 
	 */
	List<VendorDto> searh(VendorSearchCriteria searchCriteria);

	/** Find All Vendors
	 * @return
	 */
	List<VendorDto> findAll();
	
	/** find Vendor By Name
	 * @param name
	 * @return
	 */
	VendorDto findVendorByName(String name);


}
