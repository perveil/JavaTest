package leetcode;
/*
  @Date:2020/4/16 9:27
  @Author:Administrator
*/

import java.util.*;

public class leetcode57_插入区间 {
    /*
    * 最初思路： 使用 newInterval 去遍历intervals 看看是否可以合并
    * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length==0) return new int[][]{newInterval};
        List<int[]> list = new ArrayList<>();
        int i=0; //遍历intervels
        for(;i<intervals.length;i++){
            if (intervals[i][1]<newInterval[0]){ //newInterval 在intervals[i]的右侧
                list.add(intervals[i]);
            }else if (intervals[i][0]>newInterval[1]){//newInterval 在intervals[i]的左侧
                list.add(newInterval);
                break; //推出循环
            } else{
                newInterval[0]=newInterval[0]>intervals[i][0]?intervals[i][0]:newInterval[0];
                newInterval[1]=newInterval[1]>intervals[i][1]?newInterval[1]:intervals[i][1];
            }
            if(i==intervals.length-1){
                list.add(newInterval);
            }
        }
        if (i<intervals.length){
            while(i<intervals.length){
                list.add(intervals[i++]);
            }
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new leetcode57_插入区间().insert(new int[][]{
                new int[]{1,2}, new int[]{3,5}, new int[]{6,7}, new int[]{8,10}, new int[]{12,16}
        },new int[]{4,8});
    }
}
