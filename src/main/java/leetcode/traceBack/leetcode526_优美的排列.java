package leetcode.traceBack;/*
  @Date:2020/4/22 9:51
  @Author:Administrator
*/

import java.util.*;

public class leetcode526_优美的排列 {
    int res=0;
    boolean[] marked;
    public int countArrangement(int N) {
        marked=new boolean[N+1];
        helper(1,N);
        return  res;
    }
    public void helper(int cur,int N) {
        if (cur>N){
            res++;
        }
        for (int i = 1; i <=N; i++) {
            if (!marked[i] &&(cur%i==0 || i%cur==0)){
                marked[i]=true;
                helper(cur+1,N);
                marked[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        new leetcode526_优美的排列().countArrangement(15);
    }
}
