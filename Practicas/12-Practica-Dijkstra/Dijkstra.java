import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    public ArrayList<Node> shortestPath(Graph graph, Node source) {
        ArrayList<Node> result = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        initializeSingleSource(graph, source);

        graph.getNodes().forEach(pq::add);
        while (pq.size() > 0) {
            Node min = pq.poll();
            result.add(min);
            for (Node node : min.getNeighbors()) {
                Edge edge = getEdge(graph, min, node);
                if (edge != null) relax(min, node, edge);
            }
        }
        return result;
    }

    private void relax(Node u, Node v, Edge edge) {
        double weight = u.getDistance() + edge.getWeight();
        if (v.getDistance() > weight) {
            v.setDistance(weight);
            v.setParent(u);
        }
    }

    private Edge getEdge(Graph graph, Node source, Node target) {
        for (Edge edge : graph.getEdges()) {
            if (edge.getSource().equals(target) && edge.getTarget().equals(source)) {
                return edge;
            }
            if (edge.getSource().equals(source) && edge.getTarget().equals(target)) {
                return edge;
            }
        }
        return null;
    }

    private void initializeSingleSource(Graph graph, Node source) {
        for (Node node : graph.getNodes()) {
            node.setDistance(Double.POSITIVE_INFINITY);
            node.setParent(null);
        }
        source.setDistance(0.0);
    }
}
