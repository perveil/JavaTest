package leetcode.binarySearch;/*
  @Date:2020/4/22 18:50
  @Author:Administrator
*/

import java.util.*;

public class leetcode1300_转变数组后最接近目标值的数据和 {

    public int findBestValue(int[] arr, int target) {
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            max=Math.max(max,arr[i]);
        }
        int left=0;
        int right=max+1;
        while(left<right){ //当 left==right 跳出循环  [left,right) ->[left,mid) [mid+1,right)
            int mid=(left+right)>>1;
            int sum =sum(arr,mid);
            //计算第一个大于等于target 的value
            if (sum<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        int sum1=sum(arr,left);
        int sum2=sum(arr,left-1);
        if (target - sum1 <= sum2 - target) {
            return left - 1;
        }
        return left;
    }

    public int sum(int[] arr, int mid) {
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=Math.min(mid,arr[i]);
        }
        return sum;
    }
}
