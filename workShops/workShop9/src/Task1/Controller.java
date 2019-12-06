//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 09
//Date: 2019-11-29
/////////////////////////////////////////
package com.senecacollege.workshop9.Task1;

// This class is for operating the questions in the stage
public class Controller {

    private static int random1;
    private static int random2;

    static int Operation(String get) { // This method executing the specified operations
        int correct = 0;// local variable
        int[] number = new int[4];// Creates the integer array.

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(get);

            if (number[0] == (random1 + random2)) { // Checking the first text field
                correct++;

            } else if (number[1] == (random1 - random2)) {// Checking the second text field
                correct++;

            } else if (number[2] == (random1 * random2)) {// Checking the third text field
                correct++;

            } else if (number[3] == (random1 / random2)) {// Checking the forth text field
                correct++;
            }

        }
        return correct;// Returning the integer correct
    }
}
