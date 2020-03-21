package leetcode.tree.postorderTraverse;

import leetcode.tree.TreeNode;

public class leetcode124_二叉树路径最大和 {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return max_sum;
    }
    private int getMax(TreeNode r) {
        if(r==null) return 0;
        int left=Math.max(0,getMax(r.left));
        int right=Math.max(0,getMax(r.right));
        max_sum=Math.max(max_sum,r.val+left+right);
        return Math.max(left,right)+r.val; //返回单侧最长路径
    }
}
