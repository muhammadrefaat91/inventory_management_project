package com.inventory.common;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventory.service.CompanyService;
import com.inventory.service.DTO.CompanyDto;

@Component
public class CompanyFormatter implements Formatter<CompanyDto>{

	@Autowired
	private CompanyService companyService;
	
	@Override
	public String print(CompanyDto arg0, Locale arg1) {
		return arg0.getName().toString();
	}

	@Override
	public CompanyDto parse(String arg0, Locale arg1) throws ParseException {
		return companyService.findById(Integer.parseInt(arg0));
	}

}
