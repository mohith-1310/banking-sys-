package com.coding.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.banking.enums.AccountType;
import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.Account;
import com.coding.banking.model.AccountHolder;
import com.coding.banking.repository.AccountHolderRepository;

@Service
public class AccountHolderService {
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	public AccountHolder insert(AccountHolder accountHolder) {
		// TODO Auto-generated method stub
		return accountHolderRepository.save(accountHolder);
	}
	public AccountHolder getById(int acid) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(acid);
		if(!optional.isPresent()) {
			throw new InvalidIdException("account holder id invalid");
		}
		return optional.get();
	}
	
	public List<AccountHolder> getAll(Account type) {
		// TODO Auto-generated method stub
		return accountHolderRepository.findAll();
	}

}
