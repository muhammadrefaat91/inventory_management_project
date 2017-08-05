package com.inventory.controller;


import java.io.IOException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.common.CommonUtils;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.service.CompanyService;
import com.inventory.service.DTO.CompanyDto;

/**
 * @author muhammadrefaat
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value = "/add.htm",method = RequestMethod.GET)
	public String bindAddCutomerForm(Map<String, Object> model) {
		CompanyDto company = new CompanyDto();
		model.put("company", company);
		return "/add-company";
	}
	 
	
	
	/*
	 * This method will be called on add-company form submission, handling POST request It
	 * also validates the company data
	 */
	@RequestMapping(value = "/add.htm",method = RequestMethod.POST)
	public String saveCompany( @Valid @ModelAttribute("company") CompanyDto companyDto,
			BindingResult result, Map<String, Object> model, @RequestParam("file") MultipartFile file) {

		if (result.hasErrors()) {
			return "/add-company";
		}
		try {
			companyDto.setLogo(file.getBytes());
			companyService.add(companyDto);
			model.put("success", "Company  " + companyDto.getName()+ " , Added successfully");
			model.put("company", new CompanyDto());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeSystemException ex) {
			CommonUtils.handleException(ex, model);
		}
		
		return "/add-company";
	}
	

}