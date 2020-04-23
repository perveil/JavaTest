package leetcode.dp;/*
  @Date:2020/4/23 9:02
  @Author:Administrator
*/

import java.util.*;

/*
*  完全背包问题
*
* */
public class interview0811_硬币 {
    public int waysToChange(int n) {
        int[] dp=new int[n+1]; //dp[i] 表示
        int [] coins=new int[]{25,10,5,1};
        dp[0]=1;//初始化dp
        for(int j=0;j<4;j++){ //状态压缩
            for(int i=coins[j];i<=n;i++){ //完全背包
                dp[i]=(dp[i]+dp[i-coins[j]])%1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new interview0811_硬币().waysToChange(10);
    }
}
