/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    protected Label playerMessage;
    protected Label playerAlert;
    protected Label playerScore;
    protected Label playerItems;
    
    //playing grid
    private final int COL_MAX_INDEX = 6;
    private final int ROW_MAX_INDEX = 6;
    private final GridPane grid = new GridPane();
    protected final Player player1 = new Player("Einstein", "file:images/einstein.png");
    private final ImageView einstein = player1.getProfile();
    
    
    @Override
    public void start(Stage primaryStage) {

        //buttons
        start = new Button("Start");
        close = new Button("Close Game");
        close.setStyle("-fx-color: RED");
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
        
        //directional button controls
        HBox directionBtns = new HBox(5, north, east, south, west, close);      
        directionBtns.setAlignment(Pos.BASELINE_LEFT);
        
        //player message left sidebar 
        playerMessage = new Label();
        playerMessage.setMaxWidth(600);
        playerMessage.setAlignment(Pos.TOP_LEFT);
        playerMessage.setStyle("-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: blue; -fx-wrap-text:true;");
        playerMessage.setText(("Click Start to Begin!"));
        
        //display player greeting and alert messages for player
        playerAlert = new Label();
        playerAlert.setMaxWidth(600);
        //note to self - this is not doing anything on the label - find out why... 
        playerAlert.setAlignment(Pos.TOP_LEFT);
        playerAlert.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: blue; -fx-wrap-text:true;");
        
        playerScore = new Label();
        playerScore.setAlignment(Pos.TOP_LEFT);
        playerScore.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-wrap-text:true;");
        playerScore.setText(String.valueOf(player1.getName() + "\'s Score: " + player1.getScore()));
        
        playerItems = new Label();
        playerItems.setAlignment(Pos.TOP_LEFT);
        playerItems.setStyle("-fx-font-size: 14; -fx-font-weight: bold; -fx-wrap-text:true;");
        playerItems.setText(String.valueOf(player1.getName() + "\'s Items: " + player1.getItems()));
        
        //examples of adding to Score and adding to Items
        player1.addToScore(10);
        player1.subtractFromScore(3);
        playerScore.setText(String.valueOf(player1.getName() + "\'s Score: " + player1.getScore()));
        player1.addToItemsList("teddybear");
        player1.addToItemsList("sword");
        player1.addToItemsList("bird");
        player1.removeFromItemsList("sword");
        playerItems.setText(String.valueOf(player1.getName() + "\'s Items: " + player1.getItems()));
        //end examples 
        
        
        //create 25 Gamesquare gameboard
        GameSquare square1 = new GameSquare(false);
        GameSquare square2 = new GameSquare(false);
        GameSquare square3 = new GameSquare(false);
        GameSquare square4 = new GameSquare(false);
        GameSquare square5 = new GameSquare(false);
        GameSquare square6 = new GameSquare(false);
        GameSquare square7 = new GameSquare(false);
        GameSquare square8 = new GameSquare(false);
        GameSquare square9 = new GameSquare(false);
        GameSquare square10 = new GameSquare(false);
        GameSquare square11 = new GameSquare(false);
        GameSquare square12 = new GameSquare(false);
        GameSquare square13 = new GameSquare(false);
        GameSquare square14 = new GameSquare(false);
        GameSquare square15 = new GameSquare(false);
        GameSquare square16 = new GameSquare(false);
        GameSquare square17 = new GameSquare(false);
        GameSquare square18 = new GameSquare(false);
        GameSquare square19 = new GameSquare(false);
        GameSquare square20 = new GameSquare(false);
        GameSquare square21 = new GameSquare(false);
        GameSquare square22 = new GameSquare(false);
        GameSquare square23 = new GameSquare(false);
        GameSquare square24 = new GameSquare(false);
        GameSquare square25 = new GameSquare(false);
        GameSquare square26 = new GameSquare(false);
        GameSquare square27 = new GameSquare(false);
        GameSquare square28 = new GameSquare(false);
        GameSquare square29 = new GameSquare(false);
        GameSquare square30 = new GameSquare(false);
        GameSquare square31 = new GameSquare(false);
        GameSquare square32 = new GameSquare(false);
        GameSquare square33 = new GameSquare(false);
        GameSquare square34 = new GameSquare(false);
        GameSquare square35 = new GameSquare(false);
        GameSquare square36 = new GameSquare(false);
        GameSquare square37 = new GameSquare(false);
        GameSquare square38 = new GameSquare(false);
        GameSquare square39 = new GameSquare(false);
        GameSquare square40 = new GameSquare(false);
        GameSquare square41 = new GameSquare(false);
        GameSquare square42 = new GameSquare(false);
        GameSquare square43 = new GameSquare(false);
        GameSquare square44 = new GameSquare(false);
        GameSquare square45 = new GameSquare(false);
        GameSquare square46 = new GameSquare(false);
        GameSquare square47 = new GameSquare(false);
        GameSquare square48 = new GameSquare(false);
        GameSquare square49 = new GameSquare(false);
        GameSquare square50 = new GameSquare(false);
        
        //add Gamesquares to the gameboard
        grid.add(square1, 0, 0);
        grid.add(square2, 0, 1);
        grid.add(square3, 0, 2);
        grid.add(square4, 0, 3);
        grid.add(square5, 0, 4);
        grid.add(square6, 0, 5);
        grid.add(square7, 0, 6);
        grid.add(square8, 1, 0);
        grid.add(square9, 1, 1);
        grid.add(square10, 1, 2);
        grid.add(square11, 1, 3);
        grid.add(square12, 1, 4);
        grid.add(square13, 1, 5);
        grid.add(square14, 1, 6);
        grid.add(square15, 2, 0);
        grid.add(square16, 2, 1);
        grid.add(square17, 2, 2);
        grid.add(square18, 2, 3);
        grid.add(square19, 2, 4);
        grid.add(square20, 2, 5);
        grid.add(square21, 2, 6);
        grid.add(square22, 3, 0);
        grid.add(square23, 3, 1);
        grid.add(square24, 3, 2);
        grid.add(square25, 3, 3);
        grid.add(square26, 3, 4);
        grid.add(square27, 3, 5);
        grid.add(square28, 3, 6);
        grid.add(square29, 4, 0);
        grid.add(square30, 4, 1);
        grid.add(square31, 4, 2);
        grid.add(square32, 4, 3);
        grid.add(square33, 4, 4);
        grid.add(square34, 4, 5);
        grid.add(square35, 4, 6);
        grid.add(square36, 5, 0);
        grid.add(square37, 5, 1);
        grid.add(square38, 5, 2);
        grid.add(square39, 5, 3);
        grid.add(square40, 5, 4);
        grid.add(square41, 5, 5);
        grid.add(square42, 5, 6);
        grid.add(square43, 6, 0);
        grid.add(square44, 6, 1);
        grid.add(square45, 6, 2);
        grid.add(square46, 6, 3);
        grid.add(square47, 6, 4);
        grid.add(square48, 6, 5);
        grid.add(square49, 6, 6);
        

   
        //GridPane styles
        grid.setPadding(new Insets(0));
        
        GridPane.setHalignment(einstein, HPos.CENTER);
        grid.add(einstein, 0, 0);
        
        //add puzzle locations to the board
        Image torchIcon = new Image("file:images/torch-icon.jpg");
        ImageView torchV = new ImageView(torchIcon);
        //have message span 1 col and 2 rows (params are control, col, row, colspan, rowspan)
        grid.add(torchV, 2, 3, 1, 1);
        GridPane.setHalignment(torchV, HPos.CENTER);
        
        //container box to hold main elements
        VBox stats = new VBox(10, playerScore, playerItems);
        HBox boardDiv = new HBox(10, start, grid, stats);
        VBox container = new VBox(15, playerMessage, playerAlert, boardDiv, directionBtns);
        container.setAlignment(Pos.BASELINE_LEFT);
        container.setPadding(new Insets(25));
        
        //create Scene
        Scene scene = new Scene(container, 900, 600);
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

            playerAlert.setText(("Begin your quest, " + player1.getName() + "! Use Buttons below to move."));
            
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
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, einstein) == 2 && player1.getRowLocation(grid, einstein) == 3) {
                try {
                    Application torches = torchPuzzle.class.newInstance();
                    Stage torchStage = new Stage();
                    torches.start(torchStage);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, einstein) == 2 && player1.getRowLocation(grid, einstein) == 3) {
                try {
                    Application torches = torchPuzzle.class.newInstance();
                    Stage torchStage = new Stage();
                    torches.start(torchStage);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
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
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, einstein) == 2 && player1.getRowLocation(grid, einstein) == 3) {
                try {
                    Application torches = torchPuzzle.class.newInstance();
                    Stage torchStage = new Stage();
                    torches.start(torchStage);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //go west btn handler
    class WestBtnHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle(ActionEvent event) {
            int col = player1.getColumnLocation(grid, einstein);
            int row = player1.getRowLocation(grid, einstein);
            
            if(col > 0) {
                grid.getChildren().remove(einstein);
                grid.add(einstein, col - 1, row);
            }
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, einstein) == 2 && player1.getRowLocation(grid, einstein) == 3) {
                try {
                    Application torches = torchPuzzle.class.newInstance();
                    Stage torchStage = new Stage();
                    torches.start(torchStage);
                } catch (InstantiationException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(GameEngine.class.getName()).log(Level.SEVERE, null, ex);
                }
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
