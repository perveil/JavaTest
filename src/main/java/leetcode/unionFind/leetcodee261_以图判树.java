package leetcode.unionFind;/*
  @Date:2020/4/20 10:22
  @Author:Administrator
*/

import java.util.*;
/*
* 给定一个无向图，判断此树是否是一棵树
* 假定不存在[1,0],[0,1] 这种的两条边存在
* 树的要求：
*   1.无环  ：一条边两端的节点的祖先节点的不能是相同的
*   2.所有节点连接在一起： edges的个数==节点的个数-1
*
* */
public class leetcodee261_以图判树 {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int i = 0; i < edges.length; i++) {
            int x = findRoot(roots, edges[i][0]);
            int y = findRoot(roots, edges[i][1]);
            if (x == y) return false;
            roots[x] = y; // 合并
        }
        return true;
    }
    int findRoot(int []roots,int id){
        return (id==roots[id])?id:findRoot(roots,roots[id]);
    }
}
