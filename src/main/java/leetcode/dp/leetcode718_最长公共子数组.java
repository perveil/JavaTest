package leetcode.dp;/*
  @Date:2020/4/20 16:38
  @Author:Administrator
*/

import java.util.*;

public class leetcode718_最长公共子数组 {
    //子数组
    public int findLength(int[] A, int[] B) {
        int ans=0;
        int [][]dp=new int[A.length+1][B.length+1]; //dp[i][j] 表示为以A[i]、B[j] 为末尾元素的最常公共子数组，连续的
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B.length;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }

    /*
        子序列:不连续
        int ans=0;
        int [][]dp=new int[A.length+1][B.length+1];
        for(int i=1;i<=A.length;i++){
           for(int j=1;j<=B.length;j++){
               if(A[i-1]==B[j-1]){
                   dp[i][j]=dp[i-1][j-1]+1;
               }else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }
               ans=Math.max(ans,dp[i][j]);
          }
        }
        return ans;


    */
}
