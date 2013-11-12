/*public class weapon extends item
{
    public int damage;
    public int ammo;
    public double criticalChance;
    public weapon(String name, int ammo, int damage, double criticalChance)
    {
        super(name);
        this.damage = damage;
        this.ammo = ammo;   // note that if ammo is set to -1 in subclassses, the weapon doesn't use ammo
        this.criticalChance = criticalChance;
    }
    public boolean canUseAmmo() //check if ammo can be used
    {
        if(ammo > 0 || ammo == -1)
            return true;
        return false;
    }
    public void useAmmo()   // use ammo
    {
        if(canUseAmmo() && ammo > 0)
            ammo-=1;
    }
}*/
public class Weapon
{
    
    double damageDelt;
    String weaponName;                      //Name of the weapon.
    String typeOfWeapon;                    //Type of Weapon
    double damage;                          //Damage per hit.
    double numStrike;                       //Number of Strikes per Attack.
    double accuracy;                        //Accuracy between 1 through 100 for simplicity sake.
    double durability;                      //Durability of the Weapon.
    boolean functional;                     //To see if the weapon is usable (used with durability).
    int levelOfWeapon;                      //Chance of a certain drop. I want to make this really interesting! When a new weapon is picked up it will be completely
                                            //          ...random but it will have many tiers depending on the rank of the character in the future.
    
    public void weaponClass(String weaponName,String typeOfWeapon,double damage,double numStrike,double accuracy,double durability,boolean functional,int levelOfWeapon)
    {
        this.weaponName=weaponName;
        this.typeOfWeapon=typeOfWeapon;
        this.damage=damage;
        this.numStrike=numStrike;
        this.accuracy=accuracy;
        this.durability=durability;
        this.functional=functional;
        this.levelOfWeapon=levelOfWeapon;
    }
    public double attack(String weaponName,double damage,double numStrike,double accuracy,double durability)
    {
        for (int x=0; x<numStrike; x++)
        {
            if ((accuracy/100)>Math.random())
            {
                System.out.println("It's a hit for "+damage+"!");
                damageDelt=+damage;
                durability();
            } else {
                switch((int)(Math.random()*10))  
                {
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
        return damageDelt;
    }
    private void durability()
    {
        durability--;
        if (durability>0)
        {
            System.out.print("Durability of your weapon decreases by 1,/nIt's now "+durability+".");
        } else {
            broken();
        }
    }
    private boolean broken()
    {
           System.out.println("Your weapon has broken!");
           functional=false;
           return functional;
    }
}
    /*public String pickup(character a)
    {
        return a.weapon;
            switch(level) {
            case 1: 
            int oneWeapons;
            int weaponNumber = Math.random*oneWeapons;
            
            break;
            int twoWeapons;
            case 2:
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            break;
            case 8:
            break;
            case 9:
            break;
            case 10:
            break;
        }
    }*/
