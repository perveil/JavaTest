package leetcode.stack;

import java.util.Map;
import java.util.Stack;

/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* 思路一： 效率上不去，超出时间限制 是因为++ 的计算方法多次遍历整个数组，就会使得n*n 得时间复杂度
* 思路二： 找到最高的，然后向两边遍历，遍历左右两边，就计算能呈多少水，然后继续改变最高点
* */
public class leetcode42_接雨水 {
    public static void main(String[] args) {
      int [] height={4,3,1,0,1,2,4};
      new leetcode42_接雨水().trap(height);
    }
    /*
    * 暴力解法， 层层递增
    * */
    public static void mostWater(int[] height){
        boolean flag=true;
        int result=0;
        int startIndex=-1;
        int endIndex=-1;
        while(flag){
            for (int i = 0; i <height.length ; i++) {
                if (height[i]>0&&startIndex==-1&&endIndex==-1) {
                    startIndex = i;
                }
                if (height[i]>0&&startIndex!=-1){
                    endIndex=i;
                    if (endIndex-startIndex>0){
                        result+=(endIndex-startIndex-1);
                    }
                    startIndex=endIndex;
                    endIndex=-1;
                }
            }
            for (int i = 0; i <height.length ; i++) {
                if (height[i]-1>=0){
                     height[i]=height[i]-1;
                }else {
                    height[i]=0;
                }
            }
            if (isEmpty(height)){
                continue;
            }else {
                break;
            }
        }
    }
    public static boolean  isEmpty(int[] height){
        int num=0;
        for (int i = 0; i <height.length ; i++) {
            if (height[i]>0){
                num++;
            }
        }
        return num<=1?false:true;
    }

    /*
    * 单调栈解法
    *
    * */
    public int trap(int[] height) {
        if (height==null) return 0;
        int res=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<height.length;i++){
            /*
            * 单调递减栈
            * */
            while (!stack.isEmpty()&&height[stack.peek()]<height[i]){
                int curIdx = stack.pop();  //当前槽位的底部
                //如果栈顶元素一直相等，那么全都pop出去，只留第一个
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) { //槽位底部合并
                    stack.pop();
                }
                if (!stack.isEmpty()){ //此时不为空
                    int stackTop=stack.peek(); //stackTop 的位置在左侧的较高高度上
                    res+=(Math.min(height[stackTop],height[i])-height[curIdx])*(i - stackTop - 1);
                    /*
                    * (Math.min(height[stackTop],height[i])-height[curIdx]) 高度
                    * i - stackTop - 1  宽度
                    * */
                }
            }
            stack.add(i); //入栈
        }
        return res;
    }

}
