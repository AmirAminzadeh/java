/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-11
*/

package com.senecacollege.workshop3.task1.java;

// This class is Balance Account and also this class is extended from abstract Account class. I implemented the abstract methods here
public class BalanceAccount extends Account {

	// This constructor invokes the constructor of Account class
	public BalanceAccount() {
		super();
	}
	
	// This constructor invokes the constructor of Account class
	public BalanceAccount(int id, double balance) {
		super(id, balance);

	}

	@Override
	// Implementation of the abstract method in Account class. This method check the
	// amount based on being positive and being less than balance and reducing from
	// balance
	public boolean withdraw(double amount) {
		if (amount < getBalance() && amount > -1) {
			setBalance(getBalance() - amount);
			return true;
		}
		return false;
	}

	@Override
	// Implementation of the abstract method in Account class. This method check the
	// amount based on being positive and increasing to balance
	public boolean deposit(double amount) {
		if (amount > -1) {
			setBalance(getBalance() + amount);
			return true;
		}
		return false;

	}

}
