//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 06
//Date: 2019-11-06
/////////////////////////////////////////
package com.senecaCollege.JavaFX;

import javafx.application.Application;// This is a class for creating application
import javafx.scene.Scene;// This is a class for making scene
import javafx.stage.Stage;// This is a class for making stage
import java.io.*;// This is a class for input and output

// This is the AddressBook class that extends with Application class
public class AddressBook extends Application {

    AddressBookUI pane = new AddressBookUI();// A new object from AddressBookUI
    int firstName = 40;// The length maximum of the first name
    int lastName = 40;// The length maximum of the last name
    int city = 15;// The length maximum of the city
    int province = 15;// The length maximum of the province
    int postalCode = 6;// The length maximum of the postal code
    int count;// Defining a variable that named count

    //The entry point method where the JavaFX graphics code is to be written
    public void start(Stage primaryStage) {

        pane.btAdd.setOnAction(click -> add());//Sets the value of the property onAction for add button
        pane.btFirst.setOnAction(click -> first());//Sets the value of the property onAction for first button
        pane.btNext.setOnAction(click -> next());//Sets the value of the property onAction for next button
        pane.btPrevious.setOnAction(click -> previous());//Sets the value of the property onAction for previous button
        pane.btLast.setOnAction(click -> last());//Sets the value of the property onAction for last button
        pane.btUpdate.setOnAction(click -> update());//Sets the value of the property onAction for update button

        Scene scene = new Scene(pane, 600, 200);// Create a scene with pane of scaled 600 * 180 on pixel
        primaryStage.setTitle("Address Book"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void add() {// This method for adding the data into scene to a file.txt
        try ( // Create a random access file
                RandomAccessFile inout = new RandomAccessFile("AddressBook.txt", "rw");) {
            //Sets the file-pointer offset, measured from the beginning of this file, 
            //at which the next read or write occurs ==> void seek(long pos)
            inout.seek(inout.length());
            write(inout);
        } catch (FileNotFoundException ex) {// The file is not found
        } catch (IOException ex) {// The IO eception
        } catch (IndexOutOfBoundsException ex) {//Being out of bound of indexes
        }
    }

    private void first() {// This method for reading the first box of data
        try ( // Create a random access file
                RandomAccessFile inout
                = new RandomAccessFile("AddressBook.txt", "rw");) {
            if (inout.length() > 0) {
                inout.seek(0);// Finding the position
                read(inout);//Reading the data
                System.out.println("Reading information of nember 1");
                count = 1;// Because the data is for first box of data
            } else {
                System.out.println("Without information!");
            }
        } catch (IOException ex) {
        }
    }

    private void next() {// This method for reading the next box of data
        try ( // Create a random access file
                RandomAccessFile inout
                = new RandomAccessFile("AddressBook.txt", "rw");) {
            if (count * 116 < inout.length()) {// The 116 is the maximum length for each box of information 
                inout.seek(count * 116);// Finding the position in each 116 characters
                read(inout);// Reading the data
                count++;// Appending the box of data for another inputs
                System.out.println("Reading information of number " + count);
            } else {
                System.out.println("End of file!");
            }
        } catch (IOException ex) {
        }
    }

    private void previous() {// This method for reading the previous box of data
        try ( // Create a random access file
                RandomAccessFile inout
                = new RandomAccessFile("AddressBook.txt", "rw");) {
            if (count > 1) {// when the count is greater than one, so 
                count--;// Decrease the count(box of information) 
            } else {
                count = 1;// Else the count is the first box of information(data)
            }
            inout.seek((count * 116) - 116);// Finding the position in each 116 characters and 
                                            // go back to another 116 character
            read(inout);// Reading
            System.out.println("Reading information of number " + count);
        } catch (IOException ex) {
        }
    }

    private void last() {// This method for reading the last box of data
        try ( // Create a random access file
                RandomAccessFile inout
                = new RandomAccessFile("AddressBook.txt", "rw");) {
            count = ((int) inout.length()) / 116;
            inout.seek((count * 116) - 116);
            read(inout);
            System.out.println("Reading address #" + count);
        } catch (IOException ex) {
        }
    }

    private void update() {// This method for reading the update box of data
        try ( // Create a random access file
                RandomAccessFile inout
                = new RandomAccessFile("AddressBook.txt", "rw");) {
            inout.seek(count * 116 - 116);// Finding the position
            write(inout);//writing
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    //The writh method for each textfield as a getText and getBytes
    private void write(RandomAccessFile inout) throws IOException {
        inout.write(selectedLength(pane.tfFirstName.getText().getBytes(), firstName));// The selectedLength method is for writting
        inout.write(selectedLength(pane.tfLastName.getText().getBytes(), lastName));// The selectedLength method is for writting
        inout.write(selectedLength(pane.tfCity.getText().getBytes(), city));
        inout.write(selectedLength(pane.tfState.getText().getBytes(), province));
        inout.write(selectedLength(pane.tfZip.getText().getBytes(), postalCode));
        System.out.println("Address #" + count + " saved!");// It is displayed in output of Netbeans
    }
    
    

    ////The read method for each textfield as a getText and getBytes
    private void read(RandomAccessFile inout) throws IOException {
        int position;
        byte[] fName = new byte[firstName];//Creating a new object from byte[] that named fName
        position = inout.read(fName);// Reading the fName and set to first "position"
        pane.tfFirstName.setText(new String(fName));// Putting the first name from pane to the fName fo reading

        byte[] lName = new byte[lastName];//Creating a new object from byte[] that named lName
        position += inout.read(lName);// Reading the lName and set to second "position"
        pane.tfLastName.setText(new String(lName));// Putting the last name from pane to the lName fo reading

        byte[] cityN = new byte[city];//Creating a new object from byte[] that named cityN
        position += inout.read(cityN);// Reading the cityN and set to third "position"
        pane.tfCity.setText(new String(cityN));// Putting the city from pane to the cityN fo reading

        byte[] prov = new byte[province];//Creating a new object from byte[] that named prov
        position += inout.read(prov);// Reading the prov and set to fourth "position"
        pane.tfState.setText(new String(prov));// Putting the province from pane to the prov fo reading

        byte[] zip = new byte[postalCode];//Creating a new object from byte[] that named zip
        position += inout.read(zip);// Reading the zip and set to fifth "position"
        pane.tfZip.setText(new String(zip));// Putting the postal code from pane to the zip fo reading
    }

//    // We want to match the length of each variable with the new length from the variable
    private byte[] selectedLength(byte[] x, int n) {//Return a byte[] of fixed-length
        byte[] b = new byte[n];// b is new byte[]
        for (int i = 0; i < x.length; i++) {
            b[i] = x[i];//Matching the length with together
        }
        return b;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
