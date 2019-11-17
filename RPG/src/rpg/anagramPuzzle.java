/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Ethan Powell
 */
public class anagramPuzzle extends Application {
    protected boolean solved = false;
    private String correctAnswer = "Cornucopia";
    private String playerAnswer = "";
    private TextField inputBox = new TextField();
    private Label display = new Label ("");
    
    @Override
    public void start(Stage primaryStage) {
        
        // Submit button
        Button submit = new Button("Speak your answer aloud");
        submit.setOnAction(new submitHandler());
        
        // Anagram prompt
        Label line1 = new Label ("OINCOPCAUR");
        
        line1.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        
        VBox prompt = new VBox (line1);
        prompt.setAlignment(Pos.CENTER);
       
        // Text box
        HBox textBox = new HBox (inputBox);
        textBox.setMaxWidth(250);
        textBox.setAlignment(Pos.CENTER);
        
        // Leave button
        Button leave = new Button ("Leave");
        leave.setOnAction(e-> {
            primaryStage.close();
        });
        
        // HBox for submit and leave
        HBox buttonBox = new HBox (10, submit, leave);
        buttonBox.setAlignment(Pos.CENTER);
        
        // Whole Screen to be displayed
        VBox screen = new VBox (prompt, textBox, buttonBox, display);
        display.setFont(Font.font("Verdana", 20));
        screen.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(screen, 625, 500);
        
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("rpg-styles.css");
        
        primaryStage.setTitle("A wall with with a strange inscription");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    class submitHandler implements EventHandler<ActionEvent> {
        
        @Override
        public void handle (ActionEvent event) {
            
            playerAnswer = inputBox.getText();
            if(checkAnswer())
            {
                display.setText("You did it!");
                // Update player score here
            }
            else
                display.setText("Something is not right...");
        }
    }
    
    private boolean checkAnswer()
    {
        if(correctAnswer.equalsIgnoreCase(inputBox.getText()))
            solved = true;
        else
            solved = false;
        
        return solved;
    }
    
    public boolean isSolved()
    {
        return solved;
    }
}
