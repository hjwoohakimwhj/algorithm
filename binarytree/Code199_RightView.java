package binarytree;

import java.util.*;

public class Code199_RightView {
    //95.94% 55.88%
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if(root == null){
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        queue.add(root);
        q2.add(1);
        int cLevel = 1;
        int end = 0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            int level = q2.poll();
            if(level != cLevel){
                results.add(end);
                cLevel = level;
            }
            end = top.val;
            if(top.left != null){
                queue.add(top.left);
                q2.add(level + 1);
            }
            if(top.right != null){
                queue.add(top.right);
                q2.add(level + 1);
            }
        }
        results.add(end);
        return results;
    }
}
