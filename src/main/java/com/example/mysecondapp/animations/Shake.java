package com.example.mysecondapp.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;


public class Shake {
    private TranslateTransition tt;
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(40), node);
        tt.setFromY(0);
        tt.setByY(3);
        tt.setCycleCount(3);
        tt.setAutoReverse(true);
    }
    public void playAnim(){
        tt.playFromStart();
    }
}
