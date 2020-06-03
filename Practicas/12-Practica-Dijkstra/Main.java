import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
        nodes.add(H);

        A.addNeighbor(B);
        A.addNeighbor(C);
        B.addNeighbor(A);
        B.addNeighbor(E);
        C.addNeighbor(A);
        C.addNeighbor(D);
        C.addNeighbor(F);
        D.addNeighbor(C);
        D.addNeighbor(G);
        D.addNeighbor(H);
        E.addNeighbor(B);
        E.addNeighbor(G);
        F.addNeighbor(C);
        F.addNeighbor(H);
        G.addNeighbor(E);
        G.addNeighbor(D);
        G.addNeighbor(H);
        H.addNeighbor(G);
        H.addNeighbor(D);
        H.addNeighbor(F);

        ArrayList<Edge> edges = new ArrayList<>();
        Edge e1 = new Edge(A, B, 4);
        Edge e2 = new Edge(A, C, 3);
        Edge e3 = new Edge(B, E, 8);
        Edge e4 = new Edge(C, D, 12);
        Edge e5 = new Edge(C, F, 4);
        Edge e6 = new Edge(D, G, 20);
        Edge e7 = new Edge(D, H, 15);
        Edge e8 = new Edge(E, G, 17);
        Edge e9 = new Edge(F, H, 22);
        Edge e10 = new Edge(G, H, 9);

        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);
        edges.add(e8);
        edges.add(e9);
        edges.add(e10);

        Graph graph = new Graph(edges, nodes);

        graph.getNodes().forEach(System.out::println);
        graph.getEdges().forEach(System.out::println);

        Dijkstra dijkstra = new Dijkstra();

        dijkstra.shortestPath(graph, A).forEach(System.out::println);
    }
}
