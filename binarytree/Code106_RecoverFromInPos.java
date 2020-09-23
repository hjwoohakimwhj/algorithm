package binarytree;

import java.util.HashMap;
import java.util.Map;

public class Code106_RecoverFromInPos {
    public Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return process(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode process(int[] inorder, int inP, int inQ, int[] postorder, int posP, int posQ){
        if(inP > inQ){
            return null;
        }
        if(inP == inQ){
            return new TreeNode(inorder[inP]);
        }
        int inIndex = map.get(postorder[posQ]);
        TreeNode node = new TreeNode(inorder[inIndex]);
        node.left = process(inorder, inP, inIndex - 1, postorder, posP, (posP + (inIndex - inP) - 1));
        node.right = process(inorder, inIndex + 1, inQ, postorder, posP + (inIndex - inP), posQ - 1);
        return node;
    }
}
