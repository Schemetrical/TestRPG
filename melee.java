
/**
 * Melee weapons
 * 
 * @author Schemetrical
 * @version Nov. 14, 2013
 */
public class melee extends weapon
{
    public int numberOfHits;
    
    public melee(String name, int weight, int damage, double criticalChance, double accuracy, int numberOfHits)
    {
        super(name, weight, damage, criticalChance, accuracy);
        this.numberOfHits = numberOfHits;
    }
}
