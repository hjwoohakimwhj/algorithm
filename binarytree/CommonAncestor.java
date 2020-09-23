package binarytree;

public class CommonAncestor {
    public class Info {
        boolean findObj1;
        boolean findObj2;
        TreeNode findNode;
        public Info(boolean findObj1, boolean findObj2, TreeNode findNode){
            this.findObj1 = findObj1;
            this.findObj2 = findObj2;
            this.findNode = findNode;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Info info = process(root, p, q);
        return info.findNode;
    }

    public Info process(TreeNode x, TreeNode p, TreeNode q){
        if(x == null){
            return new Info(false, false, null);
        }

        Info leftInfo = process(x.left, p, q);
        Info rightInfo = process(x.right, p, q);

        //左子树有p和q
        if(leftInfo.findNode != null){
            return leftInfo;
        }
        //右子树有p和q
        if(rightInfo.findNode != null){
            return rightInfo;
        }

        //左右子树有p和q
        if((leftInfo.findObj1 || rightInfo.findObj1)
                && (leftInfo.findObj2 || rightInfo.findObj2)
        ){
            return new Info(true, true, x);
        }

        //左右子树有p，但没有q
        if(leftInfo.findObj1 || rightInfo.findObj1){
            if(x == q){
                return new Info(true, true, x);
            }else{
                return new Info(true, false, null);
            }
        }
        //左右子树有q，但没有p
        if(leftInfo.findObj2 || rightInfo.findObj2){
            if(x == p){
                return new Info(true, true, x);
            }else{
                return new Info(false, true, null);
            }
        }
        //左右子树都没有p和q，检查是否x等于p或q
        if(x == p){
            return new Info(true, false, null);
        }
        if(x == q){
            return new Info(false, true, null);
        }
        return new Info(false, false, null);
    }

    public static void main(String[] args) {
        CommonAncestor ancestor = new CommonAncestor();
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
        TreeNode result = ancestor.lowestCommonAncestor(treeNode, treeNode3, treeNode6);
        System.out.println(result.val);
    }
}
