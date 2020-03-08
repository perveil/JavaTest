package leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        int dp[]=new int[amount+1];
        int max = amount + 1;
        Arrays.sort(coins);
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i=1;i<=amount;i++){
            for (int j = 0; j <coins.length; j++) {
                if (i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new leetcode322().coinChange(new int[]{
                1, 2, 5
        },11);
    }
}
