package com.coding.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.banking.enums.AccountType;
import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.Account;
import com.coding.banking.model.AccountDetails;
import com.coding.banking.repository.AccountDetailsRepository;
import com.coding.banking.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	
	public Account insert(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	public Account getById(int aid) throws InvalidIdException {
		Optional<Account> optional = accountRepository.findById(aid);
		if(!optional.isPresent()) {
			throw new InvalidIdException("account id invalid");
		}
		return optional.get();
	}

	public AccountType getByType(AccountType type)  {
		return accountRepository.findByType(type);
}



		
}
