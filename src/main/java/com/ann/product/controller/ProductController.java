package com.ann.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ann.product.entity.Product;
import com.ann.product.model.ProductRequest;
import com.ann.product.model.ProductResponse;
import com.ann.product.service.ProductService;

import jakarta.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products") 
	public ResponseEntity <List<Product>> getProducts(){
		List<Product> products = productService.getProducts();
		return new ResponseEntity <List<Product>>(products, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/products/{productId}") 
	public ResponseEntity getProduct(@PathVariable("productId") Long productId){
		Product product = new Product();
		String message = "Product Not found!";
		if(productId != null) {
			product = productService.getProduct(productId);
			if(product != null) {
			  return new ResponseEntity<Product>(product, HttpStatus.OK);
			}else {
				return new ResponseEntity(message, HttpStatus.OK);
			}
		}
		return new ResponseEntity("Product Invalid!", HttpStatus.OK);
		
		
	}
	
	@PostMapping("/create") 
	public ResponseEntity <String> createPoduct(@RequestBody ProductRequest productRequest){
		String message = productService.addProduct(productRequest);
		
		return new ResponseEntity<String>("Employee added Successflly!", HttpStatus.OK);
		
	}
	
	@PutMapping("/update") 
	public ResponseEntity <String> updatePoduct(@RequestBody ProductRequest productRequest){
		String message = productService.updateProduct(productRequest);
		
		return new ResponseEntity<String>("Employee updated Successflly!", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/remove/{productId}") 
	public ResponseEntity <String> deletePoduct(@PathVariable("productId") Long productId){
		if(productId != null) {
			String message = productService.deleteProduct(productId);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("ProductId Invalid", HttpStatus.OK);
		}
		
	}
}
