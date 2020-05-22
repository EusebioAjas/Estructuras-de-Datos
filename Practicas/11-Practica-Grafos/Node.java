import java.awt.*;
import java.util.ArrayList;

public class Node
{

    private int x;
    private int y;
    private Integer id;
    private ArrayList<Node> neighbors;
    public static final int DIAMETER = 60;

    public Node(int x, int y, Integer id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor)
    {
        neighbors.add(neighbor);
    }

    public ArrayList<Node> getNeighbors()
    {
        return neighbors;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Integer getId()
    {
        return id;
    }

    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.decode("#33E491"));
        g2d.fillOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
        g2d.setColor(Color.BLACK);
        g2d.drawString(Integer.toString(id), x, y);
    }
}
