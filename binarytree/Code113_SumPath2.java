package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Code113_SumPath2 {
    List<List<Integer>> results;
    //借助LinkedList 递归处理完要删除添加的当前节点 100% 80.30%
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<List<Integer>>();
        if(root == null){
            return results;
        }
        LinkedList<Integer> tempList = new LinkedList<>();
        process(root, sum, tempList);
        return results;

    }

    public void process(TreeNode node, int sum, LinkedList<Integer> pre){
        if(node == null){
            return;
        }


        if(node.left == null && node.right == null && node.val == sum){
            pre.addLast(node.val);
            results.add(new ArrayList(pre));
            pre.removeLast();
            return;
        }

        pre.add(node.val);

        process(node.left, sum - node.val, pre);
        process(node.right, sum - node.val, pre);

        pre.removeLast();
    }

}
