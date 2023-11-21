package com.coding.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coding.banking.enums.AccountType;
import com.coding.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

	@Query("select a from Account a where a.type =?1")
	AccountType findByType(AccountType type);

}
