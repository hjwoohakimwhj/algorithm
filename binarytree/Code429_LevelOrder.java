package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code429_LevelOrder {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //54.44% 14.60% 用队列的addAll方法可以提升到79.99%
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null){
            return results;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                list.add(node.val);
                List<Node> children = node.children;
                //或者用queue.addAll(node.children);
                for(int j = 0; j < children.size(); j++){
                    queue.add(children.get(j));
                }
            }
            results.add(list);
        }
        return results;
    }
}
