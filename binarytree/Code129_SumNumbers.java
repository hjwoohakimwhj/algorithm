package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code129_SumNumbers {
    //受到112的启发，使用双队列，双队列可以转化为递归 29.90% 52.35%
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> s1 = new LinkedList<>();
        Queue<Integer> s2 = new LinkedList<>();
        s1.add(root);
        s2.add(root.val);
        int sum = 0;
        while(!s1.isEmpty()){
            TreeNode top = s1.poll();
            int value = s2.poll();
            if(top.left == null && top.right == null){
                sum += value;
                continue;
            }
            if(top.left != null){
                s1.add(top.left);
                s2.add(top.left.val + value * 10);
            }
            if(top.right != null){
                s1.add(top.right);
                s2.add(top.right.val + value * 10);
            }
        }
        return sum;
    }

    //第二次提交 采用递归 100% 47.01%
    public int sumNumbers2(TreeNode root) {
        return process2(root, 0);
    }

    public int process2(TreeNode node, int num){
        if(node == null){
            return 0;
        }
        int value = node.val + num * 10;
        if(node.left == null && node.right == null){
            return value;
        }
        int leftNum = process2(node.left, value);
        int rightNum = process2(node.right, value);
        return leftNum +rightNum;
    }

    //第三次提交，用双栈 修改中序遍历代码 16.98% 27.49%
    public int sumNumbers3(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        int pre = 0;
        while(!s1.isEmpty() || cur != null){
            if(cur != null){
                s1.push(cur);
                pre = cur.val + 10 * pre;
                s2.push(pre);
                cur = cur.left;
            }else{
                cur = s1.pop();
                int value = s2.pop();
                if(cur.left == null && cur.right == null){
                    sum += value;
                }
                cur = cur.right;
                pre = value;
            }
        }
        return sum;
    }
}
