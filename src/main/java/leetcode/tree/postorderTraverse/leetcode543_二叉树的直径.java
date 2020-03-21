package leetcode.tree.postorderTraverse;

import leetcode.tree.TreeNode;

public class leetcode543_二叉树的直径 {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }
    /*
    * 求解二叉树的最大深度
    * */
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1; // 求最高深度
    }
}
