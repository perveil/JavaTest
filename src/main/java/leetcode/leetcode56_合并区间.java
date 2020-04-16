package leetcode;

import java.util.*;

public class leetcode56_合并区间 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0||intervals.length==1) return intervals;
        List<int[]> list = new ArrayList<>();
        //依据首元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //前后合并
        for (int i = 1; i < intervals.length ; i++) {
            //intervals[i][0] intervals[i][1] 分别表示i+1的区间合并完之后的左侧、右侧边界
            if (intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = intervals[i][0] < intervals[i-1][0] ? intervals[i][0] : intervals[i-1][0];
                intervals[i][1] = intervals[i][1] < intervals[i-1][1] ? intervals[i-1][1] : intervals[i][1];
            }else{ //重叠区间合并完毕
                list.add(intervals[i-1]);
            }
            //区间末尾是最后一个合并完成的区间
            if (i==intervals.length-1){
                list.add(intervals[i]);
            }
        }

        return list.toArray(new int[0][]);
    }
    //leetcode757 设置交集
    public int intersectionSizeTwo(int[][] intervals) {
        int [][] boradenArray=merge(intervals);  //求并集
        return boradenArray.length;
    }

    public static void main(String[] args) {
        new leetcode56_合并区间().intersectionSizeTwo(new int[][]{
                {1,3},{2,4},{2,5},{3,5}
        });
    }
}
