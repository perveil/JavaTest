package leetcode;

import java.util.Arrays;
/*
*  第一次尝试失败：主要是为了 追求 O(n)
*   简单的方法比如:排序，中位数之前的和中位数之后的
* */
public class leetcode362 {
    public static void main(String[] args) {
        new Solution362().wiggleSort(new int[]{
                1,2,2,1,2,1,1,1,2,2,1,2,1,2,1,1,2
        });
    }
}
 class Solution362 {
    public void wiggleSort(int[] nums) {
        int[] sort = nums.clone();
        Arrays.sort(sort);
        for(int i=(sort.length-1)/2, j=0; i>=0; i--, j+=2) nums[j]=sort[i];
        for(int i=sort.length-1, j=1; i>(sort.length-1)/2; i--, j+=2) nums[j]=sort[i];
    }
}