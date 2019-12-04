//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 08
//Date: 2019-11-22
/////////////////////////////////////////
package com.senecacollege.workshop8.Task1;

import java.util.Scanner;

public class Task1 {

    /*
     *@Functional Interface
     */
    // A functional interface is an interface that contains only one abstract method.
    public interface ArrayProcessor {

        double apply(double[] array);
    }

    //This function should return an ArrayProcessor that counts the number of times 
    //that value occurs in an array. The return value should be given as a lambda expression.
    public static ArrayProcessor counter(double value) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value) {
                    count++;
                }
            }
            return count;
        };
    }

    // Finding the maximum value in the array
    public static ArrayProcessor maximum = array -> {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {// Comparing the numbers with together in this loop
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    };

    // Finding the minimum value in the array
    public static ArrayProcessor minimum = array -> {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {// Comparing the numbers with together in this loop
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    };

    // Finding the sum of value in the array
    public static ArrayProcessor sum = array -> {
        double total = 0;
        for (int i = 0; i < array.length; i++) {// Summing the numbers with together in this loop
            total += array[i];
        }
        return total;
    };

    // Finding the average value in the array
    public static ArrayProcessor average = array -> sum.apply(array) / array.length;

    // This is the main method
    public static void main(String[] args) {

        System.out.print("How many numbers you want to enter? ");// Printing
        Scanner scanner = new Scanner(System.in);// Scanning the numbers
        int n = scanner.nextInt();// n is the number of the our inputs

        double[] firstList = new double[n];// Creating the array with n size

        for (int i = 0; i < firstList.length; i++) {// This for loop is for getting the number 
            //and putting them to the array 
            System.out.print("Enter Element No." + (i + 1) + ": ");
            firstList[i] = scanner.nextDouble();
        }

        System.out.println("Maximum of the list with " + n + " numbers : "
                + maximum.apply(firstList));// Invoking the maximum method for the created array list
        System.out.println("Minimum of the list with " + n + " numbers : "
                + minimum.apply(firstList));// Invoking the minimum method for the created array list
        System.out.println("Sum of the list with " + n + " numbers : "
                + sum.apply(firstList));// Invoking the sum method for the created array list
        System.out.println("Average of the list with " + n + " numbers : "
                + average.apply(firstList));// Invoking the average method for the created array list
        for (int i = 0; i <= n; i++) {
            try{// This try-catch is handled the thread exception
            System.out.println("Counting the No." + (i + 1) + " in the array: "
                    + counter(firstList[i]).apply(firstList) + " times");//Invoking the counter method for 
                                                                         //the first index of array list
            }catch(Exception e){
                System.out.println("The final of execution!");
            }
        }
        System.out.println();

    }

}
