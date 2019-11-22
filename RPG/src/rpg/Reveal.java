/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author jianc
 */
public class Reveal extends Application  {
    
    private String effect = "";
    private Boolean correctLocation = true;
    protected Boolean inInventory = false;
    protected String type = "";
    protected String name = "";
    protected int value = 0;
    protected int level = 0;
    protected Boolean isMagic = false;
    protected Boolean isUsed = false;
    // Creates the label
    Label label = new Label("You have found a jar of blue liquid, would"
                + " you like to pick it up?");
     // Creates the button
        Button Yes = new Button();
        Button No = new Button();
        Button Used = new Button();
        Button Unused = new Button();
    
    public void start(Stage primaryStage) {
        // Image object
        Image Blue = new Image("file:images/BlueP.jng");
        // Create ImageView object
        ImageView BlueView = new ImageView(Blue);
        //Putting the ImageView in the hbox
        HBox BlueImage = new HBox(BlueView);
        // Setting the width and height
        BlueView.setFitWidth(200);
        BlueView.setFitHeight(200);
        
        // sets the text of the button
        Yes.setText("Yes");
        No.setText("No");
        Used.setText("Use it!");
        Unused.setText("Save it!");
   
        
        // Leaves the window
        Button Leave = new Button("Leave");
        
        // Register the event handler
        Yes.setOnAction(new YesClickHandler());
        No.setOnAction(new NoClickHandler());
        Leave.setOnAction(e -> primaryStage.close());
        Used.setOnAction(new UsedClickHandler());
        Unused.setOnAction(new UnusedClickHandler());
    
        BlueImage.setAlignment(Pos.CENTER);
        HBox ButtonHolder = new HBox(10, Yes, No, Leave);
        ButtonHolder.setAlignment(Pos.CENTER);
        VBox LabelHolder = new VBox(100, label, BlueImage, ButtonHolder);
        LabelHolder.setAlignment(Pos.CENTER);
 
        Scene scene = new Scene(LabelHolder, 300, 250);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        scene.getStylesheets().add("rpg-styles.css");
        
        primaryStage.setTitle("Potion Motion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    
    // This dicatates when user decides to add the item
    class YesClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have picked up a 'Reveal' potion. You "
                    + "now have an option to reveal a puzzle location");
            Yes.setVisible(false);
            No.setVisible(false);
            
            addToInventory();
        }       
    }
    class NoClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have left a 'Reveal' potion. Too bad!");
            Yes.setVisible(false);
            No.setVisible(false);
           
            addToInventory();
        }
    }
    class UsedClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have revealed a puzzle location");
            Used.setVisible(false);
            Unused.setVisible(false);
            
            addToInventory();
        }       
    }
    class UnusedClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("Saving it? If you insist.");
            Used.setVisible(false);
            Unused.setVisible(false);
           
            addToInventory();
        }
    }
    public void addToInventory(){
        // If the user gets the item, they can choose to add it or not
        if(correctLocation){
            // adds the inventory immediately
            inInventory = true;
        }
        else{
           inInventory = false;
        }
    }
    public boolean isInventoryOrNot(){
        return inInventory;
    }
    public boolean isOnMethod(){
        correctLocation = true;
        return correctLocation;
    }
    public boolean isUsed(){
        // If the user uses it on a puzzle, then the puzzle will be skipped
        if(isUsed){
            // this signifies the user used the potion and removes it from inventory
            isUsed = true;
            inInventory = false;
        }
        else{
            isUsed = false;
            inInventory = true;
        } 
        return false;
    }
 
    public void upgradeItem(Items i)
    {
        i.setValue(3 * i.getValue());
        i.setLevel(1 + i.getLevel());
        setEffect("Reveals a location of a puzzle");
        
        return;
    }
    
}