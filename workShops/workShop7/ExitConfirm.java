//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 07
//Date: 2019-11-14
/////////////////////////////////////////
package com.senecacollege.workshop7.javaFX;

import javafx.geometry.HPos;// This is for horizontal position
import javafx.geometry.Insets;// This is padding for scene
import javafx.geometry.Pos;// This is for placing the buttons in specified position
import javafx.scene.Scene;// This import is for scene
import javafx.scene.control.Button;// This import is for button
import javafx.scene.control.Label;// This import is for label
import javafx.scene.control.TextField;// This import is for text field
import javafx.scene.layout.GridPane;// This is for gridPane for placing the nodes
import javafx.stage.Stage;// This import is for stage

/**
 *
 * @author amira
 */
public class ExitConfirm {// This class is defined for the second scene

    private final TextField tfAnotherName;// This is the field of the text field that named tfAnotherName
    private Button btSubmit2;// This is the field of the button that named btSubmit2

    ExitConfirm() {// This consctructor is called from the TesterClass for invoking this scene

        GridPane pane = new GridPane();// This layout: all the nodes that are added to it are arranged in 
                                        //A way that they form a grid of rows and columns
        pane.setAlignment(Pos.CENTER);// For the position of nodes
        pane.setPadding(new Insets(1, 12, 1, 12));//Insets class stores the inside offsets for the four 
                                                    //sides of the rectangular area
        pane.setHgap(5.5);// The gap of horizontal
        pane.setVgap(11);// The gap of vertical

        Label lbAnotherName = new Label("Do you want to search the another Name:(y/n)");
        pane.add(lbAnotherName, 0, 1);// Adding the lbAnotherName to pane
        tfAnotherName = new TextField();
        pane.add(tfAnotherName, 1, 1);// Adding the tfAnotherName textField to pane
        tfAnotherName.setPrefColumnCount(1);// Sets the value of the property prefColumnCount

        btSubmit2 = new Button("submit");
        pane.add(btSubmit2, 0, 2);// Adding the btSubmit2 button to pane
        GridPane.setHalignment(btSubmit2, HPos.RIGHT);// Placing the btSubmit2 button on scene

        Button btExit2 = new Button("Exit");
        pane.add(btExit2, 1, 2);// Adding the btExit2 button to pane
        GridPane.setHalignment(btExit2, HPos.LEFT);// Placing the btExit2 button on scene

        Scene secondScene = new Scene(pane, 500, 200);// Placing the pane on the scene with the width=500 and heigth=200

        Stage secondStage = new Stage();// new object from Stage class
        secondStage.setTitle("Search Name Ranking Application");// The tittle of stage
        secondStage.setScene(secondScene);// Placing the scene on stage

        secondStage.show();// Showing the stage

        btExit2.setOnAction(e -> {//This setOnAction is for btExit2 button
            System.exit(0);// Terminating the system
        });

        btSubmit2.setOnAction(e -> {//This setOnAction is for btSubmit2 button
            if (tfAnotherName.getText().equalsIgnoreCase("y")) {// If the text be y or Y
                secondStage.close();// The second Stage will be closed
            } else if (tfAnotherName.getText().equalsIgnoreCase("n")) {// If the text be n or N
                System.exit(0);// Terminating the system
            }
        });
    }

}
