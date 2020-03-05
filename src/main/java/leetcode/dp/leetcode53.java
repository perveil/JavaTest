package leetcode.dp;

public class leetcode53 {
    public int maxSubArray(int[] nums) {
        int []dp=new int[nums.length]; //dp[i] 指的是以dp[i]为末尾的连续子串的最大和
        int res=nums[0];
        dp[0]=nums[0];
        for (int i = 1; i <nums.length; i++) {
            if (dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];//dp[i-1] 为nums[i] 产生了正数增益
            }else{
                dp[i]=nums[i];
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode53().maxSubArray(new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        });
    }
}
