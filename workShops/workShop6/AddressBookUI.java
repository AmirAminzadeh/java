//////////////////////////////////////////
//Student Name: Amir aminzadeh
//Student Number: 126554187
//WorkShop 06
//Date: 2019-11-06
/////////////////////////////////////////
package com.senecaCollege.JavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// The BoardPane is a class for placing the nodes in specifed place
public class AddressBookUI extends BorderPane {

    public AddressBookUI() {// This constructor will be executed when the new AddressBookUI is called
        designBook();// Calling the designBook()
    }

//    String provinces[]
//            = {"Alberta", "British Columbia", "Manitoba",
//                "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec"};
//    protected ComboBox tfState
//            = new ComboBox(FXCollections.observableArrayList(provinces));
    TextField tfFirstName = new TextField("Jack");// create a new object from text field
    TextField tfLastName = new TextField("Smith");// create a new object from text field
    TextField tfCity = new TextField("Toronto");// create a new object from text field
    TextField tfState = new TextField("Ontario");// create a new object from text field
    TextField tfZip = new TextField("L361V2");// create a new object from text field
    Button btAdd = new Button("Add");// create a new object from Button
    Button btFirst = new Button("First");// create a new object from Button
    Button btNext = new Button("Next");// create a new object from Button
    Button btPrevious = new Button("Previous");// create a new object from Button
    Button btLast = new Button("Last");// create a new object from Button
    Button btUpdate = new Button("Update");// create a new object from Button
    FlowPane paneForInfo = new FlowPane(5, 25);// This FlowPane fpr placing the labels and text fields
    HBox paneForButtons = new HBox(30);// This Hbox for placing the button with a specified space

    private void designBook() {
        tfFirstName.setPrefColumnCount(40);// the size of each text field(first name)
        tfLastName.setPrefColumnCount(40);// the size of each text field(last name)
        tfCity.setPrefColumnCount(15);// the size of each text field(city)
        tfState.setPrefColumnCount(10);// the size of each text field(province)
        tfZip.setPrefColumnCount(6);// the size of each text field(postal code)

        paneForInfo.setPadding(new Insets(15, 15, 15, 15));// Place nodes in the flow pane

        Label lbFirstName = new Label("First Name:        ");// create a new object from label
        Label lbLastName = new Label("Last Name:        ");// create a new object from label
        Label lbCity = new Label("City:");// create a new object from label
        Label lbProvince = new Label("Province:");// create a new object from label
        Label lbPostalCode = new Label("Postal Code:");// create a new object from label
        
        //Adding the all labels and text fields as a children (getChildren()) to the pane that named paneForInfo
        paneForInfo.getChildren().addAll(lbFirstName, tfFirstName, lbLastName, tfLastName, lbCity, tfCity,
                lbProvince, tfState, lbPostalCode, tfZip);
        
        btAdd.setStyle("-fx-font-size: 2em; ");// Size of the btAdd
        btFirst.setStyle("-fx-font-size: 2em; ");// Size of the btFirst
        btNext.setStyle("-fx-font-size: 2em; ");// Size of the btNext
        btPrevious.setStyle("-fx-font-size: 2em; ");// Size of the btPrevious
        btLast.setStyle("-fx-font-size: 2em; ");// Size of the btLast
        btUpdate.setStyle("-fx-font-size: 2em; ");// Size of the btUpdate
        
        //Adding the all buttons as a children (getChildren()) to the pane that named paneForButtons
        paneForButtons.getChildren().addAll(btAdd, btFirst,btNext, btPrevious, btLast, btUpdate);
        paneForButtons.setAlignment(Pos.CENTER);// Putting the buttons in center of the specified pane

        setCenter(paneForInfo);// Place nodes in the pane of paneForInfo
        setBottom(paneForButtons);// Place nodes in the pane of paneForButtons
    }
}
