package leetcode.tree;
/*
*  有序数组构造平衡二叉树
*
* */
public class leetcode108 {
    public TreeNode buildSubTree(int[] nums,int start,int end) {
        if(start>end) return null;
        int middle=(start+end)/2;
        TreeNode root=new TreeNode(nums[middle]); //构建根节点
        root.right=buildSubTree(nums,middle+1,end); //构建右子树,
        root.left=buildSubTree(nums,start,middle-1);          //构建左子树
        return root;
    }
}
