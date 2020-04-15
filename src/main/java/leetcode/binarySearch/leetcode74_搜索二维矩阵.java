package leetcode.binarySearch;/*
  @Date:2020/4/15 10:32
  @Author:Administrator
*/

import java.util.*;

public class leetcode74_搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        for (int i = 0; i <matrix.length ; i++) {
            if (target>=matrix[i][0]&&target<=matrix[i][matrix[i].length-1]){ // 找到target 所在的目标行
                //二分
                int l = 0;
                int r = matrix[0].length-1;//在[l...h]的范围里查找target
                while (l <= r ) {//当l==h时，区间[l...h]依然有效
                    int mid = l + (r  - l) / 2;//(l+r)/2== l + (r  - l) / 2
                    if (target > matrix[i][mid]) {
                        l = mid + 1;//target在区间[mid+1...r]中
                    }
                    if (target < matrix[i][mid]) {
                        r  = mid - 1;//target在区间[l...mid+1]中
                    }
                    if (target == matrix[i][mid]) {//相等返回下标
                        return true;
                    }
                }
                //没有查找到返回-1。
                return false;
            }
        }
        return false;
    }
}
