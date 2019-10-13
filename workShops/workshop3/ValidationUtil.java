/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-11
*/

package com.senecacollege.workshop3.task1.java;

public class ValidationUtil {

	// This method for checking the each amount, if the amount was positive, so the
	// amount will be true
	public static boolean validAmount(double amount) {

		if (amount > 0)
			return true;
		return false;
	}

	// This method return the amount of rate in related with each year or months
	public static double validateAnnualRate(int term) {

		double rateYear;
		switch (term) {
		case 5:
			rateYear = 4.95;
			break;
		case 4:
			rateYear = 3.95;
			break;
		case 2:
			rateYear = 2.95;
			break;
		case 1:
			rateYear = 1.95;
			break;
		default:
			rateYear = 0.99;
		}
		return rateYear;

	}

}
