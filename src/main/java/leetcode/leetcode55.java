package leetcode;
/*
* 55 由左到右的试探能到达的最远距离，偏向到达而不是覆盖
* 45 偏向于覆盖，而不是到达
* */
public class leetcode55 {

    public static void main(String[] args) {

        System.out.println(
            canJump(new int[]{
                    1,1,1,0
            })
        );
        Jump(new int[]{
                2,3,1,1,4
        });
    }
    public static boolean canJump(int[] nums) {
        int rch = 0;
        int n=nums.length;
        for(int i = 0; i <= rch; i ++)
        {
            rch = Math.max(rch, nums[i]+i);
            if(rch >= n-1)
                return true;
        }
        return false;
    }
    public static int Jump(int[] nums) {
        int ret = 0;
        int curMax = 0;
        int curRch = 0;
        int n=nums.length;
        for(int i = 0; i < n; i ++)
        {
            if(curRch < i)
            {
                ret ++;
                curRch = curMax;
            }
            curMax = Math.max(curMax, nums[i]+i);
        }
        return ret;
    }
}
