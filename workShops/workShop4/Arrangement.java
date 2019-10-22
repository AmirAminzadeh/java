/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-17
*/

package com.senecacollege.workshop4.Task1.java;

import java.io.File; // The File class from the java.io package, allows us to work with files
import java.io.FileWriter;// Java FileWriter class is used to write data to a file
import java.util.ArrayList;// Import the ArrayList class
import java.util.List;// Import the List class

public class Arrangement {

	String digits;
	// ArrayList( ) ==> This constructor builds an empty array list
	// An ArrayList grows its size automatically when new elements are added to it
	List<String> arrangmentList = new ArrayList<String>();// We can create a new ArrayList object
	final char[][] letters = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' }, { 'J', 'K', 'L' },
			{ 'M', 'N', 'O' }, { 'P', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y' } };

	// This method Setting the digit numbers with ==> String digits
	public Arrangement(String digits) {
		this.digits = digits;
	}

	
	
	
	// This method adding subcategories(the letters) of each number
	public List<String> getArrangmentFromDigits() {
		// toCharArray() => This method converts this string to a new character array
		// digits is String, So the String is got and is converted to char named
		// digitsChar
		char[] digitsChar = digits.toCharArray();

		arrangmentList.add("");// This add is for emptying the arrangementList for new writing

		for (char d : digitsChar) {
			List<String> next = new ArrayList<String>();// An ArrayList is a re-sizable array, also called a dynamic
														// array
			int realIndexLetters = d - '2'; // Because each char[][] letters are including 3 char, then with minus "2",
											// the char starts from first char

			for (String s : arrangmentList) {// s is the loop for the ArrayList that is empty (s is the numbers as a
												// string)
				for (char c : letters[realIndexLetters]) {// c is the loop for the letters from the first character
					next.add(s + c); // s + '0', s + '1', s + '2'
				}
			}
			// We can set them, because both of them are ArrayList<String>()
			arrangmentList = next;// Setting the next to arrangmentList
		}
		return arrangmentList;// return the arrangmentList
	}

	
	
	
	// This method for printing the letters into the file named task1
	public void print() {
		FileWriter fw;// This a variable for writing

		try {
			fw = new FileWriter(new File("task1.txt"));// Open the file for writing
			List<String> allLetters = getArrangmentFromDigits();// Setting the letters from the getArrangmentFromDigits
			// method to a list named allLetters

			for (String s : allLetters) {
				fw.write(s);
				fw.write(System.lineSeparator());// System.getProperty("line.separator") will give you the line
													// separator for your platform
			}
			System.out.println("All letters is written in the file called task1.txt");
			fw.close(); // This statement close the file and finish the writing
		} catch (Exception e) {// This catch executes for any error in part of try
			e.printStackTrace();
		}
	}

}
