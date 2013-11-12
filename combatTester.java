import java.io.*;
public class combatTester
{
    public static void main(String args[])
    {
        //REMEMBER: character(String name, int health, int strength, int dexterity, int luck, int wisdom)
        character a = new character("Mario", 50, 20, 80, 100, 10);
        character b = new character("Goomba", 40, 10, 50, 100, 0);
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
        // now starting all the combat code from here
        int DAM;
        System.out.println("BATTLE START: " + a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
        while(true)
        {
            DAM = a.giveDamage();
            b.takeDamage(DAM);
            System.out.println(a.name + " hit " + b.name + " for " + DAM + " damage, " + b.name + " has " + (b.wornHelmet.DT + b.wornChestPlate.DT + b.wornPants.DT) + " DT and " + (b.wornHelmet.DR + b.wornChestPlate.DR + b.wornPants.DR) + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            if(b.isDead())
            {
                System.out.println(b.name + " was killed by " + a.name);
                break;
            }
            DAM = b.giveDamage();
            a.takeDamage(DAM);
            System.out.println(b.name + " hit " + a.name + " for " + DAM + " damage, " + a.name + " has " + (a.wornHelmet.DT + a.wornChestPlate.DT + a.wornPants.DT) + " DT and " + (a.wornHelmet.DR + a.wornChestPlate.DR + a.wornPants.DR) + " DR");
            System.out.println(a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
            if(a.isDead())
            {
                System.out.println(a.name + " was killed by " + b.name);
                break;
            }
        }
        System.out.println("BATTLE END: " + a.name + " has " + a.health + " HP, " + b.name + " has " + b.health + " HP");
    }
}
