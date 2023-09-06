package com.example.mysecondapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeController extends HelloController{

    @FXML
    private Button buttonHomePage;

    @FXML
    private ImageView buttonImageStar;

    @FXML
    void initialize() {
        buttonHomePage.setOnAction(event -> {
            buttonHomePage.getScene().getWindow().hide();
            openNewScene("hello-view.fxml");
        });
    }

}
