public class armor extends item
{
    public int DT;
    public double DR;
    public armor(String name, int weight, int DT, double DR)
    {
        super(name, weight);
        this.DT = DT;
        this.DR = DR;
    }
}