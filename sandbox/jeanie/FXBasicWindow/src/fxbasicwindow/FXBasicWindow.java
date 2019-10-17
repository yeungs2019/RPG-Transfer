/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxbasicwindow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 */
public class FXBasicWindow extends Application {

    /**
     * @param args the command line arguments
     * 
     */
    
    Button button;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the Stage Window");
        
        button = new Button();
        button.setText("Get torch");
        
        //layout - this will position button in the middle
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        
        //create the scene - 1st param is layout (how do you want arranged) then the dimensions are next 2 params
        Scene scene = new Scene(layout, 300, 250);
        //remember - primary stage is the main wundow - param says which scene to use for that stage
        primaryStage.setScene(scene);
        //display to the user
        primaryStage.show();
        
        
    }
    
}
