package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTree {
    public static boolean isCBT(TreeNode head){
        if(head == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        //leaf标识后序节点是否必须为叶子节点
        boolean leaf = false;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            TreeNode left = top.left;
            TreeNode right = top.right;
            if(leaf){
                //开启标识后，左右树都必须为空
                if(left != null || right != null){
                    return false;
                }
            }else{
                if(left != null){
                    queue.add(left);
                    //左树不为空，右树为空，开启标识
                    if(right == null){
                        leaf = true;
                    }else{
                        //左右树都不为空
                        queue.add(right);
                    }

                }else{
                    //左右树都为空，开启标识
                    if(right == null){
                        //左树右树都为空
                        leaf = true;
                    }else{
                        //左树为空，右树不为空，直接返回false
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
