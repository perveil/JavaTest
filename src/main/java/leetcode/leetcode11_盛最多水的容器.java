package leetcode;
/*
  @Date:2020/4/18 9:18
  @Author:Administrator
*/

import java.util.*;

public class leetcode11_盛最多水的容器 {
    /*
       暴力解法，从下到上遍历高度temp，寻找左右两侧的高度第一次大于等于temp的索引 startIndex,endIndex,
       结果为 temp*(endIndex-startIndex)
     */
    public int maxArea1(int[] height) {
        boolean flag=true;
        int result=0;
        int temp=1; //起始高度，之后的高度层层递增
        int startIndex=-1;
        int endIndex=-1;
        while(flag){
            for(int i=0;i<height.length;i++){
                if(height[i]>=temp&&startIndex==-1){ //寻找左边界
                    startIndex=i;
                    for(int j=height.length-1;j>i;j--){ //寻找右边界
                        if(height[j]>=temp){
                            endIndex=j;
                            if(temp*(endIndex-startIndex)>result){
                                result=temp*(endIndex-startIndex);
                            }
                            temp++;
                            break;
                        }
                    }
                    if(endIndex==-1){
                        flag=false;
                    }
                    break;
                }
            }
            if (startIndex==-1){
                break;
            }
            startIndex=-1; //初始化状态
            endIndex=-1;
        }
        return result;
    }
    /*
    * 优化解法：双指针
    * 某一个时刻的 area=Math.min(height[end],height[begin])*(end-begin)
    * 此时我们有三种选择：
    *   1.移动两个值的较小值的位置
    *   2.移动两个值的较大值的位置：不行  移动较大值的位置时，Math.min(height[end],height[begin]) 不会增加，而(end-begin)减小，area 减小
    *   3.同时移动两个所在位置
    *
    * https://leetcode-cn.com/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
    * */
    public int maxArea2(int[] height) {
        int ret=0;
        int begin=0;
        int end=height.length-1;
        while (begin<end){ //begin==end 此时begin 与end 之间没有间隔不构成矩形
            ret=Math.max(ret,Math.min(height[end],height[begin])*(end-begin));
            if (height[begin]<height[end]){ //此时左侧小就增加左侧
                begin++;
            }else {
                end--;
            }
        }
        return ret;
    }
}
