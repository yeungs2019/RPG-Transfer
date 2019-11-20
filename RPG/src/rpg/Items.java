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
public class Items {
    //Here are the variables for the stats for our items
    protected String type;
    protected String name;
    protected boolean isInventory;
    protected int value;
    protected int level;
    protected Boolean isMagic;
    protected Boolean isUsed;
    
    public Items (String t, String n, boolean o, int v, int l, 
            Boolean m)
    {
        type = t;
        name = n;
        isInventory = o;
        value = v;
        level = l;
        isMagic = m;
    }
    
    //Many getters and setters...
    public Items (String t, String n, boolean o)
    {
        type = t;
        name = n;
        isInventory = o;
        value = 0;
        level = 0;
        isMagic = false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsInventory() {
        return isInventory;
    }

    public void setIsHolding(boolean isInventory) {
        this.isInventory = isInventory;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Boolean getIsMagic() {
        return isMagic;
    }

    public void setIsMagic(Boolean isMagic) {
        this.isMagic = isMagic;
    }
    
    //Here is where we can upgrade the items, one upgrade is overloaded
    public void upgradeItem(Items i)
    {
        
        i.setValue(2 * i.getValue());
        i.setLevel(1 + i.getLevel());
        
        return;
    }
    
    public void upgradeItem(Items i, int l)
    {
        i.setValue(3 * i.getValue());
        i.setLevel(l);
        
        return;
    }
    
}
