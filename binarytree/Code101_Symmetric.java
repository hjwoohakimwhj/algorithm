package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code101_Symmetric {
    //第一次提交 8.10% 21.17%
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        Stack<TreeNode> left = new Stack<TreeNode>();
        Stack<TreeNode> right = new Stack<TreeNode>();
        TreeNode leftCur = root.left;
        TreeNode rightCur = root.right;
        while((leftCur != null || (!left.isEmpty())) && (rightCur != null || (!right.isEmpty()))){
            if(leftCur != null){
                if(rightCur == null){
                    return false;
                }
                left.push(leftCur);
                right.push(rightCur);
                leftCur = leftCur.left;
                rightCur = rightCur.right;
            }else{
                if(rightCur != null){
                    return false;
                }
                leftCur = left.pop();
                rightCur = right.pop();
                if(leftCur.val != rightCur.val){
                    return false;
                }
                leftCur = leftCur.right;
                rightCur = rightCur.left;
            }
        }
        return (leftCur != null || (!left.isEmpty())) == (rightCur != null || (!right.isEmpty()));
    }

    //第二次提交，使用单队列 8.10% 5.03%
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }
    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

    //第三次提交 使用递归
    public boolean isSymmetric3(TreeNode root) {
        if(root == null){
            return true;
        }
        return check3(root.left, root.right);
    }
    public boolean check3(TreeNode u, TreeNode v) {
        if(u == null && v == null){
            return true;
        }
        if(u == null || v == null){
            return false;
        }

        if(u.val != v.val){
            return false;
        }
        return check3(u.left, v.right) && check3(u.right, v.left);
    }
}
