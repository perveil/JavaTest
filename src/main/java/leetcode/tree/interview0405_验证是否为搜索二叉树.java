package leetcode.tree;
/*
* 对于root
* root，的左子树数值满足，大于min，小于root.val
* root, 的右子树数值满足，大于root.val 小于 max
*
* */
public class interview0405_验证是否为搜索二叉树 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        return root == null ||
                (root.val > min && root.val < max
                && isValidBST(root.left, min, root.val)
                && isValidBST(root.right, root.val, max));
    }
}
