package fedosov.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PathFinder {

    public List<List<GraphNode>> find(Graph graph) {
        List<List<GraphNode>> paths = new ArrayList<>();
        HashSet<Cycle> сycles = new HashSet<>();
        for (GraphNode node : graph.getNodes()) {
            internalFind(graph, node, new ArrayList<>(), paths, new HashSet<>(), сycles);
        }
        return paths;
    }

    private void internalFind(Graph graph, GraphNode node, List<GraphNode> currentPath, List<List<GraphNode>> paths, HashSet<Integer> visited, HashSet<Cycle> cycles) {
        if (node.getRelatedNodes().isEmpty()) {
            return;
        }
        List<GraphNode> newcurrentPath = new ArrayList<>();
        newcurrentPath.addAll(currentPath);
        if (!visited.contains(node.getId())) newcurrentPath.add(node);
        HashSet<Integer> newVisited = new HashSet<>();
        newVisited.addAll(visited);
        newVisited.add(node.getId());
        for (Integer nodeId : node.getRelatedNodes()) {
            GraphNode graphNode = graph.getGraphNodeById(nodeId);
            if ((!visited.contains(node.getId())) && (graphNode != null)) {
                internalFind(graph, graphNode, newcurrentPath, paths, newVisited, cycles);
            } else if (newcurrentPath.indexOf(node) != -1 && (currentPath.size() > 1)) {
                Integer firstElement = newcurrentPath.indexOf(node);
                List<GraphNode> newPath = new ArrayList<>();
                for (int i = firstElement; i < newcurrentPath.size(); i++) {
                    newPath.add(newcurrentPath.get(i));
                }
                Cycle c = new Cycle(newPath);

                if (!cycles.contains(c)) {

                    paths.add(newPath);
                }
                cycles.add(c);
            }
        }
        currentPath.remove(node);
    }
}