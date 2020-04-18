package leetcode;
/*
* 55 由左到右的试探能到达的最远距离，偏向到达而不是覆盖
* 45 偏向于覆盖，而不是到达
* */
public class leetcode55Or45_跳跃游戏 {
    public static boolean canJump(int[] nums) {
        int rch = 0; //起始最远到达数组的第一个元素得位置
        int n=nums.length;
        for(int i = 0; i <= rch; i ++)
        {
            rch = Math.max(rch, nums[i]+i); //rch 可以最远到达的位置
            //nums[i]+i 是在此处可以到达的最远的位置
            if(rch >= n-1) //当到达最远处时，直接返回
                return true;
        }
        return false;
    }
    //leetcode 45
    public static int Jump(int[] nums) {
        int ret = 0;
        int curMax = 0;
        int curRch = 0;
        int n=nums.length;
        for(int i = 0; i < n; i ++)
        {
            if(curRch < i)               //当curRch 到不了i时，此时跳跃
            {
                ret ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        return ret;
    }
}
