package leetcode.sildeWindow;
/*
  @Date:2020/4/21 9:08
  @Author:Administrator
*/

import java.util.*;

public class leetcode1248_统计优美子数组 {
    public int numberOfSubarrays(int[] nums, int k) {
        //奇数为1，偶数为0
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]%2==0){
                nums[i]=0;
            }else {
                nums[i]=1;
            }
        }
        return subarraySum(nums,k); //问题转换成了求子数组和为k的个数
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0,1); //初始化 0 有一个
        for (int i = 0; i <nums.length ; i++) {
            sum+=nums[i];
            if (map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
