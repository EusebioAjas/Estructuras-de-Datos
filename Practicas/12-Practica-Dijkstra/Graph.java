import java.util.ArrayList;

public class Graph {
    private ArrayList<Edge> edges;
    private ArrayList<Node> nodes;

    public Graph(ArrayList<Edge> edges, ArrayList<Node> nodes) {
        this.edges = edges;
        this.nodes = nodes;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "edges: " + getEdges() + "\nnodes: " + getNodes();
    }
}
