public class weapon extends item
{
    public int damage;
    public int ammo;
    public double criticalChance;
    public weapon(String name, int ammo, int damage, int weight, double criticalChance)
    {
        super(name,weight);
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
}