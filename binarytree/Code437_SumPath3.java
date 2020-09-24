package binarytree;

import java.util.LinkedList;

public class Code437_SumPath3 {
    public int total;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        LinkedList<Integer> tempList = new LinkedList<Integer>();
        return process(root, sum, tempList);
    }

    public int process(TreeNode node, int sum, LinkedList<Integer> tempList){
        if(node == null){
            return 0;
        }

        tempList.addLast(node.val);

        int accu = 0;
        int count = 0;
        for(int i = (tempList.size() - 1); i >= 0; i--){
            accu += tempList.get(i);
            if(accu == sum){
                count++;
            }
        }

        int leftNum = process(node.left, sum, tempList);
        int rightNum = process(node.right, sum, tempList);
        count = count + leftNum + rightNum;
        tempList.removeLast();
        return count;
    }

    //第二次提交 使用数组 99.79% 19.03%
    public int pathSum2(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        return process2(root, sum, new int[1000], 0);
    }
    public int process2(TreeNode node, int sum, int[] path, int end){
        if(node == null){
            return 0;
        }
        path[end] = node.val;
        int accu = 0;
        int count = 0;
        for(int i = end; i >= 0; i--){
            accu += path[i];
            if(accu == sum){
                count++;
            }
        }
        end += 1;
        int leftNum = process2(node.left, sum, path, end);
        int rightNum = process2(node.right, sum, path, end);
        count = count + leftNum + rightNum;
        return count;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        tree.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        Code437_SumPath3 sumPath = new Code437_SumPath3();
        int count = sumPath.pathSum(tree, 3);
        System.out.println(count);
    }
}
