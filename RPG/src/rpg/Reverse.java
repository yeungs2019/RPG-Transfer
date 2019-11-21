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
public class Reverse extends Application  {
    
    private String effect = "";
    private Boolean correctLocation = true;
    protected Boolean inInventory = false;
    protected String type = "";
    protected String name = "";
    protected int value = 0;
    protected int level = 0;
    protected Boolean isMagic = false;
    protected Boolean isUsed = false;
    protected Boolean isCorrect = false;
    protected String playerAnswer = "";
    protected String correctAnswer = "";
    // Creates the label
    Label label = new Label("You have found a jar of clear liquid, would"
                + " you like to pick it up?");
     // Creates the button
        Button Yes = new Button();
        Button No = new Button();
        Button Used = new Button();
        Button Unused = new Button();
     
    public void start(Stage primaryStage) {
        // Image object
        Image Clear = new Image("file:images/ClearP.jpg");
        // Create ImageView object
        ImageView ClearView = new ImageView(Clear);
        //Putting the ImageView in the hbox
        HBox ClearImage = new HBox(ClearView);
        // Setting the width and height
        ClearView.setFitWidth(200);
        ClearView.setFitHeight(200);
        
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
    
        ClearImage.setAlignment(Pos.CENTER);
        HBox ButtonHolder = new HBox(10, Yes, No, Leave);
        ButtonHolder.setAlignment(Pos.CENTER);
        VBox LabelHolder = new VBox(100, label, ClearImage, ButtonHolder);
        LabelHolder.setAlignment(Pos.CENTER);
 
        Scene scene = new Scene(LabelHolder, 300, 250);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        
        primaryStage.setTitle("Reverse");
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
            label.setText("You have picked up a 'reverse' potion. This will "
                    + "hurt when you solve a puzzle.");
            Yes.setVisible(false);
            No.setVisible(false);
            
            addToInventory();
        }       
    }
    class NoClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have left a 'reverse' potion. Lucky!");
            Yes.setVisible(false);
            No.setVisible(false);
           
            addToInventory();
        }
    }
    class UsedClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You got it right, but it's still wrong because"
                    + " you were too curious to pick up this potion");
            Used.setVisible(false);
            Unused.setVisible(false);
            
            isUsed();
            
            // This will be applied when the player goes to solve the puzzle
            isThatCorrect();
            addToInventory();
        }       
    }
    // This will not apply because this is a negative item and will be
    // applied immediately
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
        // When they previously picked up this item, it will be applied to the 
        // next puzzle they step on.
        if(isUsed){
            // this signifies the user used the potion and removes it from inventory
            isUsed = true;
            inInventory = false;
        }
        return false;
    }
    public boolean isThatCorrect(){
        if (playerAnswer.equalsIgnoreCase(correctAnswer)){
            return isCorrect;
        }
        return false;
    }
 
    public void upgradeItem(Items i)
    {
        i.setValue(3 * i.getValue());
        i.setLevel(1 + i.getLevel());
        setEffect("Reverses the outcome of a correctly solved puzzle");
        
        return;
    }
    
}