/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author jeanieherold
 */
public class GameSquare extends StackPane {
    
    private final Rectangle border;
    
    //constructor
    public GameSquare(boolean block) {

        //border for each tile - rect with no fill
        border = new Rectangle(60, 60);
        //removes color from rectangle
        if(block == true) {
            border.setFill(Color.BLACK);
        } else {
            border.setFill(Color.TRANSPARENT);
        }
        
        //add border color to each tile
        border.setStroke(Color.TRANSPARENT);

        //centers everything within the stackpane (single tile)
        setAlignment(Pos.CENTER);

        getChildren().addAll(border);
        
    }
    
    //methods
    public void setPlayerBlock() {
        border.setFill(Color.BLACK);
    }
    
}
