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
    /*
    *  滑动窗口
    * */
    public int numberOfSubarrays2(int[] nums, int k) {
        int res=0;
        int l=0;
        int r=0;
        int cur=0;
        while(r<nums.length){
            if(nums[r++]%2==1){
                cur++;
            }
            //组合问题
            if (cur==k){
                int tmp=r;
                while (r<nums.length&&((nums[r]&1)==0)){
                    r++;
                }
                int rightCnt=r-tmp; //统计出现在第k个奇数的右边的，第k+1个奇数左边的偶数的个数
                int leftEvenCnt = 0; //统计第一个奇数左侧的偶数的个数
                while ((nums[l]%2)==0){
                    leftEvenCnt++;
                    l++;
                }
                res+=(leftEvenCnt+1)*(rightCnt+1);
                l++; //此时越过之前的第一个奇数
                cur--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new leetcode1248_统计优美子数组().numberOfSubarrays2(new int[]{
                2,2,2,1,2,2,1,2,2,2
        },2);
        /*
        * 0,0,0,1,0,0,1,0,0,0
        * */
    }
}
