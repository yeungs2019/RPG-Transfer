/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 * 
 * creating a pop up stage for messages to player that need acknowledging
 */
public class GetInfoStage {
    
    static String profileLocation;
    
    public static String profile (String title, String message) {
           
        Stage popupStage = new Stage();
    
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        
        Label msg = new Label();
        msg.setText(message);
        
        Button dragon = new Button("Dragon");
        Button wizard = new Button("Wizard");
        Button troll = new Button("Troll");
        
        //learning lambdas - one line can go right after the arrow - more than one line of code needs to be in curly {}
        dragon.setOnAction(e -> {
            profileLocation = "file:images/dragon.png";
            popupStage.close();
        });
        
        wizard.setOnAction(e -> {
            profileLocation = "file:images/wizard.png";
            popupStage.close();
        });
        
        troll.setOnAction(e -> {
            profileLocation = "file:images/troll.png";
            popupStage.close();
        });
        
        HBox profiles = new HBox(10, dragon, wizard, troll);
        profiles.setAlignment(Pos.CENTER);
                
        VBox container = new VBox(15);
        container.getChildren().addAll(msg, profiles);
        container.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(container, 500, 400);
        scene.getStylesheets().add("rpg-styles.css");
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
        return profileLocation;
        
    }
    

    
}
