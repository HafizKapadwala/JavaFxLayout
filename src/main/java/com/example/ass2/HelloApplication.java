package com.example.ass2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

class SimWidget {

    // Required values for my rectangle
    protected double minWidth;
    protected double maxWidth;
    protected double prefHeight;

    protected double myLeft;
    protected double myTop;
    protected double myWidth;
    protected double myHeight;

    protected Rectangle r;
    public SimWidget(double minWidth, double maxWidth, double prefHeight){
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.prefHeight = prefHeight;

        this.r = new Rectangle();
        this.r.setFill(Color.YELLOW);
        this.r.setStroke(Color.BLACK);
    }



}

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}