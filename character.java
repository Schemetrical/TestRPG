import java.util.ArrayList;
import java.lang.Math.*;
public class character
{
    public String name;
    public int health;
    public int dexterity;
    public int strength;
    public int luck;
    public int wisdom;
    public weapon wieldedWeapon;
    public ArrayList<item> inventory;
    public head wornHelmet;
    public chest wornChestPlate;
    public legs wornPants;
    public character(String name, int health, int strength, int dexterity, int luck, int wisdom)
    {
        this.name = name;
        this.health=health;
        this.strength=strength;
        this.dexterity=dexterity;
        this.luck=luck;
        this.wisdom=wisdom;
    }
    public void loseHealth(int hitpoints)
    {
        health-=hitpoints;
        if(isDead())
            die();
    }
    public void takeDamage(int damage)
    {
        loseHealth((int)(Math.max(((1-(wornHelmet.DR + wornChestPlate.DR + wornPants.DR))*damage)-(wornHelmet.DT + wornChestPlate.DT + wornPants.DT), 2)));
    }
    public int giveDamage()
    {
        // need to add something to calculate this value using player stats and critical stat from weapon....
        return wieldedWeapon.damage;
    }
    public boolean isDead()
    {
        if(health<=0)
            return true;
        return false;
    }
    public void die()
    {
        // to be defined
    }
}
