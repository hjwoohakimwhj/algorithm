package binarytree;

//404
public class Code404_SumOfLeaf {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int count = sumOfLeftLeaves(right);
        if(left == null){
            return count;
        }else{
            if(left.left != null || left.right != null){
                count += sumOfLeftLeaves(left);
            }else{
                count += left.val;
            }
        }
        return count;

    }
}
