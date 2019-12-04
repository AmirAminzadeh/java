//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 08
//Date: 2019-11-22
/////////////////////////////////////////
package com.senecacollege.workshop8.Task2;

public class Player {// This class for getting name and player number

    private final String name;
    private static int counter = 0;
    private int playerNumber;

    public Player(String name) {// This constructor is executed during new Player
        this.name = name;
        this.counter++;// For different player ==> 1 or 2
        this.playerNumber = counter;
    }

    public String getName() {// Getting the player name
        return name;
    }

    public int getPlayerNumber() {// Getting the player number
        return playerNumber;
    }
}
