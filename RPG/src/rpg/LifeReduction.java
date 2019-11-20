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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jianc
 */
public class LifeReduction extends Application  {
    
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
    Label label = new Label("You have found a vessel of red liquid, would"
                + " you like to pick it up?");
     // Creates the button
        Button Yes = new Button();
        Button No = new Button();
        Button Used = new Button();
        Button Unused = new Button();
    
//    public Test (String t, String n, boolean o, int v, 
//            int l, Boolean m, String e, Boolean u, Boolean a)
//    {
//        type = t;
//        name = n;
//        isInventory = o;
//        value = v;
//        level = l;
//        isMagic = m;
//        effect = e;
//        isUsed = u;
//        correctLocation = a;
//    }
    
     
    public void start(Stage primaryStage) {
        // sets the text of the button
        Yes.setText("Yes");
        No.setText("No");
        Used.setText("Use it!");
        Unused.setText("Save it!");
   
        
        // Leaves the window
        Button Leave = new Button("Leave");
        Leave.setOnAction(e-> {
                primaryStage.close();
            });
        
        // Register the event handler
        Yes.setOnAction(new YesClickHandler());
        No.setOnAction(new NoClickHandler());
        Leave.setOnAction(new LeaveClickHandler());
        Used.setOnAction(new UsedClickHandler());
        Unused.setOnAction(new UnusedClickHandler());
    
        HBox ButtonHolder = new HBox(10, Yes, No, Leave);
        ButtonHolder.setAlignment(Pos.CENTER);
        VBox LabelHolder = new VBox(100, label, ButtonHolder);
        LabelHolder.setAlignment(Pos.CENTER);
 
        Scene scene = new Scene(LabelHolder, 300, 250);
        
        primaryStage.setTitle("Life Reduction");
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
    
    // used is player using the item,
    // not the player is going to use it or not
//    public boolean isUsed(){
//        // If the user uses it on a puzzle, then the puzzle will be skipped
//        if(used){
//            return true;
//        }
//        else{
//            return false;
//        }     
//    }
    // This dicatates when user decides to add the item
    class YesClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have picked up a(n) 'life reduction' potion! Your"
                    + " score will be reduced by half");
            Yes.setVisible(false);
            No.setVisible(false);
            
            addToInventory();
        }       
    }
    class NoClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("You have left a(n) 'life reduction' potion. "
                    + "Nice save!");

            Yes.setVisible(false);
            No.setVisible(false);
           
            addToInventory();
        }
    }
    class UsedClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            label.setText("Your life has been cut in half");
            Used.setVisible(false);
            Unused.setVisible(false);
            
            addToInventory();
        }       
    }
    // will not be implemented because player will be forced to use it
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
    class LeaveClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
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
    // Will always return true because it is a negative potion
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
        setEffect("Cuts players score in half");
        
        return;
    }
    
}