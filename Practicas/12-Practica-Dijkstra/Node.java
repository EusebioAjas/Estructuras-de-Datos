import java.util.ArrayList;

public class Node implements Comparable<Node> {
    private String id;
    private Node parent;
    private double distance;
    private ArrayList<Node> neighbors;

    public Node(String id) {
        this.id = id;
        neighbors = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public ArrayList<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return getId() + " distance: " + getDistance();
    }


    @Override
    public int compareTo(Node o) {
        if (this.getDistance() > o.getDistance()) {
            return 1;
        } else if (this.getDistance() < o.getDistance()) {
            return -1;
        }
        return 0;
    }
}
