package com.inventory.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventory.common.CommonUtils;
import com.inventory.common.ProductSearchCriteria;
import com.inventory.repository.config.DefaultBaseRepository;
import com.inventory.repository.entity.Product;
import com.inventory.repository.entity.QProduct;
import com.inventory.repository.entity.QVendor;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.EntityPath;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class JpaProductRepository extends DefaultBaseRepository<Product> implements ProductRepository{

	@Override
	public EntityPath<Product> getDefaultEntityPath() {
		return QProduct.product;
	}
	
	@Override
	public Product findProductByName(String name) {
		QProduct qProduct = QProduct.product;
		JPAQuery<Product> query = getJpaQueryFactory().selectFrom(qProduct).where(qProduct.name.eq(name));
		return query.fetchOne();
	}
	
	@Override
	public boolean isProductHasVendor(int vendorId) {
		QVendor qVendor = QVendor.vendor;
		QProduct qProduct = QProduct.product;
		long count = getJpaQueryFactory().selectFrom(qProduct)
					.innerJoin(qProduct.vendor, qVendor)
					.where(qVendor.id.eq(vendorId)).fetchCount();
		return count !=0;
	}

	@Override
	public List<Product> search(ProductSearchCriteria searchCriteria) {
		QProduct qProduct = QProduct.product;
		BooleanBuilder whereBuilder = new BooleanBuilder();
		JPAQuery<Product> query = getJpaQueryFactory().selectFrom(qProduct);
		
		if (searchCriteria != null) {
			if (!CommonUtils.isEmpty(searchCriteria.getName())) {
				whereBuilder.and(qProduct.name.containsIgnoreCase(searchCriteria.getName()));
			}
			
			if (!CommonUtils.isEmpty(searchCriteria.getBarCode())) {
				whereBuilder.and(qProduct.barCode.containsIgnoreCase(searchCriteria.getBarCode()));
			}
			
			if (searchCriteria.getQuantity() != 0) {
				whereBuilder.and(qProduct.quantity.eq(searchCriteria.getQuantity()));
			}
			
			if (searchCriteria.getVendorId() != 0) {
				whereBuilder.and(qProduct.vendor.id.eq(searchCriteria.getVendorId()));
			}
			
			if (searchCriteria.getStatus() != null) {
				whereBuilder.and(qProduct.status.eq(searchCriteria.getStatus()));
			}
		} else {
			query.limit(10);
		}
		
		query.where(whereBuilder);
		return query.fetch();
	}

}
