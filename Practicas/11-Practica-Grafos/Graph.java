import java.util.ArrayList;

public class Graph
{

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public Graph()
    {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addEdge(Edge enlace)
    {
        edges.add(enlace);
    }

    public void addNode(Node circle)
    {
        nodes.add(circle);
    }

    public ArrayList<Node> getNodes()
    {
        return nodes;
    }

    public ArrayList<Edge> getEdges()
    {
        return edges;
    }
}
