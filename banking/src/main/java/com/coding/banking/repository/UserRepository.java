package com.coding.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.banking.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
