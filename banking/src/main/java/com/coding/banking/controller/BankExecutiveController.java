package com.coding.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.banking.model.BankExecutive;
import com.coding.banking.model.User;
import com.coding.banking.service.BankExecutiveService;
import com.coding.banking.service.UserService;

@RestController
@RequestMapping("/bank")
public class BankExecutiveController {

	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/executive/add")
	public BankExecutive addExecutive(@RequestBody BankExecutive executive) {
		
		User user = executive.getUser();
		user.setRole("EXECUTIVE");
		user = userService.insert(user);
		
		executive.setUser(user);
		return bankExecutiveService.insert(executive);
	}
}
