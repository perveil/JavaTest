package leetcode.tree.postorderTraverse;

import leetcode.tree.TreeNode;

public class interview27_二叉树的对称镜像 {
    /*
    * 对称树
    * */
    public TreeNode mirrorTree(TreeNode root) {
        switchTree(root);
        return root;
    }
    public void switchTree(TreeNode root) {
        if(root==null) return;
        switchTree(root.right);
        switchTree(root.left);
        //后序
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
    }
}
