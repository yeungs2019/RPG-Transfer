/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 */
public class Board extends Application {
    
    //private fields
    Button close;
    
    //launch application
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        //buttons
        close = new Button("Close Game");
        
        //button Event Handlers
        close.setOnAction(new CloseBtnHandler());
        
        //row for bottom row button controls
        HBox btmRowControls = new HBox(close);
        btmRowControls.setAlignment(Pos.BASELINE_RIGHT);
        
        //playing grid
        GridPane grid = new GridPane();
        
        Image player = new Image("file:images/player.png");
        ImageView playerIV = new ImageView(player);
        
        //add player to start
        grid.add(playerIV, 0, 0); 
        
        
        //GridPane styles
        grid.setPadding(new Insets(20));
        grid.setPrefWidth(500);
        grid.setPrefHeight(500);
        
        //container box to hold main elements
        VBox container = new VBox(25, grid, btmRowControls);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(25));
        
        //create Scene
        Scene scene = new Scene(container, 800, 800);
        scene.getStylesheets().add("board.css");

        primaryStage.setTitle("RPG Team Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Event Handlers
    **/
    
        //close the stage window
    class CloseBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            close.getScene().getWindow().hide();
        }
    }
    
    
}
