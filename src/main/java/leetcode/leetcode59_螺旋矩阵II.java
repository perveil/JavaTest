package leetcode;

public class leetcode59_螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        int[][]res=new int[n][n];
        if (n==0) return res;
        int top=0,left=0,right=n-1,bottom=n-1;
        int cur=1;
        while (true){
            //从左到右
            for (int i = left; i <=right ; i++)  res[top][i]=cur++;
            //从上到下
            if (++top>bottom) break; //下不去就便结束了
            for (int i = top; i <=bottom ; i++)  res[i][right]=cur++;
            //从右到左
            if (--right<left) break;
            for (int i = right; i >=left ; i--)  res[bottom][i]=cur++;
            //从下到上
            if (--bottom<top) break;
            for (int i = bottom; i >=top ; i--)  res[i][left]=cur++;

            if (++ left > right) break; //最后left++
        }
        return res;
    }

}
