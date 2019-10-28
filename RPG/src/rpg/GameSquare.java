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
    
    //constructor
    public GameSquare() {
        //border for each tile - rect with no fill
        Rectangle border = new Rectangle(100, 100);
        //removes color from rectangle
        border.setFill(null);
        //add border color to each tile
        border.setStroke(Color.BLACK);

        //centers everything within the stackpane (single tile)
        setAlignment(Pos.CENTER);

        getChildren().addAll(border);
    }
    
}
