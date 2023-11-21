package com.coding.banking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.Account;
import com.coding.banking.model.AccountDetails;
import com.coding.banking.model.AccountHolder;
import com.coding.banking.model.BankExecutive;
import com.coding.banking.service.AccountDetailsService;
import com.coding.banking.service.AccountHolderService;
import com.coding.banking.service.AccountService;
import com.coding.banking.service.BankExecutiveService;

@RestController
@RequestMapping("/bank")
public class AccountDetailsController {

	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountHolderService accountHolderService;
	
	
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@PostMapping("/accountdetails/add/{aid}/{bid}/{acid}") 
	public ResponseEntity<?> addAccountDetails(@PathVariable("aid") int aid,
											   @PathVariable ("bid") int bid,
											   @PathVariable ("acid") int acid,
											   @RequestBody AccountDetails accountDetails) {
		
		try {
			Account account = accountService.getById(aid);
			AccountHolder accountHolder = accountHolderService.getById(acid);
			BankExecutive bankExecutive = bankExecutiveService.getById(bid);
			
			accountDetails.setAccount(account);
			accountDetails.setAccountHolder(accountHolder);
			accountDetails.setBankExecutive(bankExecutive);
			accountDetails.setDateOfCreation(LocalDate.now());
			
			accountDetails = accountDetailsService.insert(accountDetails);
			return ResponseEntity.ok().body(accountDetails);
		} 
		catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
