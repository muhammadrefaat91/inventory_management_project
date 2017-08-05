package com.inventory.repository;

import java.util.List;

import com.inventory.common.VendorSearchCriteria;
import com.inventory.repository.config.BaseRepository;
import com.inventory.repository.entity.Vendor;

public interface VendorRepository extends BaseRepository<Vendor>{

	/** search for vendors
	 * @param customerSearchCriteria
	 * @return
	 */
	List<Vendor> search(VendorSearchCriteria searchCriteria);

	/** find Vendor By Name
	 * @param name
	 * @return
	 */
	Vendor findVendorByName(String name);

}
