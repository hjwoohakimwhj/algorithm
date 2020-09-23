package binarytree;

public class BalancedTree {
    public static class BalancedInfo {
        public int depth;
        public boolean isBalanced;
        public BalancedInfo(int depth, boolean isBalanced){
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalanced(TreeNode head){
       BalancedInfo info = process(head);
       return info.isBalanced;
    }

    public static BalancedInfo process(TreeNode node){
        if(node == null){
            return new BalancedInfo(0, true);
        }
        BalancedInfo leftInfo = process(node.left);
        BalancedInfo rightInfo = process(node.right);
        int depth = Math.max(leftInfo.depth, rightInfo.depth) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && (Math.abs(leftInfo.depth - rightInfo.depth) <= 1);
        return new BalancedInfo(depth, isBalanced);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.genTree();
        System.out.println(isBalanced(tree));
    }

}
