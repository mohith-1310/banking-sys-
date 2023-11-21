package com.coding.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.banking.exception.InvalidIdException;
import com.coding.banking.model.BankExecutive;
import com.coding.banking.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {

	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive insert(BankExecutive executive) {
		// TODO Auto-generated method stub
		return bankExecutiveRepository.save(executive);
	}

	public BankExecutive getById(int bid) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<BankExecutive> optional = bankExecutiveRepository.findById(bid);
		if(!optional.isPresent()) {
			throw new InvalidIdException("executive id invalid");
		}
		return optional.get();
	}
	
	
	

}
