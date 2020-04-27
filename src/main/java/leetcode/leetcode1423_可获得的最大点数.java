package leetcode;
/*
  @Date:2020/4/27 17:32
  @Author:Administrator
*/

import java.lang.reflect.Array;
import java.util.*;

public class leetcode1423_可获得的最大点数 {
    /*
    * 左右两侧的数字个数的组合 k=6=>1+5、2+4 、3+3、0+6
    * 蛮力法 O(n^2)
    * */
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        if (k==cardPoints.length){
            for (int i = 0; i <cardPoints.length ; i++) {
                sum+=cardPoints[i];
            }
            return sum;
        }
        int coupleNum=k/2;
        for (int i = 0; i <=coupleNum; i++) {
            // 左侧 i  右侧 k-i
            int curSum=0;
            //左侧和
            for (int j = 0; j <i ; j++) {
               curSum+=cardPoints[j];
            }
            //右侧和
            for (int j=cardPoints.length+i-k;j<cardPoints.length;j++){
                curSum+=cardPoints[j];
            }
            sum=Math.max(sum,curSum);

            // 左侧 k-i  右侧 i
            curSum=0;
            for (int j = 0; j <k-i ; j++) {
                curSum+=cardPoints[j];
            }
            //右侧和
            for (int j=cardPoints.length-i;j<cardPoints.length;j++){
                curSum+=cardPoints[j];
            }
            sum=Math.max(sum,curSum);
        }
        return sum;
    }
    /*
    * 滑动窗口法 维护一个len-k 的窗口，使得窗口内的和最小=>两侧的和最大
    * 问题转换成为：len-k的窗口的最小和
    * */

    public int maxScoreAC(int[] cardPoints, int k) {
        int len = cardPoints.length, sum = 0;
        for (int cardPoint: cardPoints) {
            sum += cardPoint;
        }
        int min = Integer.MAX_VALUE, temp = 0;
        int length = len - k;
        //求len-k 窗口的最小和
        for (int i = 0; i < len; i++) {
            temp += cardPoints[i];
            if (i >= length) {
                temp -= cardPoints[i - length];
            }
            if (i >= length - 1) //[0,length-1] 共有length 个数
                min = Math.min(min, temp);
        }
        return sum - min;
    }


    public static void main(String[] args) {
        new leetcode1423_可获得的最大点数().maxScore(new int[]{
                1,2,3,4,5,6,1
        },3);
    }


}
