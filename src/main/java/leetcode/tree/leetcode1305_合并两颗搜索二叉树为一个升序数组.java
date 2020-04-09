package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class leetcode1305_合并两颗搜索二叉树为一个升序数组 {
    /*
     * 中序遍历+归并
     * */
    List<Integer> list=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        traversal(root1,list1);
        traversal(root2,list2);
        //合并数组
        int i=0;
        int j=0;
        while (i<list1.size() || j<list2.size()){
            if (i<list1.size() &&(j==list2.size()-1|| list1.get(i)<list2.get(j))){
                list.add(list1.get(i++));
            }else {
                list.add(list2.get(j++));
            }
        }
        return list;
    }
    private void traversal(TreeNode root,List<Integer> list){
        if (root!=null){
            traversal(root.left,list);
            list.add(root.val);
            traversal(root.right,list);
        }
    }
    /*
     * 合并两颗搜索二叉树 + 中序遍历
     * */
    private TreeNode merge(TreeNode r1, TreeNode r2) {
        if(r1 == null) return r2; //剩下一个或者都是null 时，返回即可
        if(r2 == null) return r1;
        if(r1.val < r2.val) {
            TreeNode r = r1.right;   //保留r1的右子树
            r1.right = null;         //断开r1的右子树
            r2.left = merge(r2.left, r1);
            return merge(r, r2); //r2 的左子树合并完成，接下来合并
        } else {
            TreeNode r = r2.right;
            r2.right = null;
            r1.left = merge(r1.left, r2);
            return merge(r, r1);
        }
    }
}
