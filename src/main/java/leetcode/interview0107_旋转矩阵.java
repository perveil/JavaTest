package leetcode;

public class interview0107_旋转矩阵 {
    public void rotate(int[][] matrix) {
        int len=matrix.length;
        /*
         沿着对角线对称置换
        */
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // 逆转每一行
        for(int i=0;i<len;i++){
            int left=0,right=len-1;
            while(left<right){
                int temp=matrix[i][right];
                matrix[i][right]=matrix[i][left];
                matrix[i][left]=temp;
                left++;
                right--;
            }
        }
    }
}
