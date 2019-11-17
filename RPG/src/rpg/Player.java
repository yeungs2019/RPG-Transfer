/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author jeanieherold
 */
public class Player {
    
    private String mName;
    private Image mProfile;
    private int mScore;
    private ArrayList<String> mItems;
    
    //constructor
    public Player(String name, String profileLocation) {
        
        mName = name;      
        mProfile = new Image(profileLocation);
        mScore = 0;
        mItems = new ArrayList<>();
        
    }
    
    //methods
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ImageView getProfile() {
        
        ImageView playerNode = new ImageView(mProfile);
        
        return playerNode;
    }
    
    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }
    
    public int addToScore(int score) {   
        mScore += score;
        return mScore;
    }
    public int subtractFromScore(int score) {   
        mScore -= score;
        if (mScore <= 0) {
            mScore = 0;
        }
        
        return mScore;
    }
    
    public ArrayList<String> getItems() {
        return mItems;
    }
    
    public ArrayList<String> addToItemsList (String item) {     
        mItems.add(item);
        return mItems;
    }
    
    public ArrayList<String> removeFromItemsList (String item) {     
        mItems.remove(item);
        return mItems;
    }
    
    public int getColumnLocation(GridPane grid, Node player) {
       
       int col = GridPane.getColumnIndex(player);
       
       return col;
    }
   
    public int getRowLocation(GridPane grid, Node player) {
       
       int row = GridPane.getRowIndex(player);

        return row;
    }
    
}
