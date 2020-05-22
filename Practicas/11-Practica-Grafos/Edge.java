import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Edge
{

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private String name;

    public Edge(int x1, int y1, int x2, int y2)
    {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1()
    {
        return x1;
    }

    public int getX2()
    {
        return x2;
    }

    public int getY1()
    {
        return y1;
    }

    public int getY2()
    {
        return y2;
    }

    public String getName()
    {
        return name;
    }

    public void draw(Graphics g)
    {
        Graphics2D gd2 = (Graphics2D) g;
        gd2.setColor(Color.decode("#CA1BF4"));
        gd2.setStroke(new BasicStroke(3));
        gd2.drawLine(x1, y1, x2, y2);
    }
}
