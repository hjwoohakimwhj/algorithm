package binarytree;

//1123 最深叶节点的最近公共祖先
public class CommonAncestor2 {
    public static class Info {
        public int depth;
        public TreeNode cNode;
        public Info(int depth, TreeNode cNode){
            this.depth = depth;
            this.cNode = cNode;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Info info = process(root);
        return info.cNode;
    }
    public static Info process(TreeNode x){
        if(x == null){
            return new Info(0, null);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        if(leftInfo.depth == rightInfo.depth){
            return new Info(leftInfo.depth + 1, x);
        }
        if(leftInfo.depth > rightInfo.depth){
            return new Info(leftInfo.depth + 1, leftInfo.cNode);
        }else{
            return new Info(rightInfo.depth + 1, rightInfo.cNode);
        }
    }
}
