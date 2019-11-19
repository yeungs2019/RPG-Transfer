/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Ethan Powell
 */
public class chessPuzzle extends Application {
    
    // Images
    private Image boardStart;
    private Image move1;
    private Image checkmate;
    
    // ImageView
    private ImageView imageDisplay = new ImageView();
    
    // TextField
    TextField input;
    
    // Move number tracker
    int move = 0;
    
    // Resoponse label
    Label response;
    
    // Solved boolean
    protected boolean solved = false;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        // Loading the images for the program
        boardStart = new Image("file:images/boardStart.JPG");
        move1 = new Image("file:images/move1.JPG");
        checkmate = new Image("file:images/checkmate.JPG");
        
        // Setting the starting look for the app and setting start move
        imageDisplay.setImage(boardStart);
        move = 0;
        imageDisplay.setFitWidth(500);
        imageDisplay.setFitHeight(500);
        
        // Prompt for user
        Label description1 = new Label ("You approach a small chessboard "
                + "atop a little table.");
        Label description2 = new Label ("The pieces seem to be placed as if the"
                + " game has already begun...");
        
        // Directions for user input
        Label direction1 = new Label ("Please enter a move with the piece name"
                + " and location first, then the square to move to.");
        Label direction2 = new Label ("Ex. A2 Pawn A3");
                
        // Feedback for user moves
        response = new Label ("");
        
        // Leave button
        Button leave = new Button ("Leave");
        leave.setOnAction(e-> {
            move = 0;
            primaryStage.close();
        });
        
        // Submit button
        Button submit = new Button ("Pass turn");
        submit.setOnAction(new submitHandler());
        
        // Textbox to enter move
        input = new TextField();
        
        // Boxes to hold things
        VBox image = new VBox (description1, description2, imageDisplay);
        image.setAlignment(Pos.CENTER);
        HBox userInteraction = new HBox (20, input, submit, leave);
        userInteraction.setAlignment(Pos.CENTER);
        VBox screen = new VBox (image, direction1, direction2, userInteraction,
            response);
        screen.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(screen, 925, 850);
        
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("rpg-styles.css");
        
        primaryStage.setTitle("A strange chess game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    class submitHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            
                // Creating a single string to hold our input 
                // without excess whitespace
                String userString = input.getText().trim();

                // Splitting the string by the spaces
                String splitString[] = userString.split(" ", 3);
                
                // Checking if the move is correct or not
                if(splitString[0].equalsIgnoreCase("E5") && 
                        (splitString[1].equalsIgnoreCase("Knight") ||
                         splitString[1].equalsIgnoreCase("K") ||
                         splitString[1].equalsIgnoreCase("Horse") ||
                         splitString[1].equalsIgnoreCase("H")) &&
                         splitString[2].equalsIgnoreCase("G6") &&
                        move == 0)
                {
                    response.setText("The opponent's king magically "
                            + " moves into place");
                    imageDisplay.setImage(move1);
                    move++;
                }
                else if (splitString[0].equalsIgnoreCase("G6") && 
                        (splitString[1].equalsIgnoreCase("Knight") ||
                         splitString[1].equalsIgnoreCase("K") ||
                         splitString[1].equalsIgnoreCase("Horse") ||
                         splitString[1].equalsIgnoreCase("H")) &&
                         splitString[2].equalsIgnoreCase("H8") && 
                        move == 1)
                {
                    response.setText("Checkmate!");
                    imageDisplay.setImage(checkmate);
                    solved = true;
                    move++;
                }
                else
                    response.setText("Nothing seems to happen...");
        }
    }
    
    public boolean isSolved()
    {
        return solved;
    }
}
