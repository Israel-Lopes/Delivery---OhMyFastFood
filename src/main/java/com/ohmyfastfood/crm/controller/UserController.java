package com.ohmyfastfood.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

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
}
