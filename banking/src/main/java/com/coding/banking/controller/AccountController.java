package com.coding.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.banking.dto.AccountDto;
import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.Account;
import com.coding.banking.model.AccountHolder;
import com.coding.banking.service.AccountHolderService;
import com.coding.banking.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountHolderService accountHolderService;

	@PostMapping("/account/add")
	public Account addAccount(@RequestBody Account account) {

		account = accountService.insert(account);
		return account;

	}

	@PutMapping("/update/{acid}/{aid}")
	public ResponseEntity<?> updateBalance(@PathVariable("acid") int acid,
			                               @PathVariable ("aid") int aid,
											@RequestBody AccountDto newAccount) {
		try {
			AccountHolder accountHolder = accountHolderService.getById(acid);
		Account oldAccount = accountService.getById(aid);
		if (newAccount.getType() != null)
			oldAccount.setType(newAccount.getType());
		if (newAccount.getBalance() != 0)
			oldAccount.setBalance(newAccount.getBalance());
		if (newAccount.getRateOfIntrest() != 0)
			oldAccount.setRateOfIntrest(newAccount.getRateOfIntrest());
		oldAccount = accountService.insert(oldAccount);
		return ResponseEntity.ok().body(oldAccount);
	}
	catch(InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
}
