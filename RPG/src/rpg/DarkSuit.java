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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jianc
 */
public class DarkSuit extends Items {
    private String effect;
    private Boolean used = true;
    private Boolean correctLocation = false;
    protected Boolean inInventory = false;
    
    public DarkSuit (String t, String n, boolean o, int v, 
            int l, Boolean m, String e, Boolean u, Boolean a)
    {
        super(t, n, o, v, l, m);
        effect = e;
        used = u;
        correctLocation = a;
    }
    
     
    public void start(Stage primaryStage) {
        // Creates the button
        Button Yes = new Button();
        Button No = new Button();
        // sets the text of the button
        Yes.setText("Yes");
        No.setText("No");
        
        // Register the event handler
        Yes.setOnAction(new YesClickHandler());
        No.setOnAction(new NoClickHandler());
    
        HBox ButtonHolder = new HBox(10, Yes, No);
        Scene scene = new Scene(ButtonHolder, 300, 250);
        
        primaryStage.setTitle("DarkSuit");
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
    // This dicatates when user decides to use the item
    class YesClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            isUsed();
        }       
    }
    class NoClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event){
            isUsed();
        }
    }
    public void addToInventory(){
        // If the user gets the item, they can choose to add it or not
        if(correctLocation){
            // adds the inventory immediately
            isInventory = true;
        }
        else{
           isInventory = false;
        }
    }
    public boolean isInventoryOrNot(){
        return isInventory;
    }
    public boolean isOnMethod(){
        correctLocation = true;
        return correctLocation;
    }
    public boolean isUsed(){
        // If the user uses it on a puzzle, then the puzzle will be skipped
        if(used){
        }
        else{
            return false;
        } 
        return false;
    }
    @Override
    public void upgradeItem(Items i)
    {
        i.setValue(3 * i.getValue());
        i.setLevel(1 + i.getLevel());
        setEffect("Skips one puzzle once per game");
        
        return;
    }
    
}
