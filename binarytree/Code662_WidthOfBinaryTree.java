package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Code662_WidthOfBinaryTree {
    //第一次提交 使用队列 5.17% 20.10%
    public static class Info {
        int level;
        int index;
        public Info(int level, int index){
            this.level = level;
            this.index = index;
        }
    }
    //官方做法
    class AnnotatedNode {
        TreeNode node;
        int depth, pos;
        AnnotatedNode(TreeNode n, int d, int p) {
            node = n;
            depth = d;
            pos = p;
        }
    }
    //第一次提交
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Info> map = new HashMap<>();
        queue.add(root);
        map.put(root, new Info(1, 0));
        int max = 0;
        int clevel = 1;
        TreeNode before = root;
        TreeNode end = root;
        Info beforeInfo;
        Info endInfo;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            Info info = map.get(top);
            if(info.level != clevel){
                beforeInfo = map.get(before);
                endInfo = map.get(end);
                if((endInfo.index - beforeInfo.index + 1) > max){
                    max = endInfo.index - beforeInfo.index + 1;
                }
                before = top;
                end = top;
                clevel = info.level;
            }else{
                end = top;
            }
            if(top.left != null){
                int leftLevel = info.level + 1;
                int leftIndex = info.index * 2 + 1;
                map.put(top.left, new Info(leftLevel, leftIndex));
                queue.add(top.left);
            }
            if(top.right != null){
                int rightLevel = info.level + 1;
                int rightIndex = info.index * 2 + 2;
                map.put(top.right, new Info(rightLevel, rightIndex));
                queue.add(top.right);
            }
        }
        beforeInfo = map.get(before);
        endInfo = map.get(end);
        if((endInfo.index - beforeInfo.index + 1) > max){
            max = endInfo.index - beforeInfo.index + 1;
        }
        return max;
    }

    //第二次提交，每一次有新节点加入都进行值的计算， 5.17% 37.80%
    public int widthOfBinaryTree2(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Info> infos = new HashMap<>();
        queue.add(root);
        infos.put(root, new Info(1, 0));
        int leftIndex = 0;
        int cLevel = 1;
        int max = 0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            Info info = infos.get(top);
            if(info.level != cLevel){
                leftIndex = info.index;
                cLevel = info.level;
            }
            int length = info.index - leftIndex + 1;
            if(length > max){
                max = length;
            }
            if(top.left != null){
                int leftIn = info.index * 2 + 1;
                int leftLevel = info.level + 1;
                infos.put(top.left, new Info(leftLevel, leftIn));
                queue.add(top.left);
            }
            if(top.right != null){
                int rightIn = info.index * 2 + 2;
                int rightLevel = info.level + 1;
                infos.put(top.right, new Info(rightLevel, rightIn));
                queue.add(top.right);
            }
        }
        return max;
    }

    //官方做法，对node进行封装
    public int widthOfBinaryTree3(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }

    //第三次提交，将map改成队列，即采用双队列的方式 71.24% 5.82%
    public int widthOfBinaryTree4(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Info> infos = new LinkedList<>();
        queue.add(root);
        infos.add(new Info(1, 0));
        int leftIndex = 0;
        int cLevel = 1;
        int max = 0;
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            Info info = infos.poll();
            if(info.level != cLevel){
                leftIndex = info.index;
                cLevel = info.level;
            }
            int length = info.index - leftIndex + 1;
            if(length > max){
                max = length;
            }
            if(top.left != null){
                int leftIn = info.index * 2 + 1;
                int leftLevel = info.level + 1;
                infos.add(new Info(leftLevel, leftIn));
                queue.add(top.left);
            }
            if(top.right != null){
                int rightIn = info.index * 2 + 2;
                int rightLevel = info.level + 1;
                infos.add(new Info(rightLevel, rightIn));
                queue.add(top.right);
            }
        }
        return max;
    }
}
