package leetcode;



import java.util.*;

public class leetcode503 {
    public static void main(String[] args) {
        new leetcode503().nextGreaterElements(
                new int[]{
                        1,2,1
                }
        );

    }

    //贪心法相对简单
    public int[] nextGreaterElements(int[] nums) {
        int res[]=new int[nums.length];
        Arrays.fill(res,-1);
        for (int i = 0; i <nums.length ; i++) {
            for (int j=i;j<nums.length;j++){
                if (nums[i]<nums[j]){
                    res[i]=nums[j];
                    break;
                }
                if (j==nums.length-1){
                    for (int k = 0; k <i ; k++) {
                        if (nums[i]<nums[k]){
                            res[i]=nums[k];
                            break;
                        }
                        if (k==i-1){
                            res[i]=-1;
                        }
                    }
                }
            }
        }
        return res;
    }
    //单调栈
    public int[] SnextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int len  = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * len; i++) {
            int num = nums[(i+len) % len]; //关键步骤
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            // use for second round
            if (i < len) stack.push(i);
            if (stack.isEmpty()) break;
        }

        return res;
    }
}
