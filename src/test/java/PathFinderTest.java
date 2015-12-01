import fedosov.test.Graph;
import fedosov.test.GraphNode;
import fedosov.test.PathFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
public class PathFinderTest {

    @Test
    public void testFind_1() throws Exception {
        PathFinder pf = new PathFinder();

        Graph g = new Graph();
        for (int[] relation : new int[][]{{1,2}, {2,3}, {3,4}, {4,1},{3,1}}) {
            g.addRelation(relation[0], relation[1]);
        }

        List<List<GraphNode>> paths = pf.find(g);

        System.out.println(paths);

        Assert.assertEquals(2, paths.size());
        Assert.assertEquals(4, paths.get(0).size());
        Assert.assertEquals(3, paths.get(1).size());
    }

    @Test
    public void testFind_2() throws Exception {
        PathFinder pf = new PathFinder();

        Graph g = new Graph();
        for (int[] relation : new int[][]{{1,2}, {2,1},{3,4},{4,3}}) {
            g.addRelation(relation[0], relation[1]);
        }

        List<List<GraphNode>> paths = pf.find(g);

        System.out.println(paths);

        Assert.assertEquals(2, paths.size());
        Assert.assertEquals(2, paths.get(0).size());
        Assert.assertEquals(2, paths.get(1).size());
    }

    @Test
    public void testFind_3() throws Exception {
        PathFinder pf = new PathFinder();

        Graph g = new Graph();
        for (int[] relation : new int[][]{{1,2}, {2,6}, {6,7}, {7,1},{2,5}, {5,4}, {4,3}, {3,2}, {2,7}, {2,4}}) {
            g.addRelation(relation[0], relation[1]);
        }

        List<List<GraphNode>> paths = pf.find(g);

        System.out.println(paths);

        Assert.assertEquals(4, paths.size());
        Assert.assertEquals(4, paths.get(0).size());
        Assert.assertEquals(4, paths.get(1).size());
        Assert.assertEquals(3, paths.get(2).size());
        Assert.assertEquals(3, paths.get(3).size());

    }
}