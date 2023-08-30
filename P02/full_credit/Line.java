import java.lang.Math;

public class Line
{
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, Color color)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public double length()
    {
        double xDistance = Math.abs(x1-x2);
        double yDistance = Math.abs(y1-y2);
        return Math.sqrt((Math.pow(xDistance, 2)) + (Math.pow(yDistance, 2)));
    }

    @Override
    public String toString()
    {
        return String.format("%s (%.3f, %.3f)-(%.3f,%.3f) has length %f", color, x1, y1, x2, y2, length()); 
    }
}