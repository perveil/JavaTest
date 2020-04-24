package leetcode.tree.inorderTraverse;/*
  @Date:2020/4/24 10:31
  @Author:Administrator
*/

import leetcode.tree.TreeNode;

import java.util.*;

public class leetcode426_二叉树到双向链表的转化 {
    public TreeNode treeToList(TreeNode root){
        if(root==null) return null;
        TreeNode last=null;
        convert(root,last);
        while(root.left!=null)
            root=root.left;//寻找最左的头节点
        return root;
    }
    public void convert(TreeNode root,TreeNode last){
        if(root==null) return;
        convert(root.left,last);
        root.left=last;
        if(last!=null) last.right=root;
        last=root; //遍历结束后赋值向右侧遍历
        convert(root.right,last);
    }

}
