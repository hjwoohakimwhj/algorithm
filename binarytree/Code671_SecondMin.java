package binarytree;

public class Code671_SecondMin {
    //100% 69.74%
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        if(root.left == null && root.right == null){
            return -1;
        }
        return process(root, root.val);

    }
    public int process(TreeNode node, int min){
        if(node == null){
            return -1;
        }
        if(node.val > min){
            return node.val;
        }
        int left = process(node.left, min);
        int right = process(node.right, min);
        if(left == -1 && right == -1){
            return -1;
        }
        if(left != -1 && right != -1){
            return Math.min(left, right);
        }
        return left != -1 ? left : right;
    }
}
