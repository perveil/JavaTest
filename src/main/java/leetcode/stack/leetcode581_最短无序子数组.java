package leetcode.stack;

import java.util.Stack;
/*
* 单调栈解法
* */
public class leetcode581_最短无序子数组 {
    public int findUnsortedSubarray(int[] nums) {
        Stack< Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        //升序单调栈
        for (int i = 0; i <nums.length ; i++) {
            /*
            * 正向遍历的过程中，一旦遇见stack内元素比即将遍历的元素nums[i]大时，
            * 则说明nums[i] 不在该在的地方，则寻找其该在的地方，则pop比其大的
            * */
            while(!stack.isEmpty()&&nums[stack.peek()]>nums[i]){
                l=Math.min(l,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        //逆序单调栈
        for (int i = nums.length-1; i >=0 ; i--) {
            /*
             * 逆向遍历的过程中，一旦遇见stack内元素比即将遍历的元素nums[i]小时，
             * 则说明nums[i] 不在该在的地方，则寻找其该在的地方，则pop比其小的
             * */
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                r=Math.max(r,stack.pop());
            }
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) {
        new leetcode581_最短无序子数组().findUnsortedSubarray(new int[]{
                2, 6, 4, 8, 10, 9, 15
        });
    }
}
