package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
*          3(0,0)
*  9(-1,1)         20(1,1)
*          15(0,2)       7(2,2)
*
* 首先中序遍历获得所有节点的坐标，再根据坐标的x排序
* */
public class leetcode987_垂序遍历 {
    List<List<Integer>> res=new ArrayList<>();
    List<Position> positions=new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root==null) return res;
        traversal(0,0,root);
        Collections.sort(positions);
        int x=Integer.MIN_VALUE;
        res.add(new ArrayList<>());
        int prev=positions.get(0).xposition;
        for (Position p:
             positions) {
            if (p.xposition!=prev){
                prev=p.xposition;
                res.add(new ArrayList<>());
            }
            res.get(res.size()).add(p.node.val); //垂序遍历
        }
        return res;

    }
    private void traversal(int x,int y,TreeNode root){
        if (root!=null){
            positions.add(new Position(root,x,y));
            traversal(x-1,y+1,root.left);
            traversal(x+1,y+1,root.right);
        }
    }
    static class Position implements Comparable<Position>{
        TreeNode node;
        int xposition;
        int yposition;
        Position(TreeNode node,int xpostion,int yposition){
            this.node=node;
            this.xposition=xpostion;
            this.yposition=yposition;
        }
        @Override
        public int compareTo(Position o) {
            if (this.xposition != o.xposition)
                return Integer.compare(this.xposition, o.xposition);
            else if (this.yposition != o.yposition)
                return Integer.compare(this.yposition, o.yposition);
            else return Integer.compare(this.node.val,o.node.val); //坐标相等时则节点相等
        }
    }
}
