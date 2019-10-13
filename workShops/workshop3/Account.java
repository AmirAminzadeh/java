/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-11
*/

package com.senecacollege.workshop3.task1.java;

//This class library encapsulates the current date and time.
import java.util.Date;

//it is a abstract class with two abstract method, one method for withdraw and other method for deposit method 
public abstract class Account {

	//id, balance, annualInterestRate are fields of Account class
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;

	//A abstract method for withdraw that it implement in both of BalanceAccount.java and LoanAccount.java
	public abstract boolean withdraw(double amount);
	//A abstract method for deposit that it implement in both of BalanceAccount.java and LoanAccount.java
	public abstract boolean deposit(double amount);

	
	//Constructor for Account class
	public Account() {

	}

	//A constructor with two entity
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	// The accessory and mutator methods for id, balance, and annualInterestRate.
	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	// mutator or setter for field of balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// accessory or getter for field of balance
	public double getBalance() {
		return balance;
	}

	// mutator or setter for field of annualInterestRate
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	// mutator or setter for field of annualInterestRate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	//The calculate of monthly interest rate 
	public double getMonthlyInterestRate() {
		return (annualInterestRate / 100) / 12;
	}

	//accessory or getter for monthly interest
	public double getMonthlyInterest() {
		return balance * getMonthlyInterestRate();
	}

	//accessory or getter for field of date
	public Date getDateCreated() {
		return dateCreated;
	}

}
