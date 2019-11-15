/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Ethan Powell
 */
public class chessPuzzle extends Application {
    
    private Image boardBegin;
    private Image move1;
    private Image checkmate;
    
    private ImageView boardStart = new ImageView();
    private ImageView moveOne = new ImageView();
    private ImageView boardFinish = new ImageView();
    
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        boardBegin = new Image(new FileInputStream(""));
        move1 = new Image(new FileInputStream(""));
        //checkmate = new Image new FileInputStream(""));
        
        Label description = new Label ("You approach a small chessboard "
                + "atop a little table. The pieces seemed to be places as if the"
                + "game has already begun");
        
        
        Scene scene = new Scene(null, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
