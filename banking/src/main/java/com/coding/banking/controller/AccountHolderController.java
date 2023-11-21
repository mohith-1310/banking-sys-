package com.coding.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.banking.enums.AccountType;
import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.Account;
import com.coding.banking.model.AccountHolder;
import com.coding.banking.service.AccountHolderService;
import com.coding.banking.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountHolderController {
	@Autowired
	private AccountHolderService accountHolderService;
	
	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/accountholder/add")
	public AccountHolder addAccHolder(@RequestBody AccountHolder accountHolder) {
		
		accountHolder = accountHolderService.insert(accountHolder);
		return accountHolder;
		
	}
	
	@GetMapping("/accountholder/getall/{type}")
	public List getAll(@PathVariable("type") Account type) {
		
			List<AccountHolder> list = accountHolderService.getAll(type);
			return list;
	}

		
		
		
	}

