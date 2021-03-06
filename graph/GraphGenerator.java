package graph;

public class GraphGenerator {
    public static Graph createGraph(int[][] matrix){
        Graph graph = new Graph();
        for(int i = 0; i < matrix.length; i++){
            int weight = matrix[i][0];
            int from = matrix[i][1];
            int to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }

            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }

            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight, fromNode, toNode);
            graph.edges.add(newEdge);
            fromNode.nexts.add(toNode);
            fromNode.out++;
            fromNode.edges.add(newEdge);
            toNode.in++;
        }
        return graph;
    }
}
