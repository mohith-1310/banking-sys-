package com.coding.banking.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.coding.banking.enums.AccountType;

public class AccountDto {
	@Enumerated(EnumType.STRING)
	private AccountType type;
	private double rateOfIntrest;
	private double balance;
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	public double getRateOfIntrest() {
		return rateOfIntrest;
	}
	public void setRateOfIntrest(double rateOfIntrest) {
		this.rateOfIntrest = rateOfIntrest;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
