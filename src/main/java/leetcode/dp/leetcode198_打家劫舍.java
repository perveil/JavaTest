package leetcode.dp;
/*
*  nums.length==1 f(1)=nums[0]
*  nums.length==2 f(2)=Math.max(nums[0],nums[1])
*  nums.length==3 f(3)=Math.max(f(0)+nums[2],f(1))
*
* 对每一个房子都只能是抢和不抢
* 不抢：f(n)=f(n-1)
*  抢：f(n)=f(n-2)+nums[n-1];
* */
public class leetcode198_打家劫舍 {
    public int rob(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];
        int a = nums[0], b = Math.max(nums[1], nums[0]);
        /*
        * a =dp[0],b=dp[1]
        * */
        for (int i = 2; i < nums.length; i++) {
            int tmp = b;
            b = Math.max(a + nums[i], b);
            /*
            * b =f(n-1)
            * a=f(n-2)
            * */
            a = tmp;
        }
        return b;

    }
}
