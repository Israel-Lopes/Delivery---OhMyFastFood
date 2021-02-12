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

import com.ohmyfastfood.crm.model.UserModel;
import com.ohmyfastfood.crm.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<UserModel> list() {
		return userRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserModel addClient(@RequestBody UserModel client) {
		return userRepository.save(client);
	}

	@GetMapping("/{id}")
    public ResponseEntity<UserModel> getAUser(@PathVariable Long id) {
		UserModel userModel = userRepository.findById(id).get();
            return ResponseEntity.ok(userModel);
	}

	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable Long id,
	                             @RequestBody UserModel user) {
	   return userRepository.findById(id)
	       .map(record -> {
	    	   record.setName(user.getName());
	           record.setEmail(user.getEmail());
	           record.setAddress(user.getAddress());
	           record.setCpf(user.getCpf());
	           record.setTypePayment(user.getTypePayment());
	           UserModel updated = userRepository.save(record);
	           return ResponseEntity.ok().body(updated);
	       }).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <?> delete(@PathVariable Long id) {
			userRepository.findById(id);
	        userRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	}

}
