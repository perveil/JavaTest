package leetcode.tree.perorderTraverse;

import dataStructrue.tree.CreateTree;
import leetcode.tree.TreeNode;
import java.util.*;
/*
* 回溯
* */
public class leetcode113 {
    List<List<Integer>> paths= new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> queue=new LinkedList<>();
        helper(root,sum,queue);
        return paths;
    }
    public void helper(TreeNode root, int cur,LinkedList<Integer> queue) {
        if (root==null) return;
        if (root.left==null
                &&root.right==null
                &&cur==0){
            paths.add(new ArrayList<>(queue)); //拷贝
            return;
        }
        queue.addLast(root.val);
        helper(root.left,cur-root.val,queue);
        helper(root.right,cur-root.val,queue);
        queue.removeLast(); //回溯
    }
}
