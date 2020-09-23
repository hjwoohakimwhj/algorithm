package graph;

import java.util.HashSet;
import java.util.Stack;

public class DFS {
    public static void dfs(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.add(node);
        set.add(node);
        System.out.println(node.value);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            for(Node next : cur.nexts){
                if(!set.contains(next)){
                    //第一次漏掉部分，导致程序不结束
                    set.add(next);
                    stack.add(cur);
                    stack.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
