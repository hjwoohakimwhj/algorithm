package binarytree;

import java.util.*;

public class Code107_LevelOrderBottom {
    //21% 11.05%
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        Stack<List<Integer>> temp = new Stack<List<Integer>>();
        q.add(root);
        levels.add(1);
        int clevel = 1;
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            int level = levels.poll();
            if(clevel != level){
                temp.push(list);
                clevel = level;
                list = new ArrayList<>();
            }
            list.add(top.val);
            if(top.left != null){
                q.add(top.left);
                levels.add(level + 1);
            }
            if(top.right != null){
                q.add(top.right);
                levels.add(level + 1);
            }
        }
        temp.push(list);
        while(!temp.isEmpty()){
            results.add(temp.pop());
        }
        return results;
    }

    //第二次提交 使用递归 98.36% 5.31%
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if(root == null){
            return results;
        }
        process(root, 1, results);
        return results;
    }
    public void process(TreeNode node, int depth, List<List<Integer>> results){
        if(node == null){
            return;
        }
        if(depth == (results.size() + 1)){
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            results.add(0, list);
        }else{
            results.get(results.size() - depth).add(node.val);
        }
        process(node.left, depth + 1, results);
        process(node.right, depth + 1, results);
    }
}
