public class TestLine
{
    public static void main(String[] args)
    {
        Line line1 = new Line(Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 10, Color.PURPLE);
        Line line2 = new Line(Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 10, Color.CYAN);
        Line line3 = new Line(Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 10, Color.PINK);
        Line line4 = new Line(Math.random() * 10, Math.random() * 10, Math.random() * 10, Math.random() * 10, Color.ORANGE);

        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }
}