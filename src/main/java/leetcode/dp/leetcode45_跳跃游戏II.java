package leetcode.dp;/*
  @Date:2020/4/17 10:02
  @Author:Administrator
*/

import java.util.*;

public class leetcode45_跳跃游戏II {
    //最简单的dp  超时
    public int jump(int[] nums) {
        int dp[]=new int[nums.length]; //dp[i] 表示到达i的位置最少的跳跃数
        dp[0]=0;
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=nums.length; //初始化最大值
            for (int j = i-1; j >-1; j--) {
                if (j+nums[j]>=i){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        new leetcode45_跳跃游戏II().jump(new int[]{
                1,1,1,1,1
        });
    }
}
