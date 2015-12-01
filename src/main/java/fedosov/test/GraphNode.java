package fedosov.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode implements Comparable<GraphNode> {
    public boolean Mark;
    private int id;
    private List<Integer> relatedNodes = new ArrayList<>();

    public GraphNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addNode(Integer graphNode) {

        relatedNodes.add(graphNode);
    }

    public List<Integer> getRelatedNodes() {
        return relatedNodes;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return Objects.equals(id, graphNode.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(GraphNode o) {
        if (this.getId() < o.id) return -1;
        else return (this.getId() - o.id) == 0 ? 0 : 1;
    }


}