package leetcode.dp.dp01;

import java.util.Arrays;

public class leetcode416_分割等和子集 {
    /*
    * 排序后求解，只考虑了数组前向加和 与 后向加和的求法
    * 求解失败
    * */
    public boolean FalsecanPartition(int[] nums) {
        Arrays.sort(nums);
        int beginSum=nums[0];  //从前往后的累加
        int endSum=nums[nums.length-1];    //从后往前的累加
        for (int i = 0,j=nums.length-1; i <j ;) {
            if (beginSum>endSum){
                j--;
                endSum+=nums[j];
            }else if (beginSum<endSum){
                i++;
                beginSum+=nums[i];
            }else if (beginSum==endSum&&i!=j-1){
                i++;
                j--;
                endSum+=nums[j];
                beginSum+=nums[i];
            }
            if (beginSum==endSum&&i==j-1){
                return true;
            }
        }
        return false;
    }
    /*
    * 题目可以转换成，是否可以找到m个数，m个数的和是总的和的一半
    * 所以 数组的和一定得是偶数，即数组的和一定是得被2整除
    *转换成01背包的问题，设总和sum的一半是aim，则find n numbers whose sum is aim；
    * */
    public boolean canPartition(int[] nums) {
        int len=nums.length;
        if (len==0){ return false; }
        int sum=0;
        for (int num: nums) {
            sum+=num;
        }
        if (sum%2==1) return false;
        int target=sum/2;
        boolean [][] dp=new boolean[nums.length][target+1]; //dp[i][j] 表示前i个数是否可能的和为j
        //初始化
        //i=0 时表示只有第一个数，其和只能是nums[0],但是如果nums[0]>target 时，则说明当前数的和不可能是target
        if (nums[0]<target){
            dp[0][nums[0]]=true;
        }
        dp[0][0]=true;
        for (int i = 1; i <nums.length ; i++) { //物品行
            for (int j = 0; j <target+1 ; j++) { //nums 只包含正整数，所以target=0不存在
                dp[i][j]=dp[i-1][j]||nums[i]==j||(j>nums[i]&&dp[i - 1][j - nums[i]]);
                /*
                * dp[i-1][j]==true 时 dp[i][j]一定为true，代表着不要nums[i] 就可以和为j
                * nums[i]==j       时，代表着j只要nums[i] 就可以
                * dp[i - 1][j - nums[i]]==true 时，代表着，前i-1 个数的和可以是j - nums[i]，再加上nums[i] 则刚好等于j
                * */
                if (dp[i][target]){ //提前结束，简直操作
                    return true;
                }
            }
        }
        return dp[nums.length-1][target];

    }


}
