package leetcode.tree;
/*
* *  根据后序遍历、中序遍历构造二叉树
* */
public class leetcode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0) return null;
        return buildSubTree(postorder,inorder,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildSubTree(int[] postorder, int[] inorder,int postindex,int start,int end) {
        if(postindex <-1||start>end) return null;
        TreeNode root=new TreeNode(postorder[postindex]); //构建根节点
        for(int i=start;i<=end;i++){
            if(inorder[i]==postorder[postindex]){
                root.right=buildSubTree(postorder,inorder,postindex-1,i+1,end); //构建右子树,
                root.left=buildSubTree(postorder,inorder,postindex-end+i-1,start,i-1);       //构建左子树,左子树的根节点就在其父亲节点的下一个
                break;
            }
        }
        return root;
    }
}
