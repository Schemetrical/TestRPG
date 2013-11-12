public class armor extends item
{
    public int DT;
    public double DR;
    public armor(String name, int DT, double DR)
    {
        super(name);
        this.DT = DT;
        this.DR = DR;
    }
}