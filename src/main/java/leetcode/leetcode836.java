package leetcode;

import java.util.Map;

public class leetcode836 {
    /*
    * 矩阵重叠-》区间重叠
    * 如果两个矩阵重叠，那么它们重叠的区域一定也是一个矩形，那么这代表了两个矩形
    * 在x轴、y轴的投影都有相交的地方
    * 两个区间为（x1,y1） (x2,y2)
    * min(y1,y2)>max(x1,x2) 时两个区间重叠
    * */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2],rec2[2])>Math.max(rec1[0],rec2[0])&&
                Math.min(rec1[3],rec2[3])>Math.max(rec1[1],rec2[1]));
    }
}
