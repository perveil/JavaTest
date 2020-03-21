package leetcode.tree.perorderTraverse;

import leetcode.tree.TreeNode;
/*
* 先序遍历
* */
public class leetcode112_验证路径和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.left==null&&root.right==null){ //验证叶子节点
            return root.val==sum;
        }
        return  hasPathSum(root.right,sum-root.val)||hasPathSum(root.left,sum-root.val);
    }
}
