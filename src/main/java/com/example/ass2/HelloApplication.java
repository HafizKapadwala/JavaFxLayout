package com.example.ass2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

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

    public void setValues(double left, double top, double width, double height){
        this.myLeft = left;
        this.myTop = top;
        this.myWidth = width;
        this.myHeight = height;
    }
    public SimWidget(double minWidth, double maxWidth, double prefHeight){
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.prefHeight = prefHeight;

        this.r = new Rectangle();
        this.r.setFill(Color.YELLOW);
        this.r.setStroke(Color.BLACK);
        this.updateSize();
    }

    public void updatePosition(){
        this.r.setLayoutX(this.myLeft);
        this.r.setLayoutY(this.myTop);
    }

    public void updateSize(){
        this.r.minWidth(this.minWidth);
        this.r.maxWidth(this.maxWidth);
        this.r.prefHeight(this.prefHeight);
        this.r.setWidth(this.myWidth);
        this.r.setHeight(this.myHeight);
    }
}

class LinearLayout{
    protected LinkedList<SimWidget> listOfChildren;

    public void addChild(SimWidget r){
        this.listOfChildren.addLast(r);
    }
    public void doLayout(){

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