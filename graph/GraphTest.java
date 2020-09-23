package graph;

public class GraphTest {
    public static void main(String[] args) {
        int[][] graphArray = {{1, 1, 2}, {1, 1, 3}, {1, 2, 3}, {1, 3, 4}, {1, 3, 5}, {1, 2, 6}};
        Graph graph = GraphGenerator.createGraph(graphArray);
        Node nodeA = graph.nodes.get(1);
        System.out.println("BFS");
        BFS.bfs(nodeA);
        System.out.println("DFS");
        DFS.dfs(nodeA);
    }
}
