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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 */
public class GameEngine extends Application {
    
    //private fields
    private Button start;
    private Button close;
    private Button north;
    private Button east;
    private Button south;
    private Button west;
    //story display
    private Label playerMessage;
    
    //playing grid
    private final int COL_MAX_INDEX = 5;
    private final int ROW_MAX_INDEX = 4;
    private GridPane grid = new GridPane();
    //player represented by sphere temporarily
    private Circle player = new Circle(10.0f, Color.RED);
    private Player player1 = new Player("Einstein", "file:images/einstein.png");
    private ImageView einstein = player1.getProfile();
    
    @Override
    public void start(Stage primaryStage) {

        //buttons
        start = new Button("Start");
        close = new Button("Close Game");
        north = new Button("Go North");
        north.setDisable(true);
        east = new Button("Go East");
        east.setDisable(true);
        south = new Button("Go South");
        south.setDisable(true);
        west = new Button("Go West");
        west.setDisable(true);
        
        //button Event Handlers
        start.setOnAction(new GameEngine.StartBtnHandler());
        close.setOnAction(new GameEngine.CloseBtnHandler());
        north.setOnAction(new GameEngine.NorthBtnHandler());
        east.setOnAction(new GameEngine.EastBtnHandler());
        south.setOnAction(new GameEngine.SouthBtnHandler());
        west.setOnAction(new GameEngine.WestBtnHandler());
        
        //row for bottom row button controls
        HBox middleRowBtns = new HBox(10, west, close, east);
        VBox directionBtns = new VBox(10, north, middleRowBtns, south);
        
        middleRowBtns.setAlignment(Pos.CENTER);
        directionBtns.setAlignment(Pos.CENTER);
        
        Image thinking = new Image("file:images/player.png");
        ImageView playerIV = new ImageView(thinking);
        
        
        
        //player message 
        playerMessage = new Label();
        playerMessage.setMaxWidth(90);
        //note to self - this is not doing anything on the label - find out why... 
        playerMessage.setAlignment(Pos.TOP_LEFT);
        playerMessage.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-wrap-text:true;");
        
        //add player to start
        grid.add(playerIV, 0, 0);
        GridPane.setHalignment(start, HPos.LEFT);
        grid.add(start, 0, 1);
        //have message span 1 col and 2 rows (params are control, col, row, colspan, rowspan)
        grid.add(playerMessage, 0, 2, 1, 3);
        
        //create 25 Gamesquare gameboard
        GameSquare square1 = new GameSquare();
        GameSquare square2 = new GameSquare();
        GameSquare square3 = new GameSquare();
        GameSquare square4 = new GameSquare();
        GameSquare square5 = new GameSquare();
        GameSquare square6 = new GameSquare();
        GameSquare square7 = new GameSquare();
        GameSquare square8 = new GameSquare();
        GameSquare square9 = new GameSquare();
        GameSquare square10 = new GameSquare();
        GameSquare square11 = new GameSquare();
        GameSquare square12 = new GameSquare();
        GameSquare square13 = new GameSquare();
        GameSquare square14 = new GameSquare();
        GameSquare square15 = new GameSquare();
        GameSquare square16 = new GameSquare();
        GameSquare square17 = new GameSquare();
        GameSquare square18 = new GameSquare();
        GameSquare square19 = new GameSquare();
        GameSquare square20 = new GameSquare();
        GameSquare square21 = new GameSquare();
        GameSquare square22 = new GameSquare();
        GameSquare square23 = new GameSquare();
        GameSquare square24 = new GameSquare();
        GameSquare square25 = new GameSquare();
        
        //add Gamesquares to the gameboard
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
        VBox container = new VBox(25, grid, directionBtns);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(25));
        
        //create Scene
        Scene scene = new Scene(container, 800, 800);
//        scene.getStylesheets().add("board.css");

        primaryStage.setTitle("RPG Team Project");
        primaryStage.setScene(scene);
        primaryStage.show();
           
    }
    
    /**
     * Event Handlers
    **/
    
    //start game
    class StartBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            GridPane.setHalignment(einstein, HPos.CENTER);
            grid.add(einstein, 1, 0);
            playerMessage.setText(("Your position on the board is indicated by your profile picture. Click direction buttons to look for puzzles and items!"));
            
            //disable go btn once player added
            start.setDisable(true);
            north.setDisable(false);
            east.setDisable(false);
            south.setDisable(false);
            west.setDisable(false);
        }
    }
    
    //go north btn handler
    class NorthBtnHandler implements EventHandler<ActionEvent> {
            
        @Override
        public void handle(ActionEvent event) {
            
            int col = player1.getColumnLocation(grid, einstein);
            int row = player1.getRowLocation(grid, einstein);
            
            if(row > 0) {
                grid.getChildren().remove(einstein);
                grid.add(einstein, col, row - 1);
            }
            
        }
    }
    
    //go east btn handler
    class EastBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            int col = player1.getColumnLocation(grid, einstein);
            int row = player1.getRowLocation(grid, einstein);
            
            if(col < COL_MAX_INDEX) {
                grid.getChildren().remove(einstein);
                grid.add(einstein, col + 1, row);
            }
        }
    }
    //go south btn handler
    class SouthBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            int col = player1.getColumnLocation(grid, einstein);
            int row = player1.getRowLocation(grid, einstein);
            
            if(row < ROW_MAX_INDEX) {
                grid.getChildren().remove(einstein);
                grid.add(einstein, col, row + 1);
            }
        }
    }
    //go west btn handler
    class WestBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            int col = player1.getColumnLocation(grid, einstein);
            int row = player1.getRowLocation(grid, einstein);
            
            if(col > 1) {
                grid.getChildren().remove(einstein);
                grid.add(einstein, col - 1, row);
            }
        }
    }
    
    //close the stage window
    class CloseBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            close.getScene().getWindow().hide();
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
