package leetcode.traceBack;

import  java.util.*;
public class leetcode52_N皇后的解 {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][]nums=new int[n][n];
        helper(n,0,nums);
        return res;
    }
    public void helper(int n,int cur,int [][] nums) {
        if(cur>=n){
            res.add(toString(nums));
            return;
        }
        for(int i=0;i<n;i++){
            nums[cur][i]=1;//设置值
            if(is(cur,i,nums)){
                helper(n,cur+1,nums);
            }
            nums[cur][i]=0;//回溯
        }
    }
    public boolean is(int x,int y,int [][]nums) {  //在i，j位置上放置的合理性
        for(int i=0;i<x;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }
    public List<String> toString(int [][]nums) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            StringBuilder temp=new StringBuilder();
            for (int j = 0; j <nums.length; j++) {
                if (nums[i][j]==1){
                    temp.append("Q");
                }else {
                    temp.append(".");
                }
            }
            list.add(temp.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        new leetcode52_N皇后的解().solveNQueens(4);
    }
}
