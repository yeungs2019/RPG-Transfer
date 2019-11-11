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
    Label playerMessage;
    Label playerScore;
    Label playerItems;
    
    //playing grid
    private final int COL_MAX_INDEX = 6;
    private final int ROW_MAX_INDEX = 6;
    GridPane grid = new GridPane();
    Player player1;
    ImageView playerNode;
    String profileImgLocation;
    ImageView torchV;
    
    
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
        
        //directional button controls
        HBox directionBtns = new HBox(10, north, east, south, west, close);      
        directionBtns.setPadding(new Insets(0, 0, 0, 65));
        
        //player message left sidebar 
        playerMessage = new Label();
        playerMessage.setMaxWidth(600);
        playerMessage.setAlignment(Pos.TOP_LEFT);
        playerMessage.setText(("Click Start to Begin!"));
        
        playerScore = new Label();
        playerScore.setAlignment(Pos.TOP_LEFT);
        
        playerItems = new Label();
        playerItems.setAlignment(Pos.TOP_LEFT);
        
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
        grid.setId("board");
        grid.setStyle("-fx-background-image: url('file:images/map-look.jpg'); -fx-background-position: center center; -fx-background-repeat: no-repeat;");
        
        //add puzzle locations to the board
        Image torchIcon = new Image("file:images/flame.png");
        torchV = new ImageView(torchIcon);
        torchV.setOpacity(0.2);
        //have message span 1 col and 2 rows (params are control, col, row, colspan, rowspan)
        grid.add(torchV, 2, 3, 1, 1);
        GridPane.setHalignment(torchV, HPos.CENTER);
        
        //container box to hold main elements
        VBox stats = new VBox(10, playerScore, playerItems);
        HBox boardDiv = new HBox(10, start, grid, stats);
        VBox container = new VBox(50, playerMessage, boardDiv, directionBtns);
        container.setAlignment(Pos.BASELINE_LEFT);
        container.setPadding(new Insets(25));
        
        //create Scene
        Scene scene = new Scene(container, 900, 700);
        scene.getStylesheets().add("rpg-styles.css");

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

            profileImgLocation = GetInfoStage.profile("Choose Player Profile", "Click which player you want to be:");
            player1 = new Player("Player 1", profileImgLocation);
            playerNode = player1.getProfile();
            GridPane.setHalignment(playerNode, HPos.CENTER);
            grid.add(playerNode, 0, 0);
            playerScore.setText(String.valueOf(player1.getName() + "\'s Score: " + player1.getScore()));
            playerItems.setText(String.valueOf(player1.getName() + "\'s Items: " + player1.getItems()));
            
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
            
            int col = player1.getColumnLocation(grid, playerNode);
            int row = player1.getRowLocation(grid, playerNode);
            
            if(row > 0) {
                grid.getChildren().remove(playerNode);
                grid.add(playerNode, col, row - 1);
            }
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, playerNode) == 2 && player1.getRowLocation(grid, playerNode) == 3) {
                try {
                    torchV.setOpacity(1);
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
            int col = player1.getColumnLocation(grid, playerNode);
            int row = player1.getRowLocation(grid, playerNode);
            
            if(col < COL_MAX_INDEX) {
                grid.getChildren().remove(playerNode);
                grid.add(playerNode, col + 1, row);
            }
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, playerNode) == 2 && player1.getRowLocation(grid, playerNode) == 3) {
                try {
                    torchV.setOpacity(1);
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
            int col = player1.getColumnLocation(grid, playerNode);
            int row = player1.getRowLocation(grid, playerNode);
            
            if(row < ROW_MAX_INDEX) {
                grid.getChildren().remove(playerNode);
                grid.add(playerNode, col, row + 1);
            }
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, playerNode) == 2 && player1.getRowLocation(grid, playerNode) == 3) {
                try {
                    torchV.setOpacity(1);
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
            int col = player1.getColumnLocation(grid, playerNode);
            int row = player1.getRowLocation(grid, playerNode);
            
            if(col > 0) {
                grid.getChildren().remove(playerNode);
                grid.add(playerNode, col - 1, row);
            }
            
            //start torch puzzle
            if(player1.getColumnLocation(grid, playerNode) == 2 && player1.getRowLocation(grid, playerNode) == 3) {
                try {
                    torchV.setOpacity(1);
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
