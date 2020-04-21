package leetcode.sildeWindow;/*
  @Date:2020/4/20 16:40
  @Author:Administrator
*/

import java.util.*;

public class leetcode209_长度最小的子数组 {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0||(nums.length==1 &&nums[0]!=s)) return 0;
        int left=0;
        int right=0;
        int minLen=Integer.MAX_VALUE;
        int cur=0;
        while (right<nums.length){
            if (cur<=s){
                cur+=nums[right];
            }
            while(cur>=s){
                minLen=Math.min(minLen,right-left+1);  //***
                cur-=nums[left];
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0: minLen;
    }

    public static void main(String[] args) {
        new leetcode209_长度最小的子数组().minSubArrayLen(11,new int[]{
                1,2,3,4,5
        });
    }
}
