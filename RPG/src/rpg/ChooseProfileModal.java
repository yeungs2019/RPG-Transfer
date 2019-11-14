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
public class ChooseProfileModal {
    
    static String profileLocation;
    
    public static String profile (String title, String message) {
           
        Stage popupStage = new Stage();
    
        //set up so player has to make a choice to continue or close modal
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        
        //instruction
        Label msg = new Label();
        msg.setText(message);
        
        //create profile images
        Image profileOneImg = new Image("file:images/axiel.png");
        ImageView profileOneIcon = new ImageView(profileOneImg);
        Image profileTwoImg = new Image("file:images/spykrull.png");
        ImageView profileTwoIcon = new ImageView(profileTwoImg);
        Image profileThreeImg = new Image("file:images/spiriticus.png");
        ImageView profileThreeIcon = new ImageView(profileThreeImg);
        
        //button for profile choice
        Button profileOne = new Button("Axiel");
        Button profileTwo = new Button("Spykrull");
        Button profileThree = new Button("Spiriticus");
        
        //learning lambdas - one line can go right after the arrow - more than one line of code needs to be in curly {}
        profileOne.setOnAction(e -> {
            profileLocation = "file:images/axiel.png";
            popupStage.close();
        });
        
        profileTwo.setOnAction(e -> {
            profileLocation = "file:images/spykrull.png";
            popupStage.close();
        });
        
        profileThree.setOnAction(e -> {
            profileLocation = "file:images/spiriticus.png";
            popupStage.close();
        });
        
        VBox profileOneBox = new VBox(10, profileOneIcon, profileOne);
        VBox profileTwoBox = new VBox(10, profileTwoIcon, profileTwo);
        VBox profileThreeBox = new VBox(10, profileThreeIcon, profileThree);
        profileOneBox.setAlignment(Pos.CENTER);
        profileTwoBox.setAlignment(Pos.CENTER);
        profileThreeBox.setAlignment(Pos.CENTER);
        
        HBox profiles = new HBox(10, profileOneBox, profileTwoBox, profileThreeBox);
        profiles.setAlignment(Pos.CENTER);
                
        VBox container = new VBox(15);
        container.getChildren().addAll(msg, profiles);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(25));
        
        Scene scene = new Scene(container, 500, 400);
        scene.getStylesheets().add("rpg-styles.css");
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
        return profileLocation;
        
    }
       
}
