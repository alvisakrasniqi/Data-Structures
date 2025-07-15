import java.util.*;

public class Graph {
   
    private final Map<String, Map<String, Integer>> adjList;

    ///constructor for the graph class
    public Graph() {
        
        this.adjList = new HashMap<>();
    }

    //method to get adjList which is helpful for testing
    public Map<String, Map<String, Integer>> getAdjList() {
        return adjList;
    }


     //method to add a node
    public boolean addNode(String name){
      
        if (adjList.containsKey(name)){
         return false;
        }
     adjList.put(name, new HashMap<>());
        return true;
     }

    
     // method to add an undirected edge 
    public boolean addEdge(String from, String to, int weight){
       
        if (weight < 0 || !adjList.containsKey(from) || !adjList.containsKey(to) || adjList.get(from).containsKey(to)){
            return false;
        }

        adjList.get(from).put(to, weight);
        adjList.get(to).put(from, weight);
        return true;
    }

    // method to add edges from the specified source node from to each node in the toList array, with corresponding weight
    public boolean addEdges(String from, String[] toList, int[] weightList){
       
        if (toList.length != weightList.length || !adjList.containsKey(from)){
            return false;
        }
        
        for (int i = 0; i < toList.length; i++) {
                if (!addEdge(from, toList[i], weightList[i])){
                    return false;
                }
            }
        return true;
    }
    
    // method to remove a node and all its connected edges
    public boolean removeNode(String name){
       
        if (!adjList.containsKey(name)){
            return false;
        }
       
        adjList.remove(name).forEach((neighbor, weight) -> adjList.get(neighbor).remove(name));
        return true;
    }

    // method to remove an undirected edge between two nodes
    public boolean removeEdge(String from, String to){
        
        if (!adjList.containsKey(from) || !adjList.containsKey(to) || !adjList.get(from).containsKey(to)){
            return false;
        }
        
        adjList.get(from).remove(to);
        adjList.get(to).remove(from);
        return true;
    }

    // method to print the graph in adjacency list 
    public void printGraph() {
        adjList.keySet().stream()
                .sorted()
                .forEach(node -> {
                    System.out.print(node);
                    adjList.get(node).entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .forEach(entry -> System.out.print(" " + entry.getValue() + " " + entry.getKey()));
                    System.out.println();
                });
    }

    //creates graph from 2d array of strings
    public static Graph createGraph(String[][] input) {
        Graph graph = new Graph();
        for (String[] row : input) {
            if (row.length != 3) return null;
            try {
                int weight = Integer.parseInt(row[2]);
                graph.addNode(row[0]);
                graph.addNode(row[1]);
                graph.addEdge(row[0], row[1], weight);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return graph;
    }

    // method for finding shortest path using dijkstra's algorithm
    public int shortestDistance(String from, String to) {
        if (!adjList.containsKey(from) || !adjList.containsKey(to)) return -1;

        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        adjList.keySet().forEach(node -> distances.put(node, Integer.MAX_VALUE));
        distances.put(from, 0);
        queue.add(from);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);

            for (Map.Entry<String, Integer> neighbor : adjList.get(current).entrySet()) {
                int newDistance = currentDistance + neighbor.getValue();
                if (newDistance < distances.get(neighbor.getKey())) {
                    distances.put(neighbor.getKey(), newDistance);
                    queue.add(neighbor.getKey());
                }
            }
        }
        return distances.getOrDefault(to, Integer.MAX_VALUE) == Integer.MAX_VALUE ? -1 : distances.get(to);
    }

        // prim's algorithm to find the minimum spanning tree
        public List<String[]> minimumSpanningTree() {
            if (adjList.isEmpty()) return null;
            
            List<String[]> mst = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            PriorityQueue<String[]> edges = new PriorityQueue<>(Comparator.comparingInt(edge -> Integer.parseInt(edge[2])));
            
            String startNode = adjList.keySet().iterator().next();
            visited.add(startNode);
            
            adjList.get(startNode).forEach((neighbor, weight) -> edges.add(new String[]{startNode, neighbor, String.valueOf(weight)}));
    
            while (!edges.isEmpty()) {
                String[] edge = edges.poll();
                if (visited.contains(edge[1])) continue;
                mst.add(edge);
                visited.add(edge[1]);
                adjList.get(edge[1]).forEach((neighbor, weight) -> {
                    if (!visited.contains(neighbor)) {
                        edges.add(new String[]{edge[1], neighbor, String.valueOf(weight)});
                    }
                });
            }
            return visited.size() == adjList.size() ? mst : null;
        }
    }