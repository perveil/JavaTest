package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* 单调队列，同单调栈
* */
public class leetcode239_双端队列解一维Maxpooling {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        * 双端队列，两端弹出/添加 时间复杂度为O(1)
        * */
        /*
        *   Last<===>First(max value of silde window)
        *
        * */
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index=0; //res 的index
        for (int i = 0; i <n ; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {  //此时滑动队列中最小值为nums[i-k],删除此时不在滑动窗口的元素
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) { //单调递减队列
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) { //目标数组length=n-k+1
                result[index++] = max.peekFirst();
            }

        }
        return result;
    }
}
