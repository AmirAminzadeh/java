//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 08
//Date: 2019-11-22
/////////////////////////////////////////
package com.senecacollege.workshop8.Task2;

import java.util.Scanner;

public class TesterClass {

    // This field of scanner is used for different scan in main class
    // For preventing from writing several times this statement in main method
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**********I think that you are ready for an interesting competition********** ");
        System.out.print("***First Player ==> Enter your name: ");
        String player1Name = scanner.nextLine();// Getting the name of player1 and set to a string that named player1Name
        System.out.print("***Second Player ==> Enter your name: ");
        String player2Name = scanner.nextLine();// Getting the name of player2 and set to a string that named player2Name

        Player playerOne = new Player(player1Name);// Creating new object from player class for player1's name
        Player playerTwo = new Player(player2Name);// Creating new object from player class for player2's name
        
        System.out.println(playerOne.getName() + " will be R ==> RED");// Taking the playerOne name from getName() 
                                                                       //method of Player class
        System.out.println(playerTwo.getName() + " will be Y ==> YELLOW");// Taking the playerTwo name from getName()
                                                                          //method of Player class
        ConnectFour connectFour = new ConnectFour(playerOne, playerTwo);// Creating a new connectFour class
        connectFour.gameBoard();// Calling the gameBoard method
        
        System.out.println("\n");
        boolean flag = false;
        while (flag == false) {
            System.out.println(playerOne.getName() + ", Drop a RED disc at column (1-7): ");
            int move = scanner.nextInt();// Getting the number of column
            while (connectFour.moving(playerOne, move) == false) {// Checking the number by moving method
                System.out.println("Please try again: ");
                move = scanner.nextInt();// Getting the number of column again if the number was less than 1 or greater than 6
            }
            connectFour.gameBoard();// Invoking the gameBoard method again for showing the updated board
            int winner = connectFour.validateWinnerGame();// For identification of winner, will call the validateWinnerGame 
            gameWinner(winner);// Checking the winner by gameWinner method
            if (winner != -1) {
                flag = false;
                break;
            }
            System.out.println(playerTwo.getName() + ", Drop a YELLOW disc at column (1-7): ");
            move = scanner.nextInt();// Getting the number of column
            while (connectFour.moving(playerTwo, move) == false) {// Checking the number by moving method
                System.out.println("Please try again: ");
                move = scanner.nextInt();// Getting the number of column again if the number was less than 1 or greater than 6
            }
            connectFour.gameBoard();// Invoking the gameBoard method again for showing the updated board
            winner = connectFour.validateWinnerGame();// For identification of winner, will call the validateWinnerGame
            gameWinner(winner);// Checking the winner by gameWinner method
            if (winner != -1) {
                flag = false;
                break;
            }
        }
    }

    //This method prints the winner based on this statement ==>connectFour.validateWinnerGame()==>(Return 0, 1, 2,or nothing
    private static void gameWinner(int winner) {
        if (winner == 0) { 
            System.out.println("The board was full and there is not any winner!");
        } else if (winner == 1) {
            System.out.println("The red player won");
        } else if (winner == 2) {
            System.out.println("The yellow player won");
        } else {
            System.out.println("Who will be the winner!\n");
        }
    }
}
