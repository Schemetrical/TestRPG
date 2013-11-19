import java.util.ArrayList;

public class character
{
    public String name;
    public int health, strength, defense, dexterity, luck, wisdom, level;
    public int baseHealth;
    public weapon wieldedWeapon;
    public ArrayList<item> inventory;
    public head wornHelmet;
    public chest wornChestPlate;
    public legs wornPants;
    
    public character(String name, int health, int strength, int defense, int dexterity, int luck, int wisdom, int level)
    {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.dexterity = dexterity;
        this.luck = luck;
        this.wisdom = wisdom;
        this.level = level;
        baseHealth = health;
    }
    
    public void loseHealth(int hitpoints) {
        health -= hitpoints;
        if(health < 0) {
            health = 0;
            die();
        }
    }
    
    public void takeDamage(int damage) {
        loseHealth((int)Math.max((((1.0 - characterDR()) * damage) - characterDT()), 0));
    }
    
    public int giveDamage() {
        if (Math.random()*100 < (dexterity - wieldedWeapon.weight)){
            
            int calculatedDamage = (int)(1.0 + (strength / 200.0) + wieldedWeapon.damage); 
            if(Math.random() <= luck/400.0/* + wieldedWeapon.criticalChance*/)
                return (int)(calculatedDamage * 1.5);
            
            return calculatedDamage;
        }
        return 0;
    }
    
    public void die() {
        // to be defined
    }
    
    public void addItem(item newItem){
        inventory.add(newItem);
    }
    
    public void removeItem(String item) {
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i).name.equals(item)){
                inventory.remove(i);
                break;
            }
        }
    }
    
    public void levelUp() {
        level++;
        addStat(0, "baseHealth");
        addStat(0, "strength");
        addStat(0, "dexterity");
        addStat(0, "luck");
        addStat(0, "defense");
        addStat(0, "wisdom");
    }
    
    public void addStat(int amount, String stat) {
        if(amount == 0){
            if(Math.random() > 0.5) amount = 1;
        }
        switch(stat) {
            case "baseHealth":  this.baseHealth++;
            case "strength":    this.strength++;
            case "dexterity":   this.dexterity++;
            case "luck":        this.luck++;
            case "defense":     this.defense++;
            case "wisdom":      this.wisdom++;
        }
    }
    
    public void useItem(item a) {
        
        /*a.effect*/
        removeItem(a.name);
        
    }
    
    public void equipItem(item a)
    {
        if(a instanceof legs)
        {
            if(wornPants != null)
                inventory.add(wornPants);
            wornPants = (legs)a; // cast the item to the proper class
            removeItem(a.name);
        }
        else if(a instanceof head)
        {
            if(wornHelmet != null)
                inventory.add(wornHelmet);        
            wornHelmet = (head)a;
            removeItem(a.name);
        }
        else if(a instanceof chest)
        {
            if(!(wornChestPlate == null))
                inventory.add(wornChestPlate);        
            wornChestPlate = (chest)a;
            removeItem(a.name);
        }
        else if(a instanceof weapon)
        {
            if(wieldedWeapon != null)
                inventory.add(wieldedWeapon);
            wieldedWeapon = (weapon)a;
            removeItem(a.name);
        }
    }
    public void unequipItem(item a){}
    
    public double characterDR() {
        return wornHelmet.DR + wornChestPlate.DR + wornPants.DR;
    }
    
    public double characterDT() {
        return wornHelmet.DT + wornChestPlate.DT + wornPants.DT;
    }
    
}
