package leetcode.dp;
/*
*  思路ji
*
* */
public class leetcode673 {
    public static void main(String[] args) {

        System.out.println(
                new leetcode673().findNumberOfLIS(new int[]{
                        2,2,2,2,2
                })

        );
    }
    public int findNumberOfLIS(int[] nums) {
        int max_length=1;
        int dp[]=new int[nums.length];// 记录以dp[i] 为末尾能构成得最长序列得长度
        int ans[] =new int[nums.length]; // 记录最长序列的个数，涉及状态转换
        for (int i = 0; i <nums.length; i++) {
            dp[i]=1;
            ans[i]=1;
        }
        for (int i = 1; i <nums.length ; i++) {
            for (int j = i-1; j >=0 ; j--) {
              if (nums[j]<nums[i]&&dp[i]<dp[j]+1){ //
                  dp[i]=dp[j]+1; //更新dp所对应的字符串的最长长度
                  ans[i]=ans[j]; //状态转换
              }else if (nums[j] < nums[i]&&dp[i]==dp[j]+1){
                  ans[i]+=ans[j]; //状态转换
              }
            }
            max_length=Math.max(max_length,dp[i]);
        }

        int result=0;
        for (int i = 0; i <dp.length ; i++) {
            if (dp[i]==max_length) result+=ans[i];
        }
        return result;
    }
}
