package leetcode.tree;/*
  @Date:2020/4/22 9:22
  @Author:Administrator
*/

import java.util.*;

public class leetcode545_二叉树的边界 {
    /*
    *   依次寻找左边界、右边界和叶子节点
    *
    * */
    List<Integer> res =new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root==null) return res;
        res.add(root.val);
        getLeftPath(root.left);  //得到左侧边界
        getrightPath(root.right); //得到右侧边界
        return res;
    }
    public void getLeftPath(TreeNode root){
        if (root!=null){
            res.add(root.val);
            if (root.left!=null){
                getLeftPath(root.left);//能向左则一直向左走
                getleave(root.right); //但是不能忘记右侧的叶子节点,左侧边界在叶子节点的左侧
            }else {
                //向左走走不了之后向右走
                getLeftPath(root.right);
            }
        }
    }
    public void getrightPath(TreeNode root){
        if (root!=null){
            if (root.right!=null){
                getleave(root.left); //叶子节点在右侧边界的左侧
                getrightPath(root.right);
            }else {
                getrightPath(root.left);
            }
            res.add(root.val);  //保证顺序
        }
    }
    // 得到所有的叶子节点
    public void getleave(TreeNode root){
        if (root==null) return;
        if (root.right==null&&root.left==null){
            res.add(root.val);
            return;
        }
        getleave(root.left);
        getleave(root.right);
    }



}
