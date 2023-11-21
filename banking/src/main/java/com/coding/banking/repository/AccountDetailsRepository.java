package com.coding.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.banking.model.AccountDetails;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer>{

}
