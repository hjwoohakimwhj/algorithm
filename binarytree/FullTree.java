package binarytree;

public class FullTree {
    public static class FullInfo {
        public int nodes;
        public int depth;
        public FullInfo(int nodes, int depth){
            this.nodes = nodes;
            this.depth = depth;
        }
    }

    public static boolean isFull(TreeNode head){
        FullInfo info = process(head);
        return info.nodes == ((1 << info.depth) - 1);
    }

    public static int getNodesNum(TreeNode head){
        FullInfo info = process(head);
        return info.nodes;
    }

    public static int getDepth(TreeNode head){
        FullInfo info = process(head);
        return info.depth;
    }

    public static FullInfo process(TreeNode node){
        if(node == null){
            return new FullInfo(0, 0);
        }
        FullInfo leftInfo = process(node.left);
        FullInfo rightInfo = process(node.right);
        int nodes = leftInfo.nodes + rightInfo.nodes + 1;
        int depth = Math.max(leftInfo.depth, rightInfo.depth) + 1;
        return new FullInfo(nodes, depth);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.genTree();
        System.out.println(getDepth(tree));
        System.out.println(getNodesNum(tree));
    }

}
