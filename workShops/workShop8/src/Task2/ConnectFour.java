//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 08
//Date: 2019-11-22
/////////////////////////////////////////
package com.senecacollege.workshop8.Task2;

import java.util.HashSet;
import java.util.Set;

public class ConnectFour {

    private final int[][] board;// The board is besed on a 2D array for [row][column]
    private static final int row = 6;// The number of the rows
    private static final int column = 7;// The number of the columns
    private final int red = 1;// Placing the one number for red color
    private final int yellow = 2;// Placing the two number for yellow color

    // This constructor is made the empty board with specified size 
    public ConnectFour(Player playerOne, Player playerTwo) {// Type of Player is for playerOne and playerTwo
        this.board = new int[row][column];// Creating a new board with specifed size
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = -1; // For preventing the column be already full (empty board)
            }
        }
    }

    // Designing the board for disc red and yellow 
    public void gameBoard() {
        System.out.println("-------------");
        System.out.println(" 1 2 3 4 5 6 7");
        for (int i = 0; i < row; i++) {// This for-loop is for row
            for (int j = 0; j < column ; j++) {// This for-loop is for column
                if (board[i][j] == red) {// If the position is red
                    System.out.print("|R");
                } else if (board[i][j] == yellow) {// If the position is yellow
                    System.out.print("|Y");
                } else {
                    System.out.print("| ");// When the place are not both red or yellow
                }
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    // Placing the correct disc into each column
    public boolean moving(Player player, int column) {

        column--;//Decrement the column value by 1, as our array is zero indexed
        if (column < 0 || column >= ConnectFour.column) {//Check the column between 1 and 6
            System.out.println("Column choice must be between one and be no greater than 7!");
            return false;
        }
        if (isColumnFull(column)) {//Check if the column would be already full by isColumnFull
            System.out.println("The column is full!");
            return false;
        } else {
            for (int i = row - 1; i >= 0; i--) {// placing each move of each player on board
                if (board[i][column] == -1) {// For preventing from filling the each column completely
                    board[i][column] = player.getPlayerNumber();// filling the specified place for specified color
                    break;
                }
            }
            return true;
        }
    }

    // Checking the first row, when the first row is full, so returning false 
    // Just checking the column, when the column is minus 1 so the column is full
    private boolean isColumnFull(int columnNumber) {
        if (board[0][columnNumber] == -1) {// Checking the first row for each column
            return false;
        } else {
            return true;
        }
    }

    public int validateWinnerGame() {

        if (isBoardFull()) {// If the isBoardFull method returns false answer 
            System.out.println("The board is full!");
            return 0;
        }
        int checkRows = validateRows();// Checking each row for four sequential piecesHashSet of the same color
        int checkColumns = validateColumns();// Checking each column for four sequential piecesHashSet of the same color
        int checkDiagonals = validateDiagonals();// Checking each diagonal for four sequential piecesHashSet of the same color
        if (checkRows == 1 || checkColumns == 1 || checkDiagonals == 1) {// If player one wins
            return 1;
        } else if (checkRows == 2 || checkColumns == 2 || checkDiagonals == 2) {// If player two wins
            return 2;
        } else {// If nobody does not be win
            return -1;
        }
    }

    //Checking the board is full or not
    private boolean isBoardFull() {
        for (int i = 0; i < row; i++) {// This loop is for rows
            for (int j = 0; j < column; j++) {// This loop is for columns
                if (board[i][j] == -1) {// In this for-loops, if any value was out of board
                    return false;
                }
            }
        }
        return true;// Otherwise the board is full
    }

    // Checking each row for four sequential piecesHashSet of the same color
    private int validateRows() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column - 3; j++) {// The condition is "column - 3" because of checking 
                //the four sequential piecesHashSet
                Set<Integer> pieceHashSet = new HashSet<Integer>();// Creating a new HashSet that named pieceHashSet
                pieceHashSet.add(board[i][j]);// For example [0][1]
                pieceHashSet.add(board[i][j + 1]);// For example [0][2]
                pieceHashSet.add(board[i][j + 2]);// For example [0][3]
                pieceHashSet.add(board[i][j + 3]);// For example [0][4]
                if (pieceHashSet.size() == 1) {// Because the hash set do not allow duplicates
                    if (pieceHashSet.contains(red)) {
                        return red;// red color is the number 1 so it returns 1
                    } else if (pieceHashSet.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
            }
        }
        return -1;// Otherwise the validation of row is false, no player one and no player two
    }

    // Checking each column for four sequential piecesHashSet of the same color
    private int validateColumns() {

        for (int j = 0; j < column; j++) {
            for (int i = row - 1; i >= 3; i--) {// The condition is "i >= 3" because of checking 
                //==> 5, 4, 3, 2, 1, 0,and full column (6 rows==> from 5 to 0)
                Set<Integer> pieceHashSet = new HashSet<Integer>();// Creating a new HashSet that named pieceHashSet
                pieceHashSet.add(board[i][j]);// For example [5][0]
                pieceHashSet.add(board[i - 1][j]);// For example [4][0]
                pieceHashSet.add(board[i - 2][j]);// For example [3][0]
                pieceHashSet.add(board[i - 3][j]);// For example [2][0]
                if (pieceHashSet.size() == 1) {// Because the hash set do not allow duplicates
                    if (pieceHashSet.contains(red)) {
                        return red;// red color is the number 1 so it returns 1
                    } else if (pieceHashSet.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
            }
        }
        return -1;// Otherwise the validation of column is false, no player one and no player two
    }

    // Checking each diagonal for four sequential piecesHashSet of the same color
    private int validateDiagonals() {

        // This for-loop checks the four sequential of the same color from rigth to left 
        for (int i = 3; i < column; i++) {
            int j = 0; 
            int k = i;
            while (k - 3 >= 0 && j + 3 < row) {// when row is greater than 3 and column is greater than 3, check...
                Set<Integer> piecesHashSet = new HashSet<>();// Creating a new HashSet that named pieceHashSet
                piecesHashSet.add(board[j][k]);// For example, [0][3]           - - - x x x x
                piecesHashSet.add(board[j + 1][k - 1]);// For example, [1][2]   - - x x x x -
                piecesHashSet.add(board[j + 2][k - 2]);// For example, [2][1]   - x x x x - -
                piecesHashSet.add(board[j + 3][k - 3]);// For example, [3][0]   x x x x - - -
                                                                          //    x x x - - - -
                                                                          //    x x - - - - -
                if (piecesHashSet.size() == 1) {// Because the hash set do not allow duplicates
                    if (piecesHashSet.contains(red)) {
                        return red;// red color is the number 1 so it returns 1
                    } else if (piecesHashSet.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
                j++;// Increasing the j
                k--;// Decreasing the k
            }
        }
       
        // This for-loop checks the four sequential of the same color from rigth to left for rest of places
        for (int i = 1; i < 3; i++) {
            int j = i; 
            int k = column - 1;
            while (j + 3 < row && k - 3 >= 0) {
                Set<Integer> pieces = new HashSet<>();
                pieces.add(board[j][k]);// For example, [1][6]          - - - - - - -   
                pieces.add(board[j + 1][k - 1]);// For example, [2][5]  - - - - - - x
                pieces.add(board[j + 2][k - 2]);// For example, [3][4]  - - - - - x x
                pieces.add(board[j + 3][k - 3]);// For example, [4][3]  - - - - x x - 
                if (pieces.size() == 1) {                           //  - - - x x - - 
                    if (pieces.contains(red)) {                     //  - - x x - - - 
                        return red;// red color is the number 1 so it returns 1
                    } else if (pieces.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
                j++;
                k--;
            }
        }
       
        // This for-loop checks the four sequential of the same color from left to rigth
        for (int i = column - 4; i >= 0; i--) {
            int j = 0; 
            int k = i;
            while (j + 3 < row && k + 3 < column) {
                Set<Integer> pieces = new HashSet<>();
                pieces.add(board[j][k]);// For example, [0][3]           x x x x - - -
                pieces.add(board[j + 1][k + 1]);// For example, [1][4]   - x x x x - -
                pieces.add(board[j + 2][k + 2]);// For example, [2][5]   - - x x x x - 
                pieces.add(board[j + 3][k + 3]);// For example, [3][6]   - - - x x x x
                if (pieces.size() == 1) {                           //   - - - - x x x
                    if (pieces.contains(red)) {                     //   - - - - - x x 
                        return red;// red color is the number 1 so it returns 1
                    } else if (pieces.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
                j++;
                k++;
            }
        }
        
        // This for-loop checks the four sequential of the same color from left to rigth for rest of places
        for (int i = 1; i < 3; i++) {
            //validate each diagonal here
            int j = i;// set the row number to change with i;
            int k = 0;// before entering the while loop, begin at the first column(column 0);
            while (j + 3 < row && k + 3 < column) {
                Set<Integer> pieces = new HashSet<>();
                pieces.add(board[j][k]);//For example, [1][0]           - - - - - - -
                pieces.add(board[j + 1][k + 1]);//For example, [2][1]   x - - - - - -
                pieces.add(board[j + 2][k + 2]);//For example, [3][2]   x x - - - - -
                pieces.add(board[j + 3][k + 3]);//For example, [4][3]   - x x - - - - 
                if (pieces.size() == 1) {                           //  - - x x - - -
                    if (pieces.contains(red)) {                     //  - - - x x - -
                        return red;// red color is the number 1 so it returns 1
                    } else if (pieces.contains(yellow)) {
                        return yellow;// yellow color is the number 2 so it returns 2
                    }
                }
                j++;
                k++;
            }
        }
        return -1;// Otherwise the validation of diagonal is false, no player1 and no player2
    }

}
