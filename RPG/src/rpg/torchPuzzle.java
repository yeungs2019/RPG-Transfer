/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Ethan Powell
 */
public class torchPuzzle extends Application {
    private Image litTorch;
    private Image unlitTorch;
    
    private ImageView torch1Img = new ImageView();
    private ImageView torch2Img = new ImageView();
    private ImageView torch3Img = new ImageView();
    private ImageView torch4Img = new ImageView();
    private ImageView torch5Img = new ImageView();
    
    
    private HBox torches;
    
    // Making the torch variables
    private boolean torch1 = false;
    private boolean torch2 = false; 
    private boolean torch3 = false;
    private boolean torch4 = false;
    private boolean torch5 = false;
    
    // Button states (1 = true, 2 = false)
    private boolean button1State = true;
    private boolean button2State = true;
    private boolean button3State = false;
    private boolean button4State = true;
    
    // Is the puzzle solved or not
    protected boolean solved = false;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Putting the images in the program
        litTorch = new Image(new FileInputStream ("LitTorch.jpg"));
        unlitTorch = new Image (new FileInputStream ("UnlitTorch.jpg"));
        
        torch1Img.setImage(unlitTorch);
        torch2Img.setImage(unlitTorch);
        torch3Img.setImage(unlitTorch);
        torch4Img.setImage(unlitTorch);
        torch5Img.setImage(unlitTorch);
        
        torch1Img.setFitHeight(400);
        torch1Img.setFitWidth(275);
        
        torch2Img.setFitHeight(400);
        torch2Img.setFitWidth(275);
        
        torch3Img.setFitHeight(400);
        torch3Img.setFitWidth(275);
        
        torch4Img.setFitHeight(400);
        torch4Img.setFitWidth(275);
        
        torch5Img.setFitHeight(400);
        torch5Img.setFitWidth(275);
        
        // Creating the buttons for the user to press
        Button button1 = new Button("Button 1");
        button1.setOnAction(new button1Handler());
        Button button2 = new Button("Button 2");
        button2.setOnAction(new button2Handler());
        Button button3 = new Button("Button 3");
        button3.setOnAction(new button3Handler());
        Button button4 = new Button("Button 4");
        button4.setOnAction(new button4Handler());
        
        
        
        
        
       
        // Creating some boxes to hold the objects
        HBox buttonHolder = new HBox(10, button1, button2, button3, button4);
        torches = new HBox(10, torch1Img, torch2Img, torch3Img, 
                torch4Img, torch5Img);
        VBox screen = new VBox(10, torches, buttonHolder);
        
        // Setting the allignment
        buttonHolder.setAlignment(Pos.CENTER);
        torches.setAlignment(Pos.CENTER);
        screen.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(screen, 300, 250);
        
        primaryStage.setTitle("A wall of Torches");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    class button1Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pushButton1();
        }
    }
    
    class button2Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pushButton2();
        }
    }
    
    class button3Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pushButton3();
        }
    }
    
    class button4Handler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            pushButton4();
        }
    }
    
    public boolean getTorch1() {
        return torch1;
    }

    public boolean getTorch2() {
        return torch2;
    }

    public boolean getTorch3() {
        return torch3;
    }

    public boolean getTorch4() {
        return torch4;
    }

    public boolean getTorch5() {
        return torch5;
    }
    
    public boolean isSolved() {
        // Check to see if all torches are on
        if(torch1 == true && torch1 == true && torch1 == true && 
                torch1 == true && torch1 == true)
        {
            solved = true;
        }
            
        return solved;
    }
    
    private boolean switchThis (boolean obj) {
        if (obj == true)
            obj = false;
        else
            obj = true;
        
        return obj;
    }
    
    private void changeTorches () {
        if (torch1 == true)
            torch1Img.setImage(litTorch);
        else
            torch1Img.setImage(unlitTorch);
        
        if (torch2 == true)
            torch2Img.setImage(litTorch);
        else
            torch2Img.setImage(unlitTorch);
        
        if (torch3 == true)
            torch3Img.setImage(litTorch);
        else
            torch3Img.setImage(unlitTorch);
        
        if (torch4 == true)
            torch4Img.setImage(litTorch);
        else
            torch4Img.setImage(unlitTorch);
        
        if (torch5 == true)
            torch5Img.setImage(litTorch);
        else
            torch5Img.setImage(unlitTorch);
        
        return;
    }
    
    public void pushButton1 () {
        
        // Puzzle logic for button 1
        if(button1State == true)
        {
        torch1 = switchThis(torch1);
        torch3 = switchThis(torch3);
        }
        else
        {
            torch4 = switchThis(torch4);
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button1State = switchThis(button1State);
        // Changing the torch imgages
        changeTorches();
        
        return;
    }
    
    public void pushButton2 () {
        
        // Puzzle logic for button 2
        if(button2State == true)
        {
            torch2 = switchThis(torch2);
            torch3 = switchThis(torch3);
            torch5 = switchThis(torch5);
        }
        else
        {
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button2State = switchThis(button2State);
        // Changing the torch imgages
        changeTorches();
        
        return;
    }
    
    public void pushButton3 () {
        
        // Puzzle logic for button 3
        if(button3State == true)
        {
            torch1 = switchThis(torch1);
            torch3 = switchThis(torch3);
            torch4 = switchThis(torch4);
        }
        else
        {
            torch1 = switchThis(torch1);
        }
        
        // Changing the button state
        button2State = switchThis(button3State);
        // Changing the torch imgages
        changeTorches();
        
        return;
    }
    
    public void pushButton4 () {
        
        // Puzzle logic for button 4
        if(button4State == true)
        {
            torch1 = switchThis(torch1);
            torch2 = switchThis(torch2);
        }
        else
        {
            torch1 = switchThis(torch1);
            torch3 = switchThis(torch3);
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button2State = switchThis(button4State);
        // Changing the torch imgages
        changeTorches();
        
        return;
    }
    
}
