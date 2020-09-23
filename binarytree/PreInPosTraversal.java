package binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

//01
public class PreInPosTraversal {
    //递归先序
    public static void preOrderRecur(TreeNode head){
        if(head == null){
            return;
        }
        System.out.println(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //递归中序
    public static void inOrderRecur(TreeNode head){
        if(head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.println(head.val);
        inOrderRecur(head.right);
    }
    //递归后序
    public static void posOrderRecur(TreeNode head){
        if(head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.val);
    }

    public static void preOrderUnRecur(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            System.out.println(top.val);
            if(top.right != null){
                stack.push(top.right);
            }
            if(top.left != null){
                stack.push(top.left);
            }
        }
    }

    public static void posOrderUnRecur(TreeNode head){
        if(head == null){
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(head);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top);
            if(top.left != null){
                s1.push(top.left);
            }
            if(top.right != null) {
                s1.push(top.right);
            }
        }
        while(!s2.isEmpty()){
            TreeNode top = s2.pop();
            System.out.println(top.val);
        }
    }

    public static void inOrderUnRecur(TreeNode head){
        if(head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while((!stack.isEmpty()) || (cur != null)){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.genTree();
        //preOrderRecur(tree);
        //System.out.println("==================");
        //preOrderUnRecur(tree);

        //posOrderRecur(tree);
        //System.out.println("==================");
        //posOrderUnRecur(tree);

        inOrderRecur(tree);
        System.out.println("====================");
        inOrderUnRecur(tree);
    }
}
