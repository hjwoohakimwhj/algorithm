package binarytree;

public class Code437_SumPath {
    public int total;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        this.total = sum;
        return process(root, sum);
    }

    public int process(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        System.out.println("===========================");
        System.out.println(node.val + " : " + sum);

        int res = 0;
        if(node.val == sum){
            res = 1;
        }
        System.out.println("res is " + res);

        int leftNum = process(node.left, sum - node.val);
        if(res == 0){
            int leftNum2 = process(node.left, this.total);
        }
        int leftNum2 = process(node.left, this.total);
        System.out.println("left1 is " + leftNum + " ; left2 is " + leftNum2);
        int rightNum = process(node.right, sum - node.val);
        int rightNum2 = process(node.right, this.total);
        System.out.println("right1 is " + rightNum + " ; right2 is " + rightNum2);
        return leftNum + leftNum2 + rightNum + rightNum2 + res;
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
        Code437_SumPath sumPath = new Code437_SumPath();
        int count = sumPath.pathSum(tree, 3);
    }
}
