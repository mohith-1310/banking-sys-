package com.coding.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.AccountDetails;
import com.coding.banking.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;
	public AccountDetails insert(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}
	public AccountDetails getById(int acid) throws InvalidIdException {
		// TODO Auto-generated method stub
	Optional<AccountDetails> optional = accountDetailsRepository.findById(acid);
	if(!optional.isPresent()) {
		throw new InvalidIdException("account holder id invalid");
	}
	return optional.get();
	}

}
