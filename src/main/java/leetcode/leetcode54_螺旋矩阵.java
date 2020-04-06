package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if (matrix.length==0) return res;
        int top=0,left=0,right=matrix[0].length-1,bottom=matrix.length-1;
        /*
        *       top
        * left       right
        *      bottom
        * */
        while(true){
            //从左到右
            for (int i = left; i <=right ; i++)  res.add(matrix[top][i]);
            //从上到下
            if (++top>bottom) break; //下不去就便结束了
            for (int i = top; i <=bottom ; i++)  res.add(matrix[i][right]);
            //从右到左
            if (--right<left) break;
            for (int i = right; i >=left ; i--)  res.add(matrix[bottom][i]);
            //从下到上
            if (--bottom>top) break;
            for (int i = bottom; i >=top ; i--)  res.add(matrix[i][left]);

            if (++ left > right) break; //最后left++
        }
        return res;
    }
}
