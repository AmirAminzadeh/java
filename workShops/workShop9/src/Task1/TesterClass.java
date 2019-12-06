//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 09
//Date: 2019-11-29
/////////////////////////////////////////
package com.senecacollege.workshop9.Task1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TesterClass extends Application {

    private Number[] getTfAddition;// This field is for the text field of addition
    private Number[] getTfSubtraction;// This field is for the text field of subtraction
    private Number[] getTfMultipliction;// This field is for the text field of multiplication
    private Number[] getTfDivision;// This field is for the text field of division

    LinkedHashSet<String> userAnswers = new LinkedHashSet<String>();// A LinkedHashSet is an ordered version of HashSet

    private int random1;// Local variable for the first random number
    private int random2;// Local variable for the second random number

    @Override
    public void start(Stage primaryStage) { // This start method is for executing the javaFX

        GridPane pane = new GridPane();// This layout: all the nodes that are added to it are arranged in 
        //A way that they form a grid of rows and columns
        pane.setAlignment(Pos.CENTER);// For the position of nodes
        pane.setPadding(new Insets(1, 1, 1, 1));//Insets class stores the inside offsets for the four 
        //sides of the rectangular area
        pane.setVgap(11);// The gap of vertical
        pane.setHgap(1);// The gap of horizontal

        random1 = (int) (Math.random() * 10 + 1);// The random number between 0 to 11
        random2 = (int) (Math.random() * 10 + 1);// The random number between 0 to 11
        // The first label
        Label lbRandom = new Label("Two randomly generated numbers are:" + random1 + " and " + random2);
        pane.add(lbRandom, 0, 0);// Adding the lbRandom to pane
        // The addition label
        Label lbAddition = new Label("What is addition of " + random1 + " and " + random2 + " :");
        pane.add(lbAddition, 0, 1);// Adding the lbAddition to pane
        // The subtraction label
        Label lbSubtraction = new Label("What is subtraction of " + random1 + " and " + random2 + " :");
        pane.add(lbSubtraction, 0, 2);// Adding the lbSubtraction to pane
        // The multiplication label
        Label lbMultiplication = new Label("What is multiplication of " + random1 + " and " + random2 + " :");
        pane.add(lbMultiplication, 0, 3);// Adding the lbMultiplication to pane
        Label lbDivision = new Label("What is division of " + random1 + " and " + random2 + " :");
        pane.add(lbDivision, 0, 4);// Adding the lbName to pane
        Label lbCorrect = new Label("Number of Correct Answer: ");
        pane.add(lbCorrect, 0, 5);// Adding the lbPrintQueryName to pane
        Label lbWrong = new Label("Number of Wrong Answer: ");
        pane.add(lbWrong, 0, 6);// Adding the lbRanking to pane
        Label lbAgain = new Label("Would you like to try with two other different numbers?(y/n) ");
        pane.add(lbAgain, 0, 8);// Adding the lbRanking to pane

        TextField tfAddition = new TextField();// Getting a new text field
        pane.add(tfAddition, 1, 1);// Adding the tfAddition to pane
        userAnswers.add(tfAddition.getText());// Adding the text field to set collection

        TextField tfSubtraction = new TextField();// Getting a new text field
        pane.add(tfSubtraction, 1, 2);// Adding the tfSubtraction to pane
        userAnswers.add(tfSubtraction.getText());// Adding the text field to set collection

        TextField tfMultipliction = new TextField();// Getting a new text field
        pane.add(tfMultipliction, 1, 3);// Adding the tfMultipliction to pane
        userAnswers.add(tfMultipliction.getText());// Adding the text field to set collection

        TextField tfDivision = new TextField();// Getting a new text field
        pane.add(tfDivision, 1, 4);// Adding the tfName to pane
        userAnswers.add(tfDivision.getText());// Adding the text field to set collection

        TextField tfAgain = new TextField();
        pane.add(tfAgain, 1, 8);// Adding the tfName to pane

        // Key pressed tab for handle the operation 
        tfDivision.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                if (event.getCode().equals(KeyCode.TAB)) {// When the tab key would be pressed
                    int correct = 0;
                    int wrong = 0;

                    List<String> numbersList = new ArrayList<String>(userAnswers);// converting to Array list
                    // Convert List of String to list of Integer 
                    for (int i = 0; i < 4; i++) {// Checking the conditions to Controller class with Operation method
                        Controller.Operation(numbersList.get(i));
                    }

                    Label lbCorrect = new Label("Number of Correct Answer: " + correct);// Printing the label with correct answer
                    pane.add(lbCorrect, 0, 5);// Adding the lbPrintQueryName to pane

                    Label lbWrong = new Label("Number of Wrong Answer: " + (correct - 4));// Printing the label with wrong answer
                    pane.add(lbWrong, 0, 6);// Adding the lbRanking to pane

                }
            }
        });

        // This key wikk be for continuing again or closing the stage
        tfAgain.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                if (event.getCode().equals(KeyCode.ENTER)) {// When the key is pressed
                    if (tfAgain.getText().equalsIgnoreCase("n")) {// If the text field be n or N
                        primaryStage.close();// Closing the stage
                    } else if (tfAgain.getText().equalsIgnoreCase("y")) {// If the text field be y or Y
                        tfAddition.setText("");// Emptying the tfAddition
                        tfSubtraction.setText("");// Emptying the tfSubtraction
                        tfMultipliction.setText("");// Emptying the tfMultipliction
                        tfDivision.setText("");// Emptying the tfDivision
                        tfAgain.setText("");// Emptying the tfAgain
                        primaryStage.show();// Shoing the Stage
                    }
                }
            }
        });

        primaryStage.setTitle("Quiz Application");// The title for the Stage
        primaryStage.setScene(new Scene(pane, 500, 400));// the size of scene
        primaryStage.show();// Shoing the primary stage

    }

    ;

    public static void main(String[] args) {// The main mathod for calling the application
        launch(args);
    }

}
