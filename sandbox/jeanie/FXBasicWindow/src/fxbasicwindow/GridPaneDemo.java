/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxbasicwindow;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author jeanieherold
 */
public class GridPaneDemo extends Application {
    
    public static void main(String[] args) {
        //launch application
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Label lGetTorch = new Label("Torch: ");
        Button bTorch = new Button("Light Torch");
        
        //create a gridpane
        GridPane grid = new GridPane();
        
        //add items to the gridpane
        grid.add(lGetTorch, 0, 0); //col 0 row 0
        grid.add(bTorch, 0, 1); //col 0 row 1
        
        //create a scene with the GridPane as its root node
        //this scene is 500px wide and 300px height
        Scene scene = new Scene(grid, 500, 300);
        
        //add the scene to the stage
        primaryStage.setScene(scene);
        
        //show the window
        primaryStage.show();
        
    }
    
}
