import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class GraphClickListener extends MouseAdapter
{

    private GraphPanel graphPanel;
    private Graph graph;
    private Point p1, p2;
    private Node clickedNode;
    private int indexNode;

    public GraphClickListener(GraphPanel grapPanel, Graph graph)
    {

        this.graphPanel = grapPanel;
        this.graph = graph;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

        if (e.getButton() == MouseEvent.BUTTON1) {
            if (!isNode(e.getPoint())) {
                try {
                    String id = JOptionPane.showInputDialog("Enter an integer value: ");
                    graph.addNode(new Node(e.getX(), e.getY(), Integer.parseInt(id)));
                    graphPanel.repaint();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "The operation has been canceled!");
                }
            }
        }

        if (e.getButton() == MouseEvent.BUTTON3) {
            graph.getNodes().forEach(node -> {
                if (Methods.containsNode(node, e)) {
                    if (p1 == null) {
                        p1 = new Point(node.getX(), node.getY());
                    } else {
                        p2 = new Point(node.getX(), node.getY());
                        graph.addEdge(new Edge(p1.x, p1.y, p2.x, p2.y));
                        graphPanel.repaint();
                        Node currentNode = Methods.isNode(p1, graph.getNodes());
                        if (currentNode != null && currentNode != node) {
                            node.addNeighbor(currentNode);
                            currentNode.addNeighbor(node);
                        }
                        p1 = null;
                        p2 = null;
                    }
                }

            });
        }
    }

    private boolean isNode(Point p)
    {
        int diametro = Node.DIAMETER;
        Rectangle figura = new Rectangle(p.x - diametro / 2, p.y - diametro / 2, diametro, diametro);
        for (Node c : graph.getNodes()) {
            if (new Rectangle(c.getX() - diametro / 2, c.getY() - diametro / 2, diametro, diametro).intersects(figura)) {
                return true;
            }
        }

        return false;
    }
}
