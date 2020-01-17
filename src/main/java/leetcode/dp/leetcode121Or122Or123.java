package leetcode.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
*
* */
public class leetcode121Or122Or123 {
    /*
       leetcode122/123 peek-vellay法
    * */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])  //寻找valley
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])  //寻找peek
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        List<Integer> list=new ArrayList<>();
        return maxprofit;
    }
    /*
    *  动态规划
    * */
    public int maxProfit_dp(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];  //二维数组，0/1 表示购入或者售出
        //dp[i][0]  第i天持有cash
        //dp[i][1]  第i天持有stock
        dp[0][0]=0;
        dp[0][1]=-prices[0];  //第一天售出、购入
        for (int i = 1; i <len; i++) {
            //第i天要不持有cash(第i天不卖)、要不卖掉，要想卖掉前一天肯定持有的是stock
            dp[i][0]=Math.max(dp[i-1][0],dp[i - 1][1] + prices[i]);
            //第i天要不持有stock(第i天买)要想买，前一天肯定持有的是cash，要不就不买
            dp[i][1]=Math.max(dp[i-1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[len-1][0]; //最后一天持有cash

    }

}
