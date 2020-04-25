package leetcode.tree.inorderTraverse;

import leetcode.tree.TreeNode;

import java.util.Stack;

/*
* 中序遍历的非递归写法
* */
public class leetcode98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        double inorder=-Double.MAX_VALUE; //pervious node val，默认为最小值，最左节点的值大于inorder的初始值
        while (!stack.isEmpty()||root!=null){
            while (root!=null){ //左子树进栈
                stack.push(root);
                root=root.left;
            }
            root=stack.pop(); //向左走到尽头，出栈找到第一个需要处理的结点
            //当前节点的值小于前一个节点的值时，不是二叉搜索树
            if (root.val<=inorder) return false;
            inorder=root.val; //当前节点处理完，变成前一个节点

            root=root.right;
        }
        return true;
    }
}
