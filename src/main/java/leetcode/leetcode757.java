package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode757 {
    public int intersectionSizeTwo(int[][] intervals) {
        int res=0;
        List<int[]> list = new ArrayList<>();
        //依据首元素排序
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        //前后求交集
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = intervals[i][0] < intervals[i-1][0] ? intervals[i-1][0] : intervals[i][0];
                intervals[i][1] = intervals[i][1] < intervals[i-1][1] ? intervals[i][1] : intervals[i-1][1];
            }else{ //重叠区间合并完毕
                list.add(intervals[i-1]);
            }
            //区间末尾是最后一个合并完成的区间
            if (i==intervals.length-1){
                list.add(intervals[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new leetcode757().intersectionSizeTwo(new int[][]{
                {1,2},{2,3},{3,4},{4,5}
        });
    }
}
