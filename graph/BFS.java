package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node node){
        //第一次漏了
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> addedNodes = new HashSet<>();
        queue.add(node);
        addedNodes.add(node);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value);
            for(Node next : cur.nexts){
                if(!addedNodes.contains(next)){
                    queue.add(next);
                    addedNodes.add(next);
                }
            }
        }
    }
}
