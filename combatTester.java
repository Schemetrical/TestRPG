import java.io.*;
public class combatTester
{
    public static void main(String args[])
    {
        /**********/
        /***INIT***/
        /**********/
        //REMEMBER: character(String name, int health, int strength, int dexterity, int luck, int wisdom)
        character a = new character("Mario", 50, 20, 5, 80, 100, 10, 99);
        character b = new character("Goomba", 40, 10, 5, 50, 100, 0, 99);
        
        // Give them weapons
        a.wieldedWeapon = new rustySword();
        b.wieldedWeapon = new woodenStaff();
        
        // Give them armor
        a.wornHelmet = new oldHood();
        a.wornChestPlate = new oldLeatherVest();
        a.wornPants = new oldLeatherPants();
        b.wornHelmet = new oldHood();
        b.wornChestPlate = new oldLeatherVest();
        b.wornPants = new oldLeatherPants();
        
        /**********/
        /**COMBAT**/
        /**********/
        int damage;
        // now starting all the combat code from here
        System.out.println("BATTLE START: " + a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
        while(true) {
            damage = a.giveDamage();
            b.takeDamage(damage);
            System.out.println(a.name + " hit " + b.name + " for " + damage + " damage, " + b.name + " has " + b.characterDT() + " DT and " + b.characterDR() + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            
            if(b.health <= 0) {
                System.out.println(a.name + " killed " + b.name + " with " + a.health + " HP Left.");
                break;
            }
            
            damage = b.giveDamage();
            a.takeDamage(damage);
            System.out.println(b.name + " hit " + a.name + " for " + damage + " damage, " + a.name + " has " + a.characterDT() + " DT and " + a.characterDR() + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            if(a.health <= 0) {
                System.out.println(b.name + " killed " + a.name + " with " + b.health + " HP Left.");
                break;
            }
        }
    }
}
