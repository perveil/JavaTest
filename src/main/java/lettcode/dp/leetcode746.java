package lettcode.dp;

public class leetcode746 {
    public static void main(String[] args) {

        System.out.println(
           new leetcode746().minCostClimbingStairs(
                   new int[]{0,1,1,1}
           )
        );
    }
    public int minCostClimbingStairs(int[] cost) {
        //此题可以转换为起始在索引为-1的位置，然后走一步或者走两步的动态选择问题
        int result=0;
        int dp[]=new int[cost.length+1];
        int i;
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        if (i==cost.length-1)
            return dp[cost.length-1]+1;
        else
            return dp[cost.length-1];

    }
}
