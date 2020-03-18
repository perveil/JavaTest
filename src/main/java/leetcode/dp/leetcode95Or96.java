package leetcode.dp;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
* 卡特兰数的计算方法
* */
public class leetcode95Or96 {
    /*
    * 96
    * */
    public int numTrees(int n) {
        int []G=new int[n+1];
        G[0]=1;
        G[1]=1;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    /*
    * 95
    * */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }
    /*
    * start-end 生成子树
    * */
    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<TreeNode>();  //存储所有可能子树的根节点
        if (start>end){
            all_trees.add(null);
            return all_trees;
        }
        for (int i=start;i<=end;i++){
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode current_tree = new TreeNode(i);
                    current_tree.left = l;
                    current_tree.right = r;
                    all_trees.add(current_tree); //以i节点为跟节点的所有可能的子树
                }
            }
        }
        return all_trees; //返回子树
    }


}
