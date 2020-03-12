package leetcode.tree;
/*
*  根据前序遍历、中序遍历构造二叉树
* */
public class leetcode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        return buildSubTree(preorder,inorder,0,0,inorder.length-1);

    }
    public TreeNode buildSubTree(int[] preorder, int[] inorder,int preindex,int start,int end) {
        if(preindex > preorder.length - 1||start>end) return null;
        TreeNode root=new TreeNode(preorder[preindex]); //构建根节点
        for(int i=start;i<=end;i++){
            if(inorder[i]==preorder[preindex]){
                root.right=buildSubTree(preorder,inorder,preindex+i+1-start,i+1,end); //构建右子树,
                root.left=buildSubTree(preorder,inorder,preindex+1,start,i-1);       //构建左子树,左子树的根节点就在其父亲节点的下一个
                break;
            }
        }
        return root;
    }
}
