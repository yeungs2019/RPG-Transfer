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
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jeanieherold
 * 
 * creating a pop up stage for messages to player that need acknowledging
 */
public class PlayerInputModal {
    
    static String playerInputStr;
    
    public static String playerInput (String title, String message) {
           
        Stage popupStage = new Stage();
    
        //player must interact or close modal
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle(title);
        
        Label mess = new Label();
        mess.setText(message);

        TextField playerInputField = new TextField();
        
        Button ok = new Button("OK");
        //learning lambdas - one line can go right after the arrow - more than one line of code needs to be in curly {}
        ok.setOnAction(e -> {
            playerInputStr = playerInputField.getText();
            popupStage.close();
        });
               
        VBox container = new VBox(10);
        container.getChildren().addAll(mess, playerInputField, ok);
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(25));
        
        Scene scene = new Scene(container, 300, 200);
        scene.getStylesheets().add("rpg-styles.css");
        popupStage.setScene(scene);
        popupStage.showAndWait();
        
        return playerInputStr;
        
    }
    

    
}
