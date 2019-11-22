/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 * 
 * creating a pop up stage for messages to player that need acknowledging
 */
public class WinModal {
    
    public static void display (String name) {
           
        Stage popupStage = new Stage();
    
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Congratulations!");
        
        Image win = new Image("file:images/win.png");
        ImageView winV = new ImageView(win);
        
        Label mess = new Label();
        mess.setId("winLabel");
        mess.setTextAlignment(TextAlignment.CENTER);
        mess.setText("Awesome, " + name + "! \nYou Win!!");
        
        Button ok = new Button("OK");
        //learning lambdas - one line can go right after the arrow - more than one line of code needs to be in curly {}
        ok.setOnAction(e -> popupStage.close());
        
        VBox container = new VBox(10);
        container.getChildren().addAll(mess, winV, ok);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(25));
        
        Scene scene = new Scene(container, 500, 400);
        scene.getStylesheets().add("rpg-styles.css");
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
    }
   
}
