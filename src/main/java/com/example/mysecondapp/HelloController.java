package com.example.mysecondapp;

import com.example.mysecondapp.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSignIn;

    @FXML
    private Button buttonSignUp;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void initialize(){

        buttonSignIn.setOnAction(event -> {
            String loginText = loginField.getText().trim();
            String loginPassword = passwordField.getText().trim();

            if(!loginText.equals("") && !loginPassword.equals(""))
                loginUser (loginText, loginPassword);

                else if (loginText.equals("") && !loginPassword.equals("")){
                System.out.println("Login is empty");
            }
                else if (!loginText.equals("") && loginPassword.equals("")){
                System.out.println("Password is empty");
            }
                else if (loginText.equals("") && loginPassword.equals("")){
                System.out.println("Login and password are empty");
            }
        });
        buttonSignUp.setOnAction(event -> {
            buttonSignIn.getScene().getWindow().hide();
            openNewScene("signUp.fxml");
        });

    }
    private void loginUser (String loginText, String loginPassword){
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while (result.next()) {
                counter++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        if (counter>=1) {
            System.out.println("Successful :)");
            buttonSignIn.getScene().getWindow().hide();
            openNewScene("app.fxml");
        }
        else {
            Shake userLoginAnim = new Shake(loginField);
            Shake userPassAnim = new Shake(passwordField);
            userLoginAnim.playAnim();
            userPassAnim.playAnim();
        }
    }

    public void openNewScene(String window){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        }catch(IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

}

