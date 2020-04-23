package leetcode.bfs;/*
  @Date:2020/4/17 17:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode1377_青蛙跳跳跳 {
    //无向树解法
    double []res=new double[101]; //表示跳到某一节点的概率,最大只有100个数据点
    boolean marked[]=new boolean[101];
    HashMap<Integer,List<Integer>> map=new HashMap<>(); //无向图的邻接矩阵
    public double frogPosition(int n, int[][] edges, int t, int target) {
        res[0]=1.0;
        marked[0]=true;
        for (int [] e:
             edges) {
            if (!map.containsKey(e[0])){
                map.put(e[0],new ArrayList<>());
            }
            if (!map.containsKey(e[1])){
                map.put(e[1],new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        dfs(1,t);
        return res[target];
    }
    void dfs(int cur,int t){
        if (t<=0) return; //时间到了就退出
        int to_count=0; //从cur 所在的位置所能到达的位置数
        for (Integer i:
             map.get(cur)) {
            if (!marked[i]) to_count++;
        }
        if (to_count==0) return; //没有地方可以去
        double p=res[cur]/to_count; //往后跳的选择是等概率的
        for (Integer i: map.get(cur)) {
            if (!marked[i]){
                marked[i]=true;
                //res[cur] -= p;
                res[i]+=p;     //跳向新节点的概率，在跳向之前的概率都是0
                dfs(i,t-1); //向下跳
                marked[i]=false; //回溯
            }
        }
    }

    public static void main(String[] args) {
        new leetcode1377_青蛙跳跳跳().frogPosition(7,new int[][]{
                new int[]{1,2},
                new int[]{1,3},
                new int[]{1,7},
                new int[]{2,4},
                new int[]{2,6},
                new int[]{3,5},
        },20,6);
    }
}

