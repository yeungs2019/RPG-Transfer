/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

/**
 *
 * @author jeanieherold
 */
public class GameBoard {
    
    //private fields
    private GridPane grid;
    
    //constructor
    public GameBoard() {
    
        //create 25 Gamesquare gameboard
        GameSquare square1 = new GameSquare();
        GameSquare square2 = new GameSquare();
        GameSquare square3 = new GameSquare();
        GameSquare square4 = new GameSquare();
        GameSquare square5 = new GameSquare();
        GameSquare square6 = new GameSquare();
        GameSquare square7 = new GameSquare();
        GameSquare square8 = new GameSquare();
        GameSquare square9 = new GameSquare();
        GameSquare square10 = new GameSquare();
        GameSquare square11 = new GameSquare();
        GameSquare square12 = new GameSquare();
        GameSquare square13 = new GameSquare();
        GameSquare square14 = new GameSquare();
        GameSquare square15 = new GameSquare();
        GameSquare square16 = new GameSquare();
        GameSquare square17 = new GameSquare();
        GameSquare square18 = new GameSquare();
        GameSquare square19 = new GameSquare();
        GameSquare square20 = new GameSquare();
        GameSquare square21 = new GameSquare();
        GameSquare square22 = new GameSquare();
        GameSquare square23 = new GameSquare();
        GameSquare square24 = new GameSquare();
        GameSquare square25 = new GameSquare();
        
        //add Gamesquares to the gameboard
        grid.add(square1, 1, 0);
        grid.add(square2, 1, 1);
        grid.add(square3, 1, 2);
        grid.add(square4, 1, 3);
        grid.add(square5, 1, 4);
        grid.add(square6, 2, 0);
        grid.add(square7, 2, 1);
        grid.add(square8, 2, 2);
        grid.add(square9, 2, 3);
        grid.add(square10, 2, 4);
        grid.add(square11, 3, 0);
        grid.add(square12, 3, 1);
        grid.add(square13, 3, 2);
        grid.add(square14, 3, 3);
        grid.add(square15, 3, 4);
        grid.add(square16, 4, 0);
        grid.add(square17, 4, 1);
        grid.add(square18, 4, 2);
        grid.add(square19, 4, 3);
        grid.add(square20, 4, 4);
        grid.add(square21, 5, 0);
        grid.add(square22, 5, 1);
        grid.add(square23, 5, 2);
        grid.add(square24, 5, 3);
        grid.add(square25, 5, 4);
   
        //GridPane styles
        grid.setPadding(new Insets(20));
        grid.setPrefWidth(500);
        grid.setPrefHeight(500);
        
    }
   
    
}
