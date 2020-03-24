package leetcode.dp;

import java.util.Arrays;

/*
* 要求第0家和第n-1家永远也不能同时被偷
* 所以 0->n-2 一次leetcode 198
*     1->n-1 第二次 leetcode198
* */
public class leetcode213_打家劫舍II {
    //环
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(
                robhelper(Arrays.copyOfRange(nums,0,nums.length-1)),
                robhelper(Arrays.copyOfRange(nums,1,nums.length))
        );
    }
    /*
    * 单链表
    * */
    public int robhelper(int[] nums) {
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
