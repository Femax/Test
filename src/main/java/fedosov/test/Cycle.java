package fedosov.test;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cycle {
    private List<GraphNode> nodes;

    public Cycle(List<GraphNode> nodes) {
        this.nodes = normalize(nodes);

    }

    public List<GraphNode> normalize(List<GraphNode> nodes) {
        GraphNode min = Collections.min(nodes);
        Collections.rotate(nodes, -nodes.indexOf(min));
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cycle)) return false;
        Cycle cycle = (Cycle) o;
        return Objects.equals(nodes, cycle.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
