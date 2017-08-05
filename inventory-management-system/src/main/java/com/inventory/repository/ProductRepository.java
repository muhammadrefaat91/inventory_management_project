package com.inventory.repository;

import java.util.List;

import com.inventory.common.ProductSearchCriteria;
import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.Product;

public interface ProductRepository extends BaseRepository<Product>{

	/** search for products
	 * @param productSearchCriteria
	 * @return
	 */
	List<Product> search(ProductSearchCriteria searchCriteria);

	boolean isProductHasVendor(int vendorId);

	Product findProductByName(String name);

}
