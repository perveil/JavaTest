package leetcode.sildeWindow;

import java.util.HashMap;

public class leetcode560_和为k的连续子数组的个数 {
    /*
    * 滑动窗口 可以解决k！=0 的情况
    * 滑动窗口有一个最重要的使用前提：
    *    对于一个固定的左端点，满足条件的右端点集合是连续并且递增的
    * 不满足递增的条件，不能使用滑动窗口
    * */
    public int subarraySumOfsildeWindow(int[] nums, int k) {
        int l=0,r=0;
        int res=0;
        int cur_sum=0;
        while(r<nums.length){
            if (cur_sum<=k){
                cur_sum+=nums[r];
            }
            while (l<=r&&cur_sum>=k){
                cur_sum-=nums[l];
                l++;
                if (cur_sum==k) res++;
            }
            r++;
        }
        return res;
    }
    /*
       sum[i] 表示从0到i的元素的总和
    * 累计总和，如果sum[i]-sum[j]=k 则说明从i-j之间的元素之和为k
    * map 记录sum[i]与sum[i]个数的映射
     sum[j]-k 在map中时 设为 sum[i] sum[i]-sum[j]=k
      count+=map.get(sum-k);
    * */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0,1);
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;

    }

    public static void main(String[] args) {
        new leetcode560_和为k的连续子数组的个数().subarraySum(new int[]{
                1,0,0,1,0
        },0);
    }
}
