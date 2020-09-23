package binarytree;

public class BST {
    public static class Info {
        public int max;
        public int min;
        public boolean isBST;
        public Info(int max, int min, boolean isBST){
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public static boolean isBST(TreeNode head){
        Info info = process(head);
        return info.isBST;
    }

    public static  int getMax(TreeNode head){
        Info info = process(head);
        return info.max;
    }

    public static int getMin(TreeNode head){
        Info info = process(head);
        return info.min;
    }

    public static Info process(TreeNode x){
        if(x == null){
            return null;
        }
        Info leftData = process(x.left);
        Info rightData = process(x.right);
        int max = x.val;
        int min = x.val;

        if(leftData != null){
           max = Math.max(max, leftData.max);
           min = Math.min(min, leftData.min);
        }
        if(rightData != null){
           max = Math.max(max, rightData.max);
           min = Math.min(min, rightData.min);
        }

        boolean leftBST = leftData == null ? true : (leftData.isBST && (leftData.max < x.val));
        boolean rightBST = rightData == null ? true : (rightData.isBST && (rightData.min > x.val));
        boolean isBST = leftBST && rightBST;
        return new Info(max, min, isBST);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.genTree();
        System.out.println(isBST(tree));
        System.out.println(getMin(tree));
        System.out.println(getMax(tree));
    }
}
