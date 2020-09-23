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
        if(root == null){
            return null;
        }
        Info info = process(root, p, q);
        return info.findNode;
    }

    public Info process(TreeNode x, TreeNode p, TreeNode q){
        if(x == null){
            return new Info(false, false, null);
        }

        Info leftInfo = process(x.left, p, q);
        if(leftInfo.findNode != null){
            return new Info(leftInfo.findObj1, leftInfo.findObj2, leftInfo.findNode);
        }
        Info rightInfo = process(x.right, p, q);

        if(rightInfo.findNode != null){
            return new Info(rightInfo.findObj1, rightInfo.findObj2, rightInfo.findNode);
        }

        if((leftInfo.findObj1 && rightInfo.findObj2) || (leftInfo.findObj2 && rightInfo.findObj1) || ((leftInfo.findObj1 || rightInfo.findObj1) && x == q) ||
                ((leftInfo.findObj2 || rightInfo.findObj2) && x == p)){
            return new Info(true, true, x);
        }

        if(x == p){
            System.out.println("x = p: p is " + x.val);
            return new Info(true, false, null);
        }else{
            if(x == q){
                System.out.println("x = q : q is " + x.val);
                return new Info(false, true, null);
            }else{
                //第一次提交出错的地方
                return new Info(leftInfo.findObj1 || rightInfo.findObj1, rightInfo.findObj2 || rightInfo.findObj2, null);
            }
        }
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
