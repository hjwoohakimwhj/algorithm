package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code257_TreePath {
    public List<String> results;

    //87.94% 9.02%
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    //第二次提交 7.13% 81.16%
    public List<String> binaryTreePaths2(TreeNode root) {
        results = new ArrayList<>();
        if(root == null){
            return results;
        }
        LinkedList<Integer> tempList = new LinkedList<>();
        process2(root, tempList);
        return results;
    }

    public void process2(TreeNode node, LinkedList<Integer> tempList){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            String newString = "";
            for(int i = 0; i < tempList.size(); i++){
                newString = newString + tempList.get(i) + "->";
            }
            newString += node.val;
            results.add(newString);
            return;
        }

        tempList.addLast(node.val);
        process2(node.left, tempList);
        process2(node.right, tempList);
        tempList.removeLast();
    }
}
