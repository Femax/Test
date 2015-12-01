package fedosov.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    private Map<Integer, GraphNode> nodes = new HashMap<>();

    public void addRelation(int from , int to) {
        GraphNode gn = null;
        if(nodes.containsKey(from)) {
            gn = nodes.get(from);
        } else {
            gn = new GraphNode(from);
            nodes.put(from, gn);
        }

        gn.addNode(to);
    }

    public Collection<GraphNode> getNodes() {
        return nodes.values();
    }

    public GraphNode getGraphNodeById(int id) {
        return nodes.get(id);
    }
}
