//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 07
//Date: 2019-11-14
/////////////////////////////////////////
package com.senecacollege.workshop7.javaFX;

import javafx.application.Application;// This import is for application
import javafx.geometry.Insets;// This is padding for scene
import javafx.scene.Scene;// This import is for scene
import javafx.scene.control.Button;// This import is for button
import javafx.scene.control.Label;// This import is for label
import javafx.scene.control.TextField;// This import is for text field
import javafx.scene.layout.GridPane;// This import is for grid pane layout
import javafx.stage.Stage;// This import is for stage
import java.io.FileNotFoundException;
import javafx.geometry.HPos;// This import is for horizontal position
import javafx.geometry.Pos;// This import is for different position

// This is the TesterClass class that extends with Application class
public class TesterClass extends Application {

    @Override
    //The primary stage is created by the platform and passed to the start(Stage s) method of the Application class
    public void start(Stage stage) {

        GridPane pane = new GridPane();// This layout: all the nodes that are added to it are arranged in 
                                        //A way that they form a grid of rows and columns
        pane.setAlignment(Pos.CENTER);// For the position of nodes
        pane.setPadding(new Insets(1, 12, 1, 12));//Insets class stores the inside offsets for the four 
                                                    //sides of the rectangular area
        pane.setVgap(11);// The gap of vertical
        pane.setHgap(5);// The gap of horizontal

        Label lbYear = new Label("Enter the Year:");
        pane.add(lbYear, 0, 0);// Adding the lbYear to pane
        Label lbGender = new Label("Enter the Gender:");
        pane.add(lbGender, 0, 1);// Adding the lbGender to pane
        Label lbName = new Label("Enter the Name:");
        pane.add(lbName, 0, 2);// Adding the lbName to pane
        Label lbPrintQueryName = new Label("");
        pane.add(lbPrintQueryName, 0, 3);// Adding the lbPrintQueryName to pane
        Label lbRanking = new Label("");
        pane.add(lbRanking, 1, 3);// Adding the lbRanking to pane

        TextField tfYear = new TextField();
        pane.add(tfYear, 1, 0);// Adding the tfYear to pane

        TextField tfGender = new TextField();
        pane.add(tfGender, 1, 1);// Adding the tfGender to pane

        TextField tfName = new TextField();
        pane.add(tfName, 1, 2);// Adding the tfName to pane

        Button btExit = new Button("Exit");
        GridPane.setHalignment(btExit, HPos.RIGHT);// Placing the button at right position
        btExit.setOnAction(e -> new ExitConfirm());//This setOnAction is for btExit2 button 
                                                  //and invoking the new object from ExitConfirm class
        pane.add(btExit, 1, 5);// Adding the btExit to pane

        Button btSubmitQ = new Button("Submit Query");
        GridPane.setHalignment(btSubmitQ, HPos.RIGHT);// Placing the button at right position
        pane.add(btSubmitQ, 0, 5);// Adding the lbAnotherName to pane

        tfYear.setPrefColumnCount(10);// Sets the value of the property prefColumnCount
        tfYear.getText();//Getting the tfYear

        tfGender.setPrefColumnCount(1);// Sets the value of the property prefColumnCount
        tfGender.getText();//Getting the tfGender

        tfName.setPrefColumnCount(10);// Sets the value of the property prefColumnCount
        tfName.getText();//Getting the tfName

        // This lumbda function is for Submit Query button
        btSubmitQ.setOnAction(e -> {
            if (tfYear.getText() != null && !tfYear.getText().isEmpty() && tfGender.getText() != null
                    && !tfGender.getText().isEmpty() && tfName.getText() != null && !tfName.getText().isEmpty()) {

                boolean gender = true; //We suppose the gender=tue is girl
                int rank = 0;

                if (tfGender.getText().toLowerCase().equals("m")) {
                    gender = false; //So, here the gender is boy(gender=false)
                }

                try {
                    rank = UtilityRanking.getRank(tfName.getText(), Integer.parseInt(tfYear.getText()), gender);// This gender is boy or girl
                } catch (FileNotFoundException ex) {
                    System.out.println("File not found!");
                }

                if (gender) {
                    lbPrintQueryName.setText("Girl name " + tfName.getText());// lbPrintQueryName is the empty label
                } else {
                    lbPrintQueryName.setText("Boy name " + tfName.getText());
                }

                if (rank == 0) {
                    lbRanking.setText("Was not found");//lbRanking is the empty label in continuous of another empty label
                } else {
                    lbRanking.setText("is ranked #" + rank + " in " + tfYear.getText() + " year");
                }

            } else {
                lbPrintQueryName.setText("Invalid!");//Showing the label
            }
        });

        Scene scene = new Scene(pane, 400, 200);// Adding the parent pane with the sizes into the scene
        stage.setTitle("Search Name Ranking Application");
        stage.setScene(scene);// Setting the scene to stage
        stage.show();// Showing the stage
    }

    public static void main(String[] args) {// This main is for executing the application
        Application.launch(args);
    }
}
