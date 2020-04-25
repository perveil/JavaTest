package leetcode.tree.inorderTraverse;
/*
  @Date:2020/4/25 9:16
  @Author:Administrator
*/

import java.util.*;
import leetcode.tree.*;
/*
* 中序遍历之后的二叉树是有序的，交换完结点的二叉树有两个逆序对
* 1 2 3 4 5  -》1 4 3 2 5  =》第一个逆序对（4,3） 第二个逆序对 (3,2)
*morris 遍历-> 非递归的中序遍历
* */
public class leetcode99_恢复二叉树 {
    /*
    * 递归解法
    * */
    TreeNode first=null; //第一个错序结点
    TreeNode second=null; //第二个错序结点
    TreeNode pre=null; //当前遍历指针的前序结点
    public void recoverTree(TreeNode root) {
        if (root==null) return;
        travel(root);
        //交换结点值
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }
    /*
    * 递归的中序遍历，寻找逆序对数
    * */
    public void travel(TreeNode root) {
        if (root==null) return;
        travel(root.left);
        if (pre!=null &&(root.val<pre.val)){ //查找到了逆序对
            if (first==null) first=pre;
            second=root; //交换结点可能是相邻的两个结点
        }
        pre=root; // 遍历结束，pre指向当前结点
        travel(root.right);
    }

    /*
    * 非递归解法
    * */
    public void recoverTree2(TreeNode root) {
        if (root==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root; //工作指针
        while(p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            if (pre!=null &&(p.val<pre.val)){ //查找到了逆序对
                if (first==null) first=pre;
                second=p; //交换结点可能是相邻的两个结点
            }
            pre=p; //处理完毕
            p=p.right; //向左侧遍历
        }
        int temp=first.val;
        first.val=second.val;
        second.val=temp;
    }

}
