package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//02
public class BreathFirstTraversal {
    public static void breathFirstTraversal(TreeNode head){
        if(head == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            System.out.println(top.val);
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
        }
    }

    public static int maxBreadth(TreeNode head){
        if(head == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        //一加入queue也同时加入map
        queue.add(head);
        levelMap.put(head, 1);
        int curLevel = 1;
        //弹出检查时才变化curCount
        int curCount = 0;
        int max = 0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            int level = levelMap.get(top);
            if(level == curLevel){
                curCount++;
            }else{
                //在循环结束时，这一步会缺失依次
                curLevel = level;
                if(curCount > max){
                    max = curCount;
                }
                //第一次编写时漏掉
                curCount = 1;
            }
            if(top.left != null){
                queue.add(top.left);
                levelMap.put(top.left, level + 1);
            }
            if(top.right != null){
                queue.add(top.right);
                levelMap.put(top.right, level + 1);
            }
        }
        return Math.max(max, curCount);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.genTree();
        breathFirstTraversal(tree);
        System.out.println(maxBreadth(tree));
    }
}
