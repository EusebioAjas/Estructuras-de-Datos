public class Edge {
    private Node source;
    private Node target;
    private Integer weight;

    public Edge(Node source, Node target, Integer weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getTarget() {
        return target;
    }

    public void setTarget(Node target) {
        this.target = target;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Source: " + getSource() + " | target: " + getTarget() + " | weight: " + getWeight();
    }
}
