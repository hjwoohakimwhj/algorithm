package binarytree;

import java.util.HashMap;
import java.util.Map;

//105
public class Code105_RecoverFromPrePos {
    //第二次提交引入的变量
    public Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    //第一次提交，这种方式的缺点是每次都要扫描在中序里面根节点的索引，时间复杂度高 30.01% 65.47%
    public TreeNode process(int[] preorder, int pre1, int pre2, int[] inorder, int in1, int in2){
        if(pre1 > pre2){
            return null;
        }
        if(pre1 == pre2){
            return new TreeNode(preorder[pre1]);
        }
        for(int i = in1; i <= in2; i++){
            if(preorder[pre1] == inorder[i]){
                TreeNode node = new TreeNode(preorder[pre1]);
                TreeNode leftNode = process(preorder, pre1 + 1, pre1 + (i - in1) ,  inorder, in1, i - 1);
                TreeNode rgihtNode = process(preorder, pre1 + (i - in1) + 1, pre2, inorder, i + 1, in2);
                node.left = leftNode;
                node.right = rgihtNode;
                return node;
            }
        }
        return null;
    }

    //第二次提交，先对中序遍历的结果生成哈希表，键值为中序的值，value为索引 73.95% 23.86%
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return process2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode process2(int[] preorder, int pre1, int pre2, int[] inorder, int in1, int in2){
        if(pre1 > pre2){
            return null;
        }
        if(pre1 == pre2){
            return new TreeNode(preorder[pre1]);
        }
        //通过索引降低时间开销
        int i = map.get(preorder[pre1]);
        TreeNode node = new TreeNode(preorder[pre1]);
        TreeNode leftNode = process(preorder, pre1 + 1, pre1 + (i - in1) ,  inorder, in1, i - 1);
        TreeNode rgihtNode = process(preorder, pre1 + (i - in1) + 1, pre2, inorder, i + 1, in2);
        node.left = leftNode;
        node.right = rgihtNode;
        return node;
    }
}
