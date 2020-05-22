import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Methods
{

    private static final int diameter = Node.DIAMETER;

    public static boolean containsNode(Node node, MouseEvent e)
    {
        return new Rectangle(node.getX() - (diameter / 2), node.getY() - (diameter / 2), diameter, diameter).contains(e.getPoint());
    }

    public static boolean containsEdge(int x, int y, MouseEvent e)
    {
        return new Rectangle(x - (diameter / 2), y - (diameter / 2), diameter, diameter).contains(e.getPoint());
    }

    public static Node isNode(Point p, ArrayList<Node> nodes)
    {
        Rectangle figura = new Rectangle(p.x - diameter / 2, p.y - diameter / 2, diameter, diameter);
        for (Node node : nodes) {
            if (new Rectangle(node.getX() - diameter / 2, node.getY() - diameter / 2, diameter, diameter).intersects(figura)) {
                return node;
            }
        }

        return null;
    }

    public static void printAdjList(ArrayList<Node> nodes)
    {
        System.out.println("------------------------");
        for (Node node : nodes) {
            System.out.print("[" + node.getId() + "]");
            for (Node neigh : node.getNeighbors()) {
                System.out.print("-->" + neigh.getId());
            }
            System.out.println("");
        }
    }
}
