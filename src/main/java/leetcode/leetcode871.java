package leetcode;
/*
* 火车站加油
* 往后算，往前看
* */
public class leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target<=startFuel) return 0; //不需要加油，直接到
        long []dp=new long[stations.length+1]; //加上起点算一站,dp[i] 加i次油能走的最远距离
        dp[0]=startFuel; //起点，i=0加油次数为0
        for (int i = 0; i <stations.length; i++) {
            for (int j = i; j >=0; j--) {
                if (dp[j]>=stations[i][0]){ //stations[i][0]指的是起点到第i站的距离
                    //能到达i站的前提下，在i站加油后的最远能走的距离
                    dp[j+1]=Math.max(dp[j+1],dp[j]+stations[i][1]);
                }
            }
        }
        for (int i = 0; i <=stations.length ; i++) {
            if (dp[i]>target){
                return i;
            }
        }
        return -1;
    }
}
