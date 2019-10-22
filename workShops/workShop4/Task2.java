/*
Student Name: Amir Aminzadeh
Student Number: 126554187
Date: 2019-10-17
*/

package com.senecacollege.workshop4.Task2.java;

import java.io.File;// The File class from the java.io package, allows us to work with files
import java.io.FileInputStream;// It is used for reading data (streams of raw bytes) such as image data, audio, video etc
import java.io.FileNotFoundException;// It is used for error message
import java.io.IOException;// This exception is related to Input and Output operations in the Java code
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a file name: ");
		String fileName = input.next();// The specified file, we have a task.txt in our source file
		File file = new File(fileName);// Specifying the file as a file
		int[] AtoZCapital = new int[26];// Because of the 26 capital letters in English language
		int[] aTozSmall = new int[26];// Because of the 26 small letters in English language
		try {
			FileInputStream fis = new FileInputStream(file);// For reading the file
			Util.letterCounter(AtoZCapital, aTozSmall, fis);// Go to the letterCounter method
		} catch (FileNotFoundException e) {
			System.out.println("############################");
			System.out.println("You don't have this file");
			System.out.println("############################");
			System.out.println("###########################################################");
			System.out.println("Please, run again with typing a correct name file. Thanks");
			System.out.println("###########################################################");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < AtoZCapital.length; i++) {// This for loop counts each capital letter
			System.out.println("Number of " + (char) (i + 65) + "'s : " + AtoZCapital[i]);
		}
		for (int i = 0; i < aTozSmall.length; i++) {// This for loop counts each small letter
			System.out.println("Number of " + (char) (i + 97) + "'s : " + aTozSmall[i]);
		}
		input.close();
	}
}
