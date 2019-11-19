/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg;

/**
 *
 * @author jianc
 */
// Once per game, the player can choose to solve a different puzzle than the one
// given.
public class Balgy extends Items{
    public String effect;
    
   public Balgy(String n, int v, int l, boolean p, boolean a, 
            boolean magic, boolean h, String e){
        super(n, v, l, p , a, magic, h);
        effect = e;
    }
    public String getEffect(){
        return effect;
    }
    public void setEffect(String effect){
        this.effect = effect;
    }
    @Override
    public void upgradeItem(Items i)
    {
        i.setValue(3 * i.getValue());
        i.setLevel(1 + i.getLevel());
        setEffect("Here's a potion to get another puzzle to solve.");
        
        return;
    }
}
