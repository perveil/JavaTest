package leetcode.tree.inorderTraverse;

import leetcode.tree.TreeNode;

/*
* 中序遍历，从大到小的遍历二叉树过程中sum叠加，当遍历到cur时，
* 此时的sum是已经遍历结束的比其大的节点的和
* */
public class leetcode1038_叠加二叉树 {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    private void traverse(TreeNode root) {
        if (root==null) return;
        traverse(root.right); //从大到小的遍历
        root.val+=sum;
        sum+=root.val;
        traverse(root.left);
    }
}
