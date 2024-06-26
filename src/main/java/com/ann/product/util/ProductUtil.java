package com.ann.product.util;

import com.ann.product.entity.Product;
import com.ann.product.model.ProductRequest;

public class ProductUtil {
	
	public Product convertToProduct(ProductRequest productRequest) {
		
		Product product = new Product();
		product.setProductId(productRequest.getProductId());
		product.setProductName(productRequest.getProductName());
		product.setPrice(productRequest.getPrice());
		product.setDescription(productRequest.getDescription());
		return product;
		
	}

}
