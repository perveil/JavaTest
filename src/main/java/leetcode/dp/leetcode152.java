package leetcode.dp;
/*
*    在维护一个最大值的前提下，也要维护一个最小值，因为负数乘以一个负数也会变成一个较大正数
*    第一次尝试错在没有维护一个最小值，而是只看最大值导致出错
* */
public class leetcode152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int maxPro= nums[0];
            int minPro = nums[0];
            int res = nums[0];
            int n = nums.length;
            for(int i = 1 ;i < n; i++){
                int t1 = maxPro*nums[i];
                int t2 = minPro*nums[i];
                //找到最大和最小
                maxPro = Math.max(Math.max(t1,t2),nums[i]);
                minPro = Math.min(Math.min(t1,t2),nums[i]);
                res = Math.max(maxPro,res);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        new leetcode152().new Solution().maxProduct(
                new int[]{
                        2,-5,-2,-4,3
                }
        );
        int n=5;
        System.out.println(n^(n>>1));
    }
}
