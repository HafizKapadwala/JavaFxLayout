package com.example.ass2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


class SimWidget{
    protected double minWidth;
    protected double maxWidth;
    protected double prefHeight;


    protected double myLeft; // x value
    protected double myTop; // y Value
    protected double myWidth;
    protected double myHeight;


    protected Rectangle r;

    public SimWidget(double minWidth, double maxWidth, double prefHeight){
        this.r = new Rectangle();
        this.r.setFill(Color.YELLOW);
        this.r.setStroke(Color.ORANGE);
        this.updateSize(minWidth,maxWidth,prefHeight);
        this.updateRectangle();
    }

    public void updateSize(double minWidth, double maxWidth, double prefHeight){
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.prefHeight = prefHeight;
    }

    public void setMyLeft(double myLeft) {
        this.myLeft = myLeft;
        this.r.setX(this.myLeft);
    }

    public void setMyTop(double myTop) {
        this.myTop = myTop;
        this.r.setY(this.myTop);
    }

    public void setMyWidth(double myWidth) {
        this.myWidth = myWidth;
        this.r.setWidth(this.myWidth);
    }

    public void setMyHeight(double myHeight) {
        this.myHeight = myHeight;
        this.r.setHeight(this.myHeight);
    }

    public void updateRectangle(){
        this.r.minWidth(this.minWidth);
        this.r.maxWidth(this.maxWidth);
        this.r.prefHeight(this.prefHeight);
    }

}





class LinearLayout{
    protected List<SimWidget> parent;

    protected Rectangle externalRectangle ;
    public LinearLayout(){
        this.parent = new LinkedList<>();
        externalRectangle = new Rectangle();
        externalRectangle.setFill(Color.ORANGE);
        externalRectangle.setStroke(Color.BLACK);
    }

    public void addChildren(SimWidget children){
        this.parent.add(children);
    }

    public void doLayout(){
        double xValues = 0;
        double totalHeight = 0;
        double totalWidth = 0;
        for (SimWidget children : parent){
            children.setMyWidth(children.minWidth);
            children.setMyLeft(xValues);
            children.setMyHeight(children.prefHeight);
            totalWidth +=  children.myWidth;
            if (children.myHeight > totalHeight){
                totalHeight = children.myHeight;
            }
            xValues += children.minWidth;
        }
        this.externalRectangle.setWidth(totalWidth);
        this.externalRectangle.setHeight(totalHeight);
    }
}

class LayoutView extends Pane{
    protected LinearLayout root;
    public LayoutView(){
        root = new LinearLayout();
        SimWidget sw1 = new SimWidget(50,200,200);
        SimWidget sw2 = new SimWidget(100,100,100);
        SimWidget sw3 = new SimWidget(150,250,150);
        root.addChildren(sw1);
        root.addChildren(sw2);
        root.addChildren(sw3);
        root.doLayout();

        this.addRectangle(root);
    }

    public void addRectangle(LinearLayout root){
        this.getChildren().add(root.externalRectangle);
        for (SimWidget children : root.parent){
            this.getChildren().add(children.r);
        }
    }

}


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        LayoutView root = new LayoutView();

        Scene scene = new Scene(root, 1000, 1000);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}