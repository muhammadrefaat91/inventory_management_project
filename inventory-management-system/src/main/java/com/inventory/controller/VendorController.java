package com.inventory.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.common.CommonUtils;
import com.inventory.common.VendorSearchCriteria;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.service.CompanyService;
import com.inventory.service.VendorService;
import com.inventory.service.DTO.CompanyDto;
import com.inventory.service.DTO.VendorDto;

/**
 * @author muhammadrefaat
 *
 */
@Controller
@RequestMapping("/vendor")
public class VendorController {

	private List<CompanyDto> companiesList;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private CompanyService companyService;
	
	
	
	@RequestMapping(value = "/add.htm",method = RequestMethod.GET)
	public String bindAddVendorForm(Map<String, Object> model) {
		companiesList = companyService.findAll();
		VendorDto vendor = new VendorDto();
		model.put("vendor", vendor);
		model.put("companiesList", companiesList);
		return "/vendor/add";
	}
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.GET)
	public String bindSearchVendorForm(Map<String, Object> model) throws JsonGenerationException, JsonMappingException, IOException {
		List<VendorDto> vendorList = vendorService.searh(null);
		if (!vendorList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			model.put("vendorList", mapper.writeValueAsString(vendorList));
		}
		model.put("vendorSearchCriteria", new VendorSearchCriteria());
		companiesList = companyService.findAll();
		model.put("companiesList", companiesList);
		return "/vendor/search";
	}
	
	
	/*
	 * This method will be called on add-vendor form submission, handling POST request It
	 * also validates the vendor data
	 */
	@RequestMapping(value = "/add.htm",method = RequestMethod.POST)
	public String saveVendor( @Valid @ModelAttribute("vendor") VendorDto vendor,
			BindingResult result, Map<String, Object> model, @RequestParam("file") MultipartFile file) {
		model.put("companiesList", companiesList);
		
		if (result.hasErrors()) {
			if (file.getSize() == 0) {
				result.rejectValue("logo", "error.logo", "Vendor Image is required");
			}
			return "/vendor/add";
		}
		try {
			vendor.setLogo(file.getBytes());
			vendorService.add(vendor);
			model.put("success", "Vendor Added successfully");
			model.put("vendor", new VendorDto());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeSystemException ex) {
			CommonUtils.handleException(ex, model);
		}
		
		return "/vendor/add";
	}
	

	
	
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.POST)
	public String searchVendors(@ModelAttribute("vendorSearchCriteria") VendorSearchCriteria searchCriteria,
			Map<String, Object> model) throws JsonGenerationException, JsonMappingException, IOException {
		model.put("companiesList", companiesList);
		List<VendorDto> vendorList = vendorService.searh(searchCriteria);
		if (!vendorList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			model.put("vendorList", mapper.writeValueAsString(vendorList));
		} else {
			model.put("noResults", "No Data Found Match You Search Criteria");
		}
		
		return "/vendor/search";
	}

}
