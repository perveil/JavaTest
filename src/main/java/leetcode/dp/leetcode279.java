package leetcode.dp;

public class leetcode279 {
    public static void main(String[] args) {
        new leetcode279().numSquares(345);
    }
    public int numSquares(int n) {
        int nums[]=new int[(int) (Math.floor(Math.sqrt(n))+1)];
        for(int i=1;i<nums.length;i++){
            nums[i]=(i)*(i);     //初始化平方数组
        }
        int []dp =new int[n+1];  //1-n 的计数
        for (int i = 1; i < n+1; i++) {
            dp[i]=i;
        }
        for(int i=2;i<n+1;i++){
            for(int j=nums.length-1;j>-1;--j){
                if(i-nums[j]<0){
                    continue;
                }else{
                    dp[i]=Math.min(dp[i-nums[j]]+1,dp[i]);
                }
            }
        }
        return dp[n];
    }
}
