package leetcode.tree;

public class leetcode222 {
    /*
    * 常规解法
    * */
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        if (root.right==null && root.left==null) return 1;
        return countNodes(root.right)+countNodes(root.left)+1;
    }
    /*
    *  设，根节点的左子树高度和右节点高度为 left、right
    *  left==right 说明右子树有填充，左子树为满二叉树，递归右子树
    *  left==right 说明右子树无填充，左子树为完全二叉树，递归左子树
    * */
    public int countNodes2(TreeNode root) {
        if (root==null) return 0;
        int left=countLevel(root.left);
        int right=countLevel(root.right);
        if (left==right){
            return countNodes2(root.right)+(1<<left);
        }else {
            return countNodes2(root.left)+(1<<right);
        }

    }
    /*
    非递归计算完全二叉树高度
    * */
    private int countLevel(TreeNode root){
        int level=0;
        while(root==null){
            root=root.left;
            level++;
        }
        return level;
    }

}
