package binarytree;

import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }

    public static TreeNode genTree(){
        TreeNode treeNode = new TreeNode(-1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(-2);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(8);
        treeNode4.left = treeNode6;
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.genTree();
    }
}
