package graph;

import java.util.*;

public class SortedTopology {
    //联想到BFS,都是用队列
    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node, Integer> inMap = new HashMap<>();
        List<Node> results = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        for(Node node : graph.nodes.values()){
            if(node.in == 0){
                queue.add(node);
            }
            inMap.put(node, node.in);
        }
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            results.add(cur);
            for(Node next : cur.nexts){
                inMap.put(next, inMap.get(next) - 1);
                if(inMap.get(next) == 0){
                    queue.add(next);
                }
            }

        }
        return results;
    }
}
