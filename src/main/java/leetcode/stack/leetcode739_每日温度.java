package leetcode.stack;

import java.util.Stack;

/*
* 给定一个温度列表，得出以后某天的温度超出当天的温度的天数差
* 单调栈
* 此单调栈为什么需要逆转？
* */
public class leetcode739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int res[]=new int[T.length];
        Stack<Integer> stack=new Stack<>(); //incresed stack
        /*
        * reverse incresed stack
        * */
        for (int i = T.length-1; i>-1; --i) {
            /*
            * T[i]>=T[stack.peek()] 右侧出现不递增的情况，则把右侧清除直到满足单调栈的要求
            * */
            while (!stack.isEmpty()&&T[i]>=T[stack.peek()]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return res;
    }
}
