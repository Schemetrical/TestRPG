
/**
 * Ranged weapons
 * 
 * @author Schemetrical
 * @version Nov. 14, 2013
 */
public class ranged extends weapon
{
    public ranged(String name, int weight, int damage, double criticalChance, double accuracy, int ammo)
    {
        super(name, weight, damage, criticalChance, accuracy);
        this.ammo = ammo;
    }

    public boolean canUseAmmo() //check if ammo can be used
    {
        return ammo > 0 ? true : false;
    }
    
    public void useAmmo()   // use ammo
    {
        if(canUseAmmo()) ammo-=1;
    }
}
