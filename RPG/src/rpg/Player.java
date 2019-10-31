/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

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
    
    //constructor
    public Player(String name, String profileLocation) {
        
        mName = name;
        
        mProfile = new Image(profileLocation);
        
    }
    
    //methods
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public ImageView getProfile() {
        
        ImageView playerNode = new ImageView(mProfile);
        
        return playerNode;
    }
    
    public int getColumnLocation(GridPane grid, Node player) {
       
       int col = grid.getColumnIndex(player);
       
       return col;
    }
   
    public int getRowLocation(GridPane grid, Node player) {
       
       int row = grid.getRowIndex(player);

        return row;
    }
    
}
