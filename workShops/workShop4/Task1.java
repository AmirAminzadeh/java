/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-17
*/

package com.senecacollege.workshop4.Task1.java;

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String numbers;
		boolean flag = true;
		do {// This do-while is for checking the specified pattern based on the number that
			// should be between 2 and 9 and also 7 digit numbers
			System.out.print("Please, enter 7 digits in within 2 to 9 : ");

			numbers = input.nextLine();// The input will be String
			String pattern = "[2-9]+";// Making the specified pattern
			boolean limitationOfNumbers = numbers.matches(pattern);// This statement return true if the matching be true
			boolean lengthOfNumbers = numbers.length() == 7;// This statement return true if the length be true

			if (limitationOfNumbers && lengthOfNumbers) {// this if condition is for checking the two condition in above
				flag = true;// If the flag be true, then going to outside of do-while
			} else {
				flag = false;// If the flag be false (the conditions was wrong). then the do-while executes
								// again
			}
		} while (!flag);

		Arrangement print = new Arrangement(numbers);// This statement invokes the constructor in Arrangement class that
														// the method sets the numbers with this.numbers
		print.print();// Calling the print method in Arrangement class for printing the numbers based
						// on its letters
		input.close();
	}

};
