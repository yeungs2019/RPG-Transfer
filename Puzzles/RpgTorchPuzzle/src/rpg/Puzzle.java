/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;


/**
 *
 * @author Ethan Powell
 */
public class Puzzle {
    
   // Making the torch variables
   private boolean torch1 = false;
   private boolean torch2 = false; 
   private boolean torch3 = false;
   private boolean torch4 = false;
   private boolean torch5 = false;
   
   // Button states (1 = true, 2 = false)
   private boolean button1State = true;
   private boolean button2State = true;
   private boolean button3State = true;
   private boolean button4State = true;
   
   // Is the puzzle solved or not
   private boolean solved = false;

    public boolean getTorch1() {
        return torch1;
    }

    public boolean getTorch2() {
        return torch2;
    }

    public boolean getTorch3() {
        return torch3;
    }

    public boolean getTorch4() {
        return torch4;
    }

    public boolean getTorch5() {
        return torch5;
    }
    
    public String getTorchStatus() {
        String torches = "";
        
        if (getTorch1() == true)
            torches += "1";
        else
            torches += "0";
        
        if (getTorch2() == true)
            torches += "1";
        else
            torches += "0";
        
        if (getTorch3() == true)
            torches += "1";
        else
            torches += "0";
        
        if (getTorch4() == true)
            torches += "1";
        else
            torches += "0";
        
        if (getTorch5() == true)
            torches += "1";
        else
            torches += "0";
        
        return torches;
    }

    public boolean isSolved() {
        // Check to see if all torches are on
        if(torch1 == true && torch1 == true && torch1 == true && 
                torch1 == true && torch1 == true)
        {
            solved = true;
        }
            
        return solved;
    }
    
    public void pushButton1 () {
        
        // Puzzle logic for button 1
        if(button1State == true)
        {
        torch1 = switchThis(torch1);
        torch3 = switchThis(torch3);
        }
        else
        {
            torch4 = switchThis(torch4);
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button1State = switchThis(button1State);
        
        return;
    }
    
    public void pushButton2 () {
        
        // Puzzle logic for button 2
        if(button2State == true)
        {
            torch2 = switchThis(torch2);
            torch3 = switchThis(torch3);
            torch5 = switchThis(torch5);
        }
        else
        {
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button2State = switchThis(button2State);
        
        return;
    }
    
    public void pushButton3 () {
        
        // Puzzle logic for button 3
        if(button3State == true)
        {
            torch1 = switchThis(torch1);
            torch3 = switchThis(torch3);
            torch4 = switchThis(torch4);
        }
        else
        {
            torch1 = switchThis(torch1);
        }
        
        // Changing the button state
        button2State = switchThis(button3State);
        
        return;
    }
    
    public void pushButton4 () {
        
        // Puzzle logic for button 4
        if(button4State == true)
        {
            torch1 = switchThis(torch1);
            torch2 = switchThis(torch2);
        }
        else
        {
            torch1 = switchThis(torch1);
            torch3 = switchThis(torch3);
            torch5 = switchThis(torch5);
        }
        
        // Changing the button state
        button2State = switchThis(button4State);
        
        return;
    }
    
    private boolean switchThis (boolean obj) {
        if (obj == true)
            obj = false;
        else
            obj = true;
        
        return obj;
    }
}
