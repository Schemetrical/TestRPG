// changed it back to original and added weight. Right now, only weight is a deciding factor in accuracy.
// if you want a weapon to have another var that is used to calculate accuracy, perhaps add some sort of accuracy coefficient?
public class weapon extends item
{
    public String name;
    public int damage;
    public int ammo;
    public double criticalChance;
    public double accuracy;
    public weapon(String name, int weight, int damage, double criticalChance, double accuracy)
    {
        super(name, weight);
        this.damage = damage;
        this.criticalChance = criticalChance;
        this.accuracy = accuracy;
    }
}
/*
Sam's Old Code
public class weapon extends item{
    double damageDealt;
    String typeOfWeapon;                    //Type of Weapon
    double damage;                          //Damage per hit.
    int numStrike;                          //Number of Strikes per Attack.
    double accuracy;                        //Accuracy between 1 through 100 for simplicity sake.
    int durability;                         //Durability of the Weapon.
    boolean functional;                     //To see if the weapon is usable (used with durability).
    int levelOfWeapon;                      //Chance of a certain drop. I want to make this really interesting! When a new weapon is picked up it will be completely
                                            //          ...random but it will have many tiers depending on the rank of the character in the future.
    public void weapon(String weaponName, int weight, String typeOfWeapon, double damage, int numStrike, double accuracy, int durability, boolean functional, int levelOfWeapon) {
        super(weaponName, weight);
        this.typeOfWeapon = typeOfWeapon;
        this.damage = damage;
        this.numStrike = numStrike;
        this.accuracy = accuracy;
        this.durability = durability;
        this.functional = functional;
        this.levelOfWeapon = levelOfWeapon;
    }
    
    public double attack(String weaponName, double damage, int numStrike, double accuracy, int durability) {
        for (int x = 0; x < numStrike; x++) {
            if ((accuracy / 100) > Math.random()) {
                System.out.println("It's a hit for " + damage + "!");
                damageDealt += damage;
                durability();
            } else {
                switch((int)(Math.random() * 10)) {
                    case 1:     System.out.println ("Failure!");                                break;
                    case 2:     System.out.println ("It's a big old miss!");                    break;
                    case 3:     System.out.println ("Try again!");                              break;
                    case 4:     System.out.println ("You forgot how to use a weapon!");         break;
                    case 5:     System.out.println ("Haaaaa You Suck!");                        break;
                    case 6:     System.out.println ("Miss!");                                   break;
                    case 7:     System.out.println ("Better luck next time!");                  break;
                    case 8:     System.out.println ("Are you trying to hit him?");              break;
                    case 9:     System.out.println ("You attacked in the wrong direction!");    break;
                    case 10:    System.out.println ("Swish");                                   break;
                }
            }
        }
        return damageDealt;
    }
    
    private void durability() {
        durability--;
        if (durability > 0) {
            System.out.print("Durability of your weapon decreases by 1,/nIt's now " + durability + ".");
        } else {
            broken();
        }
    }
    
    private void broken()  {
           System.out.println("Your weapon broke!");
           functional = false;
    }
}*/
