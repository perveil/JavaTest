package leetcode.stack;/*
  @Date:2020/4/25 21:53
  @Author:Administrator
*/

import java.util.*;

public class leetcode907_子数组的最小值之和 {
    //单调递增栈
    public int sumSubarrayMins(int[] A) {
        long mod=1000000007;
        Stack<Integer> stack=new Stack<>();
        int cur_sum=0,res=0;
        for (int i = 0; i <A.length ; i++) {
            //单调递增栈，遇见了较小值，计算以此较小值为最小值的数组个数*较小值
            while (!stack.isEmpty() &&(A[stack.peek()]>=A[i])){
                int top=stack.pop();
                int new_top=stack.isEmpty()?-1:stack.peek();
                cur_sum+=(A[i]-A[top])*(top-new_top);
            }
            res+=cur_sum;
            res%=mod;
        }
        return res;
    }
}
