package leetcode.tree.perorderTraverse;

import leetcode.tree.TreeNode;

public class leetcode617_合并二叉树 {
    //t2 向t1 合并
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /*
          合并 t1和t2节点
        */
        if(t2==null) //t2==null时就不合并直接返回t1,不管t1
        {
            return t1;
        }
        if(t1==null){ //t1==null时 ，需要返回t2
            return t2;
        }
        t1.val+=t2.val; //此时t2、t1都不等于null，相加加
        t1.left=mergeTrees(t1.left,t2.left);   //向下左子树递归
        t1.right=mergeTrees(t1.right,t2.right); //向下右子树递归
        return t1;
    }
}
