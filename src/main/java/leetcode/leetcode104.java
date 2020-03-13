package leetcode;

import leetcode.tree.TreeNode;

public class leetcode104 {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null) return 0;
            return findmaxDepth(root);
        }
        public int findmaxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            int rightDepth=findmaxDepth(root.right);
            int leftDepth=findmaxDepth(root.left);

            return rightDepth>leftDepth?rightDepth+1:leftDepth+1;
        }
    }
}
