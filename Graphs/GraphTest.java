import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class GraphTest {

    // test the graph constructor and addNode 
    @Test
    public void testAddNode() {
        Graph graph = new Graph();
        assertTrue(graph.addNode("U"));
        assertTrue(graph.addNode("V"));
        assertFalse(graph.addNode("U")); // the U vertex is already in the graph
    }

    // Test the addEdge method
    @Test
    public void testAddEdge() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");

        assertTrue(graph.addEdge("U", "V", 2)); // valid 
        assertFalse(graph.addEdge("U", "V", 5)); // edge already exists
        assertFalse(graph.addEdge("U", "L", 10)); // node L does not exist
        assertFalse(graph.addEdge("U", "V", -1)); // invalid weight since it is negative
    }

    // test the addEdges method 
    @Test
    public void testAddEdges() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");
        graph.addNode("W");

        String[] toList = {"V", "W"};
        int[] weightList = {2, 5};

        assertTrue(graph.addEdges("U", toList, weightList)); // valid multiple edges
        assertFalse(graph.addEdges("U", new String[]{"V", "W"}, new int[]{-5, 5})); // invalid weight
    }

    // test the removeNode method 
    @Test
    public void testRemoveNode() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");
        graph.addEdge("U", "V", 2);

        assertTrue(graph.removeNode("U")); // remove node
        assertFalse(graph.removeNode("U")); // try to remove U again
        assertTrue(graph.removeNode("V")); //remove another node V
    }

    // Test the removeEdge method (valid and invalid edges)
    @Test
    public void testRemoveEdge() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");
        graph.addEdge("U", "V", 2);

        assertTrue(graph.removeEdge("U", "V")); // remove valid edge
        assertFalse(graph.removeEdge("U", "V")); // try to remove the edge again
        assertFalse(graph.removeEdge("U", "X")); // edge does not exist
    }

    // Test the shortestDistance method
    @Test
    public void testShortestDistance() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");
        graph.addNode("W");
        graph.addNode("X");
        graph.addNode("Y");
        graph.addNode("Z");

        graph.addEdge("U", "V", 2);
        graph.addEdge("U", "W", 5);
        graph.addEdge("U", "X", 1);
        graph.addEdge("V", "W", 2);
        graph.addEdge("V", "X", 3);
        graph.addEdge("W", "X", 3);
        graph.addEdge("W", "Y", 1);
        graph.addEdge("W", "Z", 5);

        assertEquals(2, graph.shortestDistance("U", "V")); // direct edge from U to V
        assertEquals(6, graph.shortestDistance("U", "Y")); // shortest path from U to Y
        assertEquals(-1, graph.shortestDistance("U", "D")); // Node D does not exist
    }

    // test the minimumSpanningTree method
    @Test
    public void testMinimumSpanningTree() {
        Graph graph = new Graph();
        graph.addNode("U");
        graph.addNode("V");
        graph.addNode("W");
        graph.addNode("X");
        graph.addNode("Y");
        graph.addNode("Z");

        graph.addEdge("U", "V", 2);
        graph.addEdge("U", "W", 5);
        graph.addEdge("U", "X", 1);
        graph.addEdge("V", "W", 2);
        graph.addEdge("V", "X", 3);
        graph.addEdge("W", "X", 3);
        graph.addEdge("W", "Y", 1);
        graph.addEdge("W", "Z", 5);

        List<String[]> mst = graph.minimumSpanningTree();
        assertNotNull(mst); // MST should be created
        assertEquals(5, mst.size());

        // check whether MST contains the expected edges
        List<String[]> expectedMST = Arrays.asList(
            new String[]{"U", "X", "1"},
            new String[]{"V", "U", "2"},
            new String[]{"V", "W", "2"},
            new String[]{"W", "Y", "1"},
            new String[]{"W", "Z", "5"}
        );
        assertTrue(mst.containsAll(expectedMST)); //asset true 
    }

    @Test
    public void testCreateGraph() {
        String[][] input = {
            {"U", "V", "2"},
            {"U", "W", "5"},
            {"U", "X", "1"},
            {"V", "W", "2"},
            {"V", "X", "3"},
            {"W", "X", "3"},
            {"W", "Y", "1"},
            {"W", "Z", "5"},
            {"X", "Y", "1"},
            {"Y", "Z", "2"}
        };
        
        Graph graph = Graph.createGraph(input);
        assertNotNull(graph);
        Map<String, Map<String, Integer>> adjList = graph.getAdjList();

        assertTrue(adjList.containsKey("U"));
        assertTrue(adjList.containsKey("V"));
        assertTrue(adjList.containsKey("W"));
        assertTrue(adjList.containsKey("X"));
        assertTrue(adjList.containsKey("Y"));
        assertTrue(adjList.containsKey("Z"));

        // check if certain edges exist in the graph
        assertEquals(2, adjList.get("U").get("V"));
        assertEquals(5, adjList.get("W").get("Z"));
        assertEquals(3, adjList.get("V").get("X"));
    }
}
