package binarytree;

import java.util.LinkedList;
import java.util.Queue;

//112
public class Code112_SumPath {
    //100% 22.06%
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        int res = sum - root.val;
        //忘了考虑负的情况，下面代码是第一次提交错误的地方
        //if(res < 0){
        //return false;
        //}
        //除了值相等，还需要判断左右子树是否为空
        if(res == 0 && (root.left == null) && (root.right == null)){
            return true;
        }
        boolean leftHas = hasPathSum(root.left, res);
        boolean rightHas = hasPathSum(root.right, res);
        return leftHas || rightHas;
    }

    //采用迭代的方式，双队列
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();
        s1.add(root);
        s2.add(root.val);
        while(!s1.isEmpty()){
            TreeNode top = s1.poll();
            int value = s2.poll();
            if((value == sum) && (top.left == null) && (top.right == null)){
                return true;
            }
            if(top.left != null){
                s1.add(top.left);
                s2.add(top.left.val + value);
            }
            if(top.right != null){
                s1.add(top.right);
                s2.add(top.right.val + value);
            }
        }
        return false;
    }
}
