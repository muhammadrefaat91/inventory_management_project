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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.common.CommonUtils;
import com.inventory.common.ProductSearchCriteria;
import com.inventory.exception.RuntimeSystemException;
import com.inventory.service.ProductService;
import com.inventory.service.VendorService;
import com.inventory.service.DTO.ProductDto;
import com.inventory.service.DTO.VendorDto;

/**
 * @author muhammadrefaat
 *
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {

	private List<VendorDto> vendorList;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping(value = "/add.htm",method = RequestMethod.GET)
	public String bindAddProductForm(Map<String, Object> model) {
		vendorList = vendorService.findAll();
		ProductDto product = new ProductDto();
		model.put("product", product);
		model.put("vendorsList", vendorList);
		return "/inventory/add-product";
	}
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.GET)
	public String bindSearchProductForm(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		List<ProductDto> productList = productService.searh(null);
		vendorList = vendorService.findAll();
		model.addAttribute("vendorsList", vendorList);
		if (!productList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			model.addAttribute("productList", mapper.writeValueAsString(productList));
		}
		model.addAttribute("searchCriteria", new ProductSearchCriteria());
		return "/inventory/search-product";
	}
	
	
	/*
	 * This method will be called on add-product form submission, handling POST request It
	 * also validates the product data
	 */
	@RequestMapping(value = "/add.htm",method = RequestMethod.POST)
	public String saveProduct( @Valid @ModelAttribute("product") ProductDto product,
			BindingResult result, Map<String, Object> model, @RequestParam("file") MultipartFile file) {
		model.put("vendorsList", vendorList);
		
		if (result.hasErrors()) {
			if (file.getSize() == 0) {
				result.rejectValue("image", "error.image", "Product Image is required");
			}
			
			if(product.getVendorId() == 0) {
				result.rejectValue("vendorId", "error.vendorId", "Primary Vendor is required");
			}
			return "/inventory/add-product";
		}
		try {
			product.setImage(file.getBytes());
			productService.add(product);
			model.put("success", "product Added successfully");
			model.put("product", new ProductDto());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeSystemException ex) {
			CommonUtils.handleException(ex, model);
		}
		
		return "/inventory/add-product";
	}
	
	
	
	@RequestMapping(value = "/search.htm",method = RequestMethod.POST)
	public String searchProducts(@ModelAttribute("searchCriteria") ProductSearchCriteria searchCriteria,
		 Model model) throws JsonGenerationException, JsonMappingException, IOException {
		model.addAttribute("vendorsList", vendorList);
		List<ProductDto> productList = productService.searh(searchCriteria);
		if (!productList.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			model.addAttribute("productList", mapper.writeValueAsString(productList));
		} else {
			model.addAttribute("noResults", "No Data Found Match You Search Criteria");
		}
		
		return "/inventory/search-product";
	}

}
