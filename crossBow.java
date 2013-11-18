public class crossBow extends ranged
{
    public crossBow(int ammo)
    {
        // Wooden Crossbow, 3kg, uses ammo damage decided by constructor, 10 damage, 0.00 critical bonus)
        super("Wooden Crossbow", 3, 10, 0, 0.5, ammo);
    }
}
