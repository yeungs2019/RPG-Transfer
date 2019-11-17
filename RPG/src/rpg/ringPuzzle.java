/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class ringPuzzle extends Application {
    
    // Getting the images ready to be loaded
    Image redRing;
    Image blueRing;
    Image greenRing;
    Image yellowRing;
    
    // Creating imageViews for each possible outcome
    ImageView pillar1Ring1 = new ImageView();
    ImageView pillar1Ring2 = new ImageView();
    ImageView pillar1Ring3 = new ImageView();
    ImageView pillar1Ring4 = new ImageView();
    ImageView pillar2Ring1 = new ImageView();
    ImageView pillar2Ring2 = new ImageView();
    ImageView pillar2Ring3 = new ImageView();
    ImageView pillar2Ring4 = new ImageView();
    ImageView pillar3Ring1 = new ImageView();
    ImageView pillar3Ring2 = new ImageView();
    ImageView pillar3Ring3 = new ImageView();
    ImageView pillar3Ring4 = new ImageView();
    
    // Labels for things
    Label ringSelection = new Label();
    Label pillarSelection = new Label();
    Label display = new Label();
    
    // Variables to keep track of ring locations (Pillar wise)
    int redRingLoc = 1;
    int blueRingLoc = 1;
    int greenRingLoc = 1;
    int yellowRingLoc = 1;
    
    // Ring selection variable
    String ringSelected = "";
    
    // Pillar selection variable
    String pillarSelected = "";
    
    // Solved boolean
    protected boolean solved = false;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        
        // Loading the images in to the program
        redRing = new Image("file:images/red.png");
        blueRing = new Image("file:images/blue.jpg");
        greenRing = new Image("file:images/green.jpg");
        yellowRing = new Image("file:images/yellow.jpg");
        
        // Setting start point and giving directions
        Label description = new Label ("In front of you are several pillars with "
                + " different colored rings attached.");
        Label promptRed = new Label ("The red ring can be moved to any pillar"
                + " without consequence.");
        Label promptBlue = new Label ("The blue ring can only safely be moved "
                + " to a pillar as long as the red ring is not "
                + " present on that pillar.");
        Label promptGreen = new Label ("The green ring can only safely be moved"
                + " to a pillar that has no rings, or only a yellow ring");
        Label promptYellow = new Label ("The yellow ring can only safely be "
                + " moved to a pillar that has no rings");
        Label prompt = new Label ("'It seems I need to move all the rings"
                + " to the rightmost pillar'");
        
        ringSelection.setText("");
        pillarSelection.setText("");
        display.setText("");
        resetRings();
        
        // Buttons to select the rings
        Button selectRed = new Button("Select Red Ring");
        Button selectBlue = new Button("Select Blue Ring");
        Button selectYellow = new Button("Select Yellow Ring");
        Button selectGreen = new Button("Select Green Ring");
        
        // Buttons to select pillars
        Button pillar1 = new Button("Select Pillar 1");
        Button pillar2 = new Button("Select Pillar 2");
        Button pillar3 = new Button("Select Pillar 3");
        
        // Move button
        Button move = new Button("Move");
        
        // Leave button
        Button leave = new Button("Leave");
        
        // Reset button
        Button reset = new Button("Reset Rings");
        
        // Submit button
        Button submit = new Button("Submit arrangement");
        
        // Get directions button
        Button getDirections = new Button ("Get directions");
        
        // First some boxes to hold the images
        
        // Pillar 1 box
        VBox pillar1Box = new VBox (20, pillar1Ring1, pillar1Ring2, 
                pillar1Ring3, pillar1Ring4);
        
        // Pillar 2 box
        VBox pillar2Box = new VBox (20, pillar2Ring1, pillar2Ring2, 
                pillar2Ring3, pillar2Ring4);
        
        // Pillar 3 box
        VBox pillar3Box = new VBox (20, pillar3Ring1, pillar3Ring2, 
                pillar3Ring3, pillar3Ring4);
        
        // Pillar Hbox
        HBox pillars = new HBox (50, pillar1Box, pillar2Box, pillar3Box);
        
        // Ring selection button box
        HBox ringSelectionBox = new HBox (10, selectRed, selectBlue, 
                selectGreen, selectYellow);
        
        // Pillar selection box
        HBox pillarSelectionBox = new HBox (10, pillar1, pillar2, pillar3);
        
        // Leave and submit button box
        HBox userInteractionBox = new HBox (10, move, reset, submit, 
                getDirections, leave);
        
        // Total screen box
        VBox screen = new VBox (10, description, display, pillars, 
                ringSelection, pillarSelection, ringSelectionBox, 
                pillarSelectionBox, userInteractionBox);
        
        //Setting Allignment for look
        
        
        // Creating the scene and displaying
        Scene scene = new Scene(screen, 1375, 600);
        
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("rpg-styles.css");
        
        primaryStage.setTitle("A series of pillars with "
                + " several rings attached");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void resetRings() {
        pillar1Ring1.setImage(redRing);
        pillar1Ring2.setImage(blueRing);
        pillar1Ring3.setImage(yellowRing);
        pillar1Ring4.setImage(greenRing);
        
        return;
    }
}
