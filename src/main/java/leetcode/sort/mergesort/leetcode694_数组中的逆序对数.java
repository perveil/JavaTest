package leetcode.sort.mergesort;
/*
  @Date:2020/4/24 9:50
  @Author:Administrator
*/

import java.util.*;

public class leetcode694_数组中的逆序对数 {
    public int reversePairs(int[] nums) {
        int len=nums.length;
        if(len<2){
            return 0;
        }
        int []temp=new int[len]; //排序合并数组
        return reversePairs(nums, 0, len - 1, temp);
    }
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if(left==right){
            return  0;
        }
        int mid=(left+right)>>1;
        int leftPairs=reversePairs(nums,left,mid,temp);
        int rightPairs=reversePairs(nums,mid+1,right,temp);
        int reversePairs=leftPairs+rightPairs;
        if (nums[mid] <= nums[mid + 1]) {  //左侧最大小于等于右侧最小，两侧有序则没有CrossParis
            return reversePairs;
        }
        int reverseCrossPairs = mergeAndCount(nums, left, mid, right, temp); //两侧逆序对数
        return reversePairs + reverseCrossPairs;
    }
    /*
    *  归并排序的合并函数
    *  [left,mid] [mid+1,right] 此时都是有序数组
    *  合并过程中计算逆序对数
    * */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i=left; //左侧左边界
        int j=mid+1; //右侧左边界
        int res=0; // CorssReversePairs个数
        for (int k = left; k <= right; k++) {
            if(i>mid){
                nums[k]=temp[j]; //左侧先遍历完,复制右侧元素,此时右侧剩余的数字都大于之前已经排序完成的数字
                j++;
            }else if (j>right){
                nums[k]=temp[i]; //右侧先遍历完,复制左侧元素，此时左侧剩余数字都大于右侧数组的所有数字
                i++;
                res+=right-mid;
            }else if (temp[i]<temp[j]){
                nums[k]=temp[i];
                i++;
            }else { // temp[i]>=temp[j]
                nums[k]=temp[j];
                j++;
                res+=(j-mid-1); //此时未遍历左侧数数字均大于右侧遍历数字
            }
        }
        return res;
    }
}
