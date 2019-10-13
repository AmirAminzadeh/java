/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-11
*/

package com.senecacollege.workshop3.task1.java;

import java.text.DecimalFormat;//format
import java.util.Date;//date
import java.util.Scanner;//input

public class AccountConsole {

	public static int term[] = new int[10];// This statement is defined for different term such as year and months

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);// This statement for inputting
		Account[] account = new Account[10];// This statement is for at least 10 person
		int i = 0;
		boolean flag = true;
		String continueStop = "y"; // This variable is for do-while all program, checking the "y" or "n"
		do {// This do-while is for inputting the id
			System.out.print("Enter your id account: ");
			int numberID = input.nextInt();

			String accountType;
			do {// This do-while is for checking the balance account or the loan account

				System.out.print("Please, choose your account balance or loan==> (Enter b/l) : ");
				accountType = input.next();

			} while (!(accountType.equalsIgnoreCase("b") || accountType.equalsIgnoreCase("l")));

			do {// This do-while is for checking the positive amount for balance account or loan
				// account
				if (flag) {
					System.out.print("Enter your balance: ");
				} else {
					System.out.print("Enter positive number, please: ==> ");
				}
				double balance = input.nextDouble();
				if (ValidationUtil.validAmount(balance) != true) {
					flag = false;

				} else {
					flag = true;
					if (accountType.equalsIgnoreCase("b")) {// If the balance account, the amount enters the balance
															// account
						account[i] = new BalanceAccount(numberID, balance);
					} else if (accountType.equalsIgnoreCase("l")) {// If the loan account, the amount enters the loan
																	// account
						account[i] = new LoanAccount(numberID, balance);
					}
				}
			} while (!flag);

			flag = true;
			do {// This do-while for checking the terms
				System.out.print("\r\n" + "For accounting annual interest rate follow this instruction:  \r\n"
						+ "enter 1, 2, 4, 5 for years and \r\n" + "6 for below 6 months : ==>");

				term[i] = input.nextInt();
				if (term[i] == 1 || term[i] == 2 || term[i] == 4 || term[i] == 5 || term[i] == 6) {

					double rate = ValidationUtil.validateAnnualRate(term[i]);

					account[i].setAnnualInterestRate(rate);
					flag = true;
				} else {
					flag = false;
					System.out.print("Please enter the numbers auch as 1, 2, 4, 5 years or 6 for below 6 months: ");
				}

			} while (!flag);

			flag = true;
			do {// this do-while is for entering the withdraw and checking the positive number

				System.out.print("Please enter positive amount of your withdraw: (Positive Number)==> ");
				double withdraw = input.nextDouble();
				if (ValidationUtil.validAmount(withdraw) != true) {
					flag = false;
				} else {
					account[i].withdraw(withdraw);
					flag = true;

				}
			} while (!flag);

			do {// this do-while is for entering the deposit and checking the positive number
				System.out.print("Please enter positive amount of your deposit: (Positive Number)==> ");
				double deposit = input.nextDouble();
				if (ValidationUtil.validAmount(deposit) != true) {
					flag = false;
				} else {
					flag = true;
					account[i].deposit(deposit);
				}
			} while (!flag);

			System.out.print("Do you want to continue? (y/n) ");
			continueStop = input.next();// for getting the yes or number for continuing id or account
			i++;
			System.out.println("****************************************");
		} while (continueStop.equalsIgnoreCase("y"));// when the string is No "n" , so go out
		for (int j = 0; j < i; j++) {
			DecimalFormat df = new DecimalFormat("0.00");// checking the format number until two decimal
			System.out.println("#########################################");
			System.out.println("USER INFORMATION " + (j + 1));
			// getClass returns a Class object that represents the object's class. getName
			// then returns the name of that class as a string
			if (account[j].getClass().getName().equals(BalanceAccount.class.getName())) {
				System.out.println("Your Account Type Balance Account");
				// getClass returns a Class object that represents the object's class. getName
				// then returns the name of that class as a string
			} else if (account[j].getClass().getName().equals(LoanAccount.class.getName())) {
				System.out.println("Your Account Type Loan Account");

			}
			System.out.println("User ID: " + account[j].getID());
			System.out.println("New Balance: $" + account[j].getBalance());
			System.out.print("Monthly Interest is " + df.format(account[j].getMonthlyInterest()) + " for ");
			if (term[j] == 6) {
				System.out.println((term[j]) + " months");
			} else {
				System.out.println((term[j] * 12) + " months");

			}
			Date dateCreated = new Date();// set the dateCreated in the constructor of Account , to capture when it was
											// created
			System.out.println("Account date created on: " + dateCreated.toString());
		}
	}

}
