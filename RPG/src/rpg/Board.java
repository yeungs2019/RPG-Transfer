/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 */
public class Board extends Application {
    
    //private fields
    private Button start;
    private Button close;
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    
    //playing grid
    private GridPane grid = new GridPane();
    //player represented by sphere
    private Circle player = new Circle(10.0f, Color.RED);
    
    
    //launch application
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        //buttons
        start = new Button("Go");
        close = new Button("Close Game");
        north = new Button("Go North");
        east = new Button("Go East");
        south = new Button("Go South");
        west = new Button("Go West");
        
        //button Event Handlers
        start.setOnAction(new StartBtnHandler());
        close.setOnAction(new CloseBtnHandler());
        
        //row for bottom row button controls
        HBox btmRowControls = new HBox(10, north, east, south, west, close);
        btmRowControls.setAlignment(Pos.CENTER);
        
        Image thinking = new Image("file:images/player.png");
        ImageView playerIV = new ImageView(thinking);
        
        //add player to start
        grid.add(playerIV, 0, 0);
        GridPane.setHalignment(start, HPos.CENTER);
        grid.add(start, 0, 1);
        
        //create 25 square gameboard
        Square square1 = new Square();
        Square square2 = new Square();
        Square square3 = new Square();
        Square square4 = new Square();
        Square square5 = new Square();
        Square square6 = new Square();
        Square square7 = new Square();
        Square square8 = new Square();
        Square square9 = new Square();
        Square square10 = new Square();
        Square square11 = new Square();
        Square square12 = new Square();
        Square square13 = new Square();
        Square square14 = new Square();
        Square square15 = new Square();
        Square square16 = new Square();
        Square square17 = new Square();
        Square square18 = new Square();
        Square square19 = new Square();
        Square square20 = new Square();
        Square square21 = new Square();
        Square square22 = new Square();
        Square square23 = new Square();
        Square square24 = new Square();
        Square square25 = new Square();
        
        //add squares to the gameboard
        grid.add(square1, 1, 0);
        grid.add(square2, 1, 1);
        grid.add(square3, 1, 2);
        grid.add(square4, 1, 3);
        grid.add(square5, 1, 4);
        grid.add(square6, 2, 0);
        grid.add(square7, 2, 1);
        grid.add(square8, 2, 2);
        grid.add(square9, 2, 3);
        grid.add(square10, 2, 4);
        grid.add(square11, 3, 0);
        grid.add(square12, 3, 1);
        grid.add(square13, 3, 2);
        grid.add(square14, 3, 3);
        grid.add(square15, 3, 4);
        grid.add(square16, 4, 0);
        grid.add(square17, 4, 1);
        grid.add(square18, 4, 2);
        grid.add(square19, 4, 3);
        grid.add(square20, 4, 4);
        grid.add(square21, 5, 0);
        grid.add(square22, 5, 1);
        grid.add(square23, 5, 2);
        grid.add(square24, 5, 3);
        grid.add(square25, 5, 4);
   
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
    
    //use stackpane when we need to stack items
    private class Square extends StackPane {
        
        //constructor
        public Square() {
            //border for each tile - rect with no fill
            Rectangle border = new Rectangle(100, 100);
            //removes color from rectangle
            border.setFill(null);
            //add border color to each tile
            border.setStroke(Color.BLACK);
            
            //centers everything within the stackpane (single tile)
            setAlignment(Pos.CENTER);
            
            getChildren().addAll(border);
        }
    }
    
    /**
     * Event Handlers
    **/
    
    //start game
    class StartBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            GridPane.setHalignment(player, HPos.CENTER);
            grid.add(player, 1, 0);
        }
    }
    
    //close the stage window
    class CloseBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            close.getScene().getWindow().hide();
        }
    }
    
    
}
