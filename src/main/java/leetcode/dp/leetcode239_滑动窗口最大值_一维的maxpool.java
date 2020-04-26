package leetcode.dp;

public class leetcode239_滑动窗口最大值_一维的maxpool {
    /*
    * 顺时针划分块
    *  0 1 2  3 4 5  6 7
    *       |      |
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if (n * k == 0) return new int[0];
        //if (k == 1) return nums;
        int [] res=new int[n-k+1];
        /*
        * left[i]=Max(nums[block_start]->nums[i])
        * right[j]=Max(nums[j]<-nums[block_end])
        * */
        int left[]=new int[n];
        int right[]=new int[n];
        left[0]=nums[0];
        right[n-1]=nums[n-1];
        for (int i = 1; i <n ; i++) {
            /*
            * 0 1 2 3 4 5 6 7
            *      | | | | | |
            * */
            if ( i % k == 0) left[i] = nums[i]; //左侧block 的起始位置
            else left[i]=Math.max(left[i-1],nums[i]);
            /*
            *   0 1 2 3 4 5 6 7
               | | | | | |
            *
            * */
            int j=n-i-1; //从右到左，j与i的对应位置
            if ((j+1)%k==0) right[j]=nums[j];
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        for (int i = 0; i < n - k + 1; i++)
            res[i] = Math.max(left[i + k - 1], right[i]);
        return res;
    }

    public static void main(String[] args) {
        new leetcode239_滑动窗口最大值_一维的maxpool().maxSlidingWindow(new int[]{
                1,3,-1,-3,5,3,6,7
        },1);
    }
}
