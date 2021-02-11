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

import com.ohmyfastfood.crm.model.CartModel;
import com.ohmyfastfood.crm.model.ProductModel;
import com.ohmyfastfood.crm.model.UserModel;
import com.ohmyfastfood.crm.repository.CartRepository;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartRepository cartRepository;

	@GetMapping
	public List<CartModel> list() {
		return cartRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CartModel addProduct(@RequestBody CartModel cart) {
		return cartRepository.save(cart);
	}

	@GetMapping("/{id}")
    public ResponseEntity<CartModel> detalhar(@PathVariable Long id) {
		CartModel cartModel = cartRepository.findById(id).get();
            return ResponseEntity.ok(cartModel);
	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id,
	                             @RequestBody CartModel cart) {
				cartRepository.findById(id);
				 cart.setUserModel(cart.getUserModel());
				 cart.setProductModel(cart.getProductModel());
				 //cart.setTypePayment(cart.getTypePayment());
				CartModel updated = cartRepository.save(cart);
	           return ResponseEntity.ok().body(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <?> delete(@PathVariable Long id) {
			cartRepository.findById(id);
	        cartRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	}

}
