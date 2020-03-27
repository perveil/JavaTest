package leetcode.dp;

public class leetcode494_目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        /*
        * 数据最大和为1000，由于数组索引只能是正数，如何表示负数
        * 0-1000表示负数
        * 1000-2000 表示正数
        * */
        int[][] dp = new int[nums.length][2001]; //dp[i][j] 前i个数中和为j的方案数
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length; i++) { //遍历从1-nums.length-1 的数组元素
            for (int sum = -1000; sum <= 1000; sum++) { //-1000-1000 的遍历
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return dp[nums.length-1][S+1000];
    }
    /*
    * 转换成01背包的问题
    * 解释：https://leetcode-cn.com/problems/target-sum/solution/c-dfshe-01bei-bao-by-bao-bao-ke-guai-liao/
    * 01背包的含义为找到和为i的方案数
    * 转换思路：
    * 把整个集合看成两个子集 ，一个负数集合A（n），一个正数集合A（p）,整个数组和为Sum
    * A(p)-A(n)=T
    *A(p)+A(n)+A(p)-A(n)=T+A(p)+A(n)
    * 2A(p)=T+Sum
    * 所以问题转换为：找到一个正数集，其两倍等于T+Sum
    * */
    public int findTargetSumWays01DP(int[] nums, int S) {
        int sum=0;
        for (int i: nums) {
            sum+=i;
        }
        if ((S + sum) % 2 == 1 || S > sum) return 0;
        S = ((S + sum) / 2); //得出转换后的S，
        int []dp = new int[S + 1]; //dp[i] 指的是和为i的方案个数
        dp[0]=1; //和为0只有一种方案
        for (int i:
             nums) {
            for (int j=S;j>=i;j--){
                dp[j]+=dp[j-i];  //状态转移方程
            }
        }
        return dp[S];
    }
}
