package leetcode.bfs;/*
  @Date:2020/4/17 17:57
  @Author:Administrator
*/

import java.util.*;

public class leetcode1377_青蛙跳跳跳 {
    //有向树解法
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer> levelList=new ArrayList<>();
        Queue<Integer> q=new ArrayDeque<>();
        boolean [] marked=new boolean[n+1];
        q.add(1); //1进队
        marked[1]=true;
        boolean is=false;
        int parent=-1;
        boolean isHaveBack=false;
        while(!q.isEmpty()&&!is){
            int size=q.size();
            levelList.add(size);
            for (int i = 0; i <size&&!is ; i++) {
                int temp=q.poll();
                for (int j[]:edges) {
                    if (j[0]==temp&&!marked[j[1]]){
                        q.add(j[1]);
                        parent=temp;
                        if (j[1]==target){
                            for (int k[]:edges) {
                                if (k[0]==target && !marked[k[1]]){
                                    isHaveBack=true;
                                }
                            }
                            is=true;
                            break;
                        }
                    }
                }
            }

        }
        int parentsc=0;
        for (int k[]:edges) { //看看目标的父亲节点的子节点个数
            if (k[0]==parent){
                parentsc++;
            }
        }
        if (t==levelList.size() || (t>levelList.size()&&!isHaveBack)){
            double res=1;
            for (Integer i:
                 levelList) {
                res*=1.0/i;
            }
            return res*(1.0/parentsc);
        }

        return 0.0;

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

