package com.coding.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.banking.model.AccountHolder;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Integer>{

}
