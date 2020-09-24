package binarytree;

public class Code543_DiameterOfTree {
    public class Info {
        public int depth;
        public int length;
        public Info(int d, int l){
            this.depth = d;
            this.length = l;
        }
    }

    //第一次提交 17.91% 5.10%
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Info info = process(root);
        return info.depth > info.length ? (info.depth - 1) : (info.length - 1);
    }

    public Info process(TreeNode node){
        if(node == null){
            return new Info(0, 0);
        }

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int depth = leftInfo.depth > rightInfo.depth ? leftInfo.depth + 1 : rightInfo.depth + 1;
        int cur = leftInfo.depth + rightInfo.depth + 1;
        int length = Math.max(cur, leftInfo.length);
        length = Math.max(length, rightInfo.length);
        return new Info(depth, length);

    }

    //官方答案
    int ans;
    public int diameterOfBinaryTree2(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0; // 访问到空节点了，返回0
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L+R+1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }
}
