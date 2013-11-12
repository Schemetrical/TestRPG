public class location
{
    public int row;
    public int col;
    public area currentArea;
    location(int row, int col, area place)
    {
        this.row = row;
        this.col = col;
        this.currentArea = place;
    }
}