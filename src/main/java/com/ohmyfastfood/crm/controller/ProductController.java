package com.ohmyfastfood.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ohmyfastfood.crm.model.ProductModel;
import com.ohmyfastfood.crm.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<ProductModel> list() {
		return productRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductModel addProduct(@RequestBody ProductModel product) {
		return productRepository.save(product);
	}

	@GetMapping("/{id}")
    public ResponseEntity<ProductModel> getAProduct(@PathVariable Long id) {
		ProductModel productModel = productRepository.findById(id).get();
            return ResponseEntity.ok(productModel);
	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id,
	                             @RequestBody ProductModel product) {
				productRepository.findById(id);
				product.setName(product.getName());
				product.setPrice(product.getPrice());
				ProductModel updated = productRepository.save(product);
	           return ResponseEntity.ok().body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <?> delete(@PathVariable Long id) {
	   return productRepository.findById(id)
	           .map(record -> {
	        	   productRepository.deleteById(id);
	               return ResponseEntity.ok().build();
	           }).orElse(ResponseEntity.notFound().build());
	}

}
