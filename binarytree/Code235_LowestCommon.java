package binarytree;

public class Code235_LowestCommon {
    //叉搜索树的最近公共祖先 99.70% 51.12%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        return process(root, p, q);
    }

    public TreeNode process(TreeNode node, TreeNode p, TreeNode q){
        if((p.val > node.val) && (q.val > node.val)){
            return process(node.right, p, q);
        }
        if((p.val < node.val) && (q.val < node.val)){
            return process(node.left, p, q);
        }
        return node;
    }
}
