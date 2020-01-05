package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode73 {
    public void setZeroes(int[][] matrix) {
        List<int []> indexList=new ArrayList<>();
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    indexList.add(new int[]{
                           i,j
                    });
                }
            }
        }
        for (int [] a:indexList) {
            int iindex=a[0]; //行索引
            int jindex=a[1];//列索引
            for (int i = 0; i <matrix[0].length ; i++) {
                matrix[iindex][i]=0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][jindex]=0;
            }
        }
    }

    public static void main(String[] args) {
        new leetcode73().setZeroes(new int[][]{
                {0,1,2,0},{3,4,5,2},{1,3,1,5}
        });
    }
}
