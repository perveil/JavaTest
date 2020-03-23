package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
* 柱状图最大的矩形
* 找到heights[i] 左边、右边第一个小于heights[i]的索引leftindex、rightindex， 面积=（rightindex-leftindex）*heights[i]
* */
public class leetcode84_柱状图最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        for(int i=0;i<new_heights.length;i++){
            /*
            * new_heights[stack.peek()]>new_heights[i]  此时违反单调递增栈规则。也就是说，遇到了右边比new_heights[stack.peek()]小的节点
            * 然后 new_heights[stack.peek()-1] 是左边小于new_heights[stack.peek()]的值
            * */
            while(!stack.isEmpty()&&new_heights[stack.peek()]>new_heights[i]){
                int cur=stack.pop();    //弹出当前节点
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
                //stack.peek()为左侧小于new_heights[cur]的第一个数的索引
                //new_heights[i] 为右侧小于new_heights[cur]的第一个数
            }
            stack.push(i);
        }
        return res;
    }
}