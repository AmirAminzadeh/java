//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 07
//Date: 2019-11-14
/////////////////////////////////////////
package com.senecacollege.workshop7.javaFX;

import java.io.File;// Importing for input and output files
import java.io.FileNotFoundException;// for exception of file not found
import java.util.Scanner;// For scan from inputing by user

/**
 *
 * @author amira
 */
public class UtilityRanking {// This class with the getRank method will be done reading the files and seperated the values
     public static int getRank(String name, int year, boolean gender) throws FileNotFoundException {
        String rank = "0", boyName, numberOfBoy, girlName, numberOfGirl;
        boolean flag = false;
        // creating new file in specifed address
        File file = new File("C:\\Users\\amira\\Documents\\NetBeansProjects\\WorkShop7\\babynamesranking" + year + ".txt");
        Scanner line = new Scanner(file);//scanning the file

        while (line.hasNextLine() && flag == false) {// when the file is not empty
            rank = line.next();// filling the string rank
            boyName = line.next();// filling the string boy name
            numberOfBoy = line.next();// filling the string number of boy
            girlName = line.next();// filling the string girl name
            numberOfGirl = line.next();// filling the string number of girl

            //Showing the under statement with upper values from the files
            System.out.println(rank + "+" + boyName + "+" + numberOfBoy + "+" + girlName + "+" + numberOfGirl);

            
            if (!gender && boyName.equals(name)) {// boy is false
                flag = true;
            }

            if (gender && girlName.equals(name)) {// girl is true
                flag = true;
            }
        }

        line.close();
        if (flag) {// if the flag was true, returning the rank
            return (Integer.parseInt(rank));
        }
        return 0;
    }
}
