import java.util.ArrayList;

public class character
{
    public String name;
    public int health;
    public int dexterity;
    public int strength;
    public int luck;
    public int level;
    public int wisdom;
    public int baseHealth;
    public int defense;
    int[] stat = new int[5];
    public weapon wieldedWeapon;
    public ArrayList<item> inventory;
    public head wornHelmet;
    public chest wornChestPlate;
    public legs wornPants;
    
    public character(String name, int health, int strength, int defense, int dexterity, int luck, int wisdom, int level)
    {
        /*stat[0] = health;
        stat[1] = strength;
        stat[2] = dexterity;*/
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.luck = luck;
        this.wisdom = wisdom;
        this.level = level;
        baseHealth = health;
    }
    
    public void loseHealth(int hitpoints) {
        health-=hitpoints;
        if(health<0)
            health = 0;
            
        if(isDead())
            die();
    }
    
    public void takeDamage(int damage) {
        loseHealth((int)(Math.max((1.0-totalDR())*damage-totalDT(), 2.0)));
    }
    public int giveDamage() {
        if (Math.random()*100 < dexterity /*- wieldedWeapon.weight*/){
            
            int calculatedDamage = (int)(1.0 + (strength/200.0) + wieldedWeapon.damage); 
            if(Math.random() <= luck/400.0/* + wieldedWeapon.criticalChance*/)
                return (int)(calculatedDamage * 1.5);
            
            return calculatedDamage;
        }
        return 0;
        
    }
    
    public boolean isDead() {
        if(health<=0)
            return true;
        return false;
    }
    
    public void die() {
        // to be defined
    }
    
    public void addItem(item a){
    
        inventory.add(a);
        
    }
    
    public void removeItem(String a) {
        
        for(int i = 0; i < inventory.size(); i++){
            
            if(inventory.get(i).name.equals(a)){
                
                inventory.remove(i);
                break;
                
            }
            
        }
        
    }
    
    public void removeItem(int a) {
        
        inventory.remove(a);
    }
    
    public void levelUp() {
        
        level++;
        addStat(baseHealth);
        addStat(strength);
        addStat(dexterity);
        addStat(luck);
        addStat(defense);
        addStat(wisdom);
        
    }
    
    public int addStat(int a) {
        
        if(Math.random()*100 <= 50)
            return a+1;
        
        return a;
        
    }
    
    public void useItem(item a) {
        
        /*a.effect*/
        removeItem(a.name);
        
    }
    
    public void equipItem(weapon a) {
        
        if(!(wieldedWeapon == null))
            //inventory.add(wieldedWeapon);
        wieldedWeapon = a;
        //removeItem(a.name);
        
    }
    
    public void equipItem(chest a) {
        
        if(!(wornChestPlate == null))
            inventory.add(wornChestPlate);        
        wornChestPlate = a;
        removeItem(a.name);
        
    }
    
    public void equipItem(head a) {

        if(!(wornHelmet == null))
            inventory.add(wornHelmet);        
        wornHelmet = a;
        removeItem(a.name);
        
    }
    
    public void equipItem(legs a) {
        
        if(!(wornPants == null))
            inventory.add(wornPants);        
        wornPants = a;
        removeItem(a.name);
        
    }
    
    public double totalDR() {
        return wornHelmet.DR + wornChestPlate.DR + wornPants.DR;
    }
    
    public double totalDT() {
        return wornHelmet.DT + wornChestPlate.DT + wornPants.DT;
    }
    
}
