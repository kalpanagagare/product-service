package com.ann.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ann.product.entity.Product;
import com.ann.product.model.ProductRequest;
import com.ann.product.repository.ProductRepository;
import com.ann.product.util.ProductUtil;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository prodRepo;
	
	private ProductUtil productUtil;
	
	public Product getProduct(Long empId) {
		Optional<Product> product = prodRepo.findById(empId);
		if(product.isPresent()) {
			return product.get();
	    }else {
			return null;
	    }
	}
	
	public List<Product> getProducts() {
		List<Product> productList = prodRepo.findAll();
		if(productList == null)
			productList = new ArrayList<>();
		return productList;
	}
	
	public String addProduct(ProductRequest productRequest) {
		Product product = productUtil.convertToProduct(productRequest);
		Product addedProduct = prodRepo.save(product);
		return "Product Added Successfully";
	}
	
	public String deleteProduct(Long productId) {
		
		prodRepo.deleteById(productId);
		return "Product Deleted Successfully with id:"+productId;
	}
	
   public String updateProduct(ProductRequest productRequest) {
		
	    Product product = productUtil.convertToProduct(productRequest);
		Product updatedProduct = prodRepo.save(product);
		return "Product Updated Successfully with id :"+product.getProductId();
		
	}

}
