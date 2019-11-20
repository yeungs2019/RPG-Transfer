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
    Image pillar;
    
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
    ImageView pillar1 = new ImageView();
    ImageView pillar2 = new ImageView();
    ImageView pillar3 = new ImageView();
    
    // Labels for things
    Label ringSelection = new Label("");
    Label pillarSelection = new Label("");
    Label display = new Label("");
    
    // Variables to keep track of ring locations (Pillar wise)
    int redRingLoc = 1;
    int blueRingLoc = 1;
    int greenRingLoc = 1;
    int yellowRingLoc = 1;
    
    // Direction currently on
    int directionNumber = 0;
    
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
        pillar = new Image("file:images/pillar.png");
        
        pillar1Ring1.setFitWidth(100);
        pillar1Ring1.setFitHeight(25);
        pillar1Ring2.setFitWidth(100);
        pillar1Ring2.setFitHeight(25);
        pillar1Ring3.setFitWidth(100);
        pillar1Ring3.setFitHeight(25);
        pillar1Ring4.setFitWidth(100);
        pillar1Ring4.setFitHeight(25);
        pillar2Ring1.setFitWidth(100);
        pillar2Ring1.setFitHeight(25);
        pillar2Ring2.setFitWidth(100);
        pillar2Ring2.setFitHeight(25);
        pillar2Ring3.setFitWidth(100);
        pillar2Ring3.setFitHeight(25);
        pillar2Ring4.setFitWidth(100);
        pillar2Ring4.setFitHeight(25);
        pillar3Ring1.setFitWidth(100);
        pillar3Ring1.setFitHeight(25);
        pillar3Ring2.setFitWidth(100);
        pillar3Ring2.setFitHeight(25);
        pillar3Ring3.setFitWidth(100);
        pillar3Ring3.setFitHeight(25);
        pillar3Ring4.setFitWidth(100);
        pillar3Ring4.setFitHeight(25);
        
        // Setting start point and giving directions
        Label description = new Label ("In front of you are several pillars with"
                + " different colored rings attached.");
        
        ringSelection.setText("");
        pillarSelection.setText("");
        display.setText("");
        resetRings();
        
        // Buttons to select the rings
        Button selectRed = new Button("Select Red Ring");
        selectRed.setOnAction(new selectRedHandler());
        Button selectBlue = new Button("Select Blue Ring");
        selectBlue.setOnAction(new selectBlueHandler());
        Button selectYellow = new Button("Select Yellow Ring");
        selectYellow.setOnAction(new selectYellowHandler());
        Button selectGreen = new Button("Select Green Ring");
        selectGreen.setOnAction(new selectGreenHandler());
        
        // Buttons to select pillars
        Button pillar1 = new Button("Select Pillar 1");
        pillar1.setOnAction(new selectPillar1Handler());
        Button pillar2 = new Button("Select Pillar 2");
        pillar2.setOnAction(new selectPillar2Handler());
        Button pillar3 = new Button("Select Pillar 3");
        pillar3.setOnAction(new selectPillar3Handler());
        
        // Move button
        Button move = new Button("Move");
        move.setOnAction(new moveHandler());
        
        // Leave button
        Button leave = new Button("Leave");
        leave.setOnAction(e-> {
            primaryStage.close();
        });
        
        // Reset button
        Button reset = new Button("Reset Rings");
        reset.setOnAction(new resetHandler());
        
        // Submit button
        Button submit = new Button("Submit arrangement");
        submit.setOnAction(new submitHandler());
        
        // Get directions button
        Button getDirections = new Button ("Get directions");
        getDirections.setOnAction(new directionHandler());
        
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
        description.setAlignment(Pos.CENTER);
        display.setAlignment(Pos.CENTER);
        pillars.setAlignment(Pos.CENTER);
        ringSelection.setAlignment(Pos.CENTER);
        pillarSelection.setAlignment(Pos.CENTER);
        ringSelectionBox.setAlignment(Pos.CENTER);
        pillarSelectionBox.setAlignment(Pos.CENTER);
        userInteractionBox.setAlignment(Pos.CENTER);
        screen.setAlignment(Pos.CENTER);
        
        // Creating the scene and displaying
        Scene scene = new Scene(screen, 950, 600);
        
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("rpg-styles.css");
        
        primaryStage.setTitle("A series of pillars with"
                + " several rings attached.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void resetRings() {
        
        // Resetting ring values
        redRingLoc = 1;
        blueRingLoc = 1;
        yellowRingLoc = 1;
        greenRingLoc = 1;
        
        checkImg();
        
        return;
    }
    
    public void checkImg() {
        
        // Red ring check
        if(redRingLoc == 1)
        {
            pillar1Ring1.setImage(redRing);
            pillar2Ring1.setImage(null);
            pillar3Ring1.setImage(null);
        }
        else if (redRingLoc == 2)
        {
            pillar1Ring1.setImage(null);
            pillar2Ring1.setImage(redRing);
            pillar3Ring1.setImage(null);
        }
        else if (redRingLoc == 3)
        {
            pillar1Ring1.setImage(null);
            pillar2Ring1.setImage(null);
            pillar3Ring1.setImage(redRing);
        }
        
        // Blue ring check
        if(blueRingLoc == 1)
        {
            pillar1Ring2.setImage(blueRing);
            pillar2Ring2.setImage(null);
            pillar3Ring2.setImage(null);
        }
        else if (blueRingLoc == 2)
        {
            pillar1Ring2.setImage(null);
            pillar2Ring2.setImage(blueRing);
            pillar3Ring2.setImage(null);
        }
        else if (blueRingLoc == 3)
        {
            pillar1Ring2.setImage(null);
            pillar2Ring2.setImage(null);
            pillar3Ring2.setImage(blueRing);
        }
        
        // Green ring check
        if(greenRingLoc == 1)
        {
            pillar1Ring3.setImage(greenRing);
            pillar2Ring3.setImage(null);
            pillar3Ring3.setImage(null);
        }
        else if (greenRingLoc == 2)
        {
            pillar1Ring3.setImage(null);
            pillar2Ring3.setImage(greenRing);
            pillar3Ring3.setImage(null);
        }
        else if (greenRingLoc == 3)
        {
            pillar1Ring3.setImage(null);
            pillar2Ring3.setImage(null);
            pillar3Ring3.setImage(greenRing);
        }
        
        // Yellow ring check
        if(yellowRingLoc == 1)
        {
            pillar1Ring4.setImage(yellowRing);
            pillar2Ring4.setImage(null);
            pillar3Ring4.setImage(null);
        }
        else if (yellowRingLoc == 2)
        {
            pillar1Ring4.setImage(null);
            pillar2Ring4.setImage(yellowRing);
            pillar3Ring4.setImage(null);
        }
        else if (yellowRingLoc == 3)
        {
            pillar1Ring4.setImage(null);
            pillar2Ring4.setImage(null);
            pillar3Ring4.setImage(yellowRing);
        }
    }
    
    public boolean checkAnswer() {
        if(redRingLoc == 3 && blueRingLoc == 3 && greenRingLoc == 3 && 
                yellowRingLoc == 3)
        {
            solved = true;
            display.setText("You did it!");
        }
        else
        {
            display.setText("Something is not quite right...");
        }
        
        return solved;
    }
    
    public boolean getSolved() {
        return solved;
    }
    
    public void redLogic() {
        
        if(ringSelected == "RED" && pillarSelected == "PILLAR 1")
            redRingLoc = 1;
        if(ringSelected == "RED" && pillarSelected == "PILLAR 2")
            redRingLoc = 2;
        if(ringSelected == "RED" && pillarSelected == "PILLAR 3")
            redRingLoc = 3;
        
        checkImg();
        
        return;
    }
    
    public void blueLogic() {
        
        if(ringSelected == "BLUE" && pillarSelected == "PILLAR 1")
            blueRingLoc = 1;
        if(ringSelected == "BLUE" && pillarSelected == "PILLAR 2")
            blueRingLoc = 2;
        if(ringSelected == "BLUE" && pillarSelected == "PILLAR 3")
            blueRingLoc = 3;
        
        checkImg();
        
        return;
    }
    
    public void greenLogic() {
        
        if(ringSelected == "GREEN" && pillarSelected == "PILLAR 1")
            greenRingLoc = 1;
        if(ringSelected == "GREEN" && pillarSelected == "PILLAR 2")
            greenRingLoc = 2;
        if(ringSelected == "GREEN" && pillarSelected == "PILLAR 3")
            greenRingLoc = 3;
        
        checkImg();
        
        return;
    }
    
    public void yellowLogic() {
        
        if(ringSelected == "YELLOW" && pillarSelected == "PILLAR 1")
            yellowRingLoc = 1;
        if(ringSelected == "YELLOW" && pillarSelected == "PILLAR 2")
            yellowRingLoc = 2;
        if(ringSelected == "YELLOW" && pillarSelected == "PILLAR 3")
            yellowRingLoc = 3;
        
        checkImg();
        
        return;
    }
    
    public void puzzleLogicPre() {
        
        redLogic();
        
        if(redRingLoc != blueRingLoc)
        {
            blueLogic();
            puzzleLogicBlue();
        }
        
        if(redRingLoc != greenRingLoc && blueRingLoc != greenRingLoc)
        {
            greenLogic();
            puzzleLogicGreen();
        }
        
        if(redRingLoc != yellowRingLoc && blueRingLoc != yellowRingLoc &&
                greenRingLoc != yellowRingLoc)
        {
            yellowLogic();
            puzzleLogicYellow();
        }
        
        return;
    }
    
    public void puzzleLogicBlue () {
        
        if(redRingLoc == blueRingLoc)
        {
            resetRings();
            display.setText("The rings overloaded!");
        }
        
        return;
    }
    
    public void puzzleLogicGreen() {
        
        if (redRingLoc == greenRingLoc || blueRingLoc == greenRingLoc)
        {
            resetRings();
            display.setText("The rings overloaded!");
        }
        
        return;
    }
    
    public void puzzleLogicYellow() {
        
        if(redRingLoc == yellowRingLoc || blueRingLoc == yellowRingLoc ||
                greenRingLoc == yellowRingLoc)
        {
            resetRings();
            display.setText("The rings overloaded!");
        }
    }
    
    class directionHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            
            if (directionNumber == 0)
            {
                display.setText("The rings start on the leftmost pillar "
                        + "(pillar 1) and are represented by the different "
                        + "colored boxes. Click 'Get directions' "
                        + "again to see more.");
                directionNumber++;
            }
            else if(directionNumber == 1)
            {
                display.setText("Rings can only be moved if there are no rings"
                        + " above the ring you wish to move.");
                directionNumber++;
            }
            else if(directionNumber == 2)
            {
                display.setText("To move a ring, first select a ring, then "
                        + "select a pillar. After you are done selecting, click"
                        + " the 'Move' button to finalize your selections.");
                directionNumber++;
            }
            else if(directionNumber == 3)
            {
                display.setText("Be careful! Rings can only be "
                        + "moved certain ways...");
                directionNumber++;
            }
            else if(directionNumber == 4)
            {
                display.setText("The red ring, for example, can be moved to "
                        + "any pillar without consequence.");
                directionNumber++;
            }
            else if(directionNumber == 5)
            {
                display.setText("The blue ring can only safely be moved"
                + " to a pillar as long as the red ring is not"
                + " present on that pillar.");
                directionNumber++;
            }
            else if(directionNumber == 6)
            {
                display.setText("The green ring can only safely be moved"
                + " to a pillar that has no rings, or only a yellow ring.");
                directionNumber++;
            }
            else if(directionNumber == 7)
            {
                display.setText("The yellow ring can only safely be"
                + " moved to a pillar that has no rings.");
                directionNumber++;
            }
            else if(directionNumber == 8)
            {
                display.setText("'It seems I need to move all the rings"
                + " to the rightmost pillar.'");
                directionNumber++;
            }
            else if(directionNumber == 9)
            {
                display.setText("");
                directionNumber = 0;
            }
        }
    }
    
    class selectRedHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            ringSelection.setText("Red ring selected");
            ringSelected = "RED";
        }
    }
    
    class selectBlueHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            ringSelection.setText("Blue ring selected");
            ringSelected = "BLUE";
        }
    }
    
    class selectGreenHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            ringSelection.setText("Green ring selected");
            ringSelected = "GREEN";
        }
    }
    
    class selectYellowHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            ringSelection.setText("Yellow ring selected");
            ringSelected = "YELLOW";
        }
    }
    
    class selectPillar1Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pillarSelection.setText("Pillar 1 selected");
            pillarSelected = "PILLAR 1";
        }
    }
    
    class selectPillar2Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pillarSelection.setText("Pillar 2 selected");
            pillarSelected = "PILLAR 2";
        }
    }
    
    class selectPillar3Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pillarSelection.setText("Pillar 3 selected");
            pillarSelected = "PILLAR 3";
        }
    }
    
    class submitHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            checkAnswer();
        }
    }
    
    class resetHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            resetRings();
        }
    }
    
    class moveHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            display.setText("");
            puzzleLogicPre();
        }
    }
}
