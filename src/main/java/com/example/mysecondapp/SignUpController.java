package com.example.mysecondapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController extends HelloController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSignUp;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox signUpCheckBoxMan;

    @FXML
    private CheckBox signUpCheckBoxWoman;

    @FXML
    private TextField signUpCountry;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {
        buttonSignUp.setOnAction(event -> {
            signUpNewUser();
        });
        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");
        });

    }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

            String firstName = signUpName.getText();
            String lastName = signUpLastName.getText();
            String userName = loginField.getText();
            String password = passwordField.getText();
            String location = signUpCountry.getText();
            String gender = "";
            if(signUpCheckBoxWoman.isSelected())
                gender = "Woman";
            else
                gender = "Man";

            User user = new User(firstName, lastName, userName, password, location, gender);

        dbHandler.signUpUser(user);
    }

}
