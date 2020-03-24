package leetcode.dp.treedp;

import leetcode.tree.TreeNode;

import java.util.HashMap;

public class leetcode337_打家劫舍III {
    /*
    * 递归解法
    *       爷爷
    *  左儿子      右儿子
     孙子 孙子 孙子  孙子
     * 一个节点对应两个儿子和四个孙子
     * 对应一个节点，所可能的值为 \sum 儿子、 爷爷+孙子
    * */
    public int robForRecursive(TreeNode root) {
        if (root==null) return 0;
        int money=root.val;
        if (root.left!=null){ //存在左儿子,则找左儿子的儿子
            money+=robForRecursive(root.left.left)+robForRecursive(root.left.right);
        }
        if (root.right!=null){ //存在右儿子,则找右儿子的儿子
            money+=robForRecursive(root.right.left)+robForRecursive(root.right.right);
        }
        return Math.max(money,robForRecursive(root.left)+robForRecursive(root.right));
    }
    /*
    * 记忆化-解决重复子问题
    * */
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money=root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        int result = Math.max(money, rob(root.left) + rob(root.right));
        memo.put(root,result);
        return result;
    }
}
