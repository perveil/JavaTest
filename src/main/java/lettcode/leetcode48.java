package lettcode;
/*
旋转图像
 */
public class leetcode48 {
    public static void main(String[] args) {
        new leetcode48().rotate(new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        });
    }
    //贪心法：上下左右模块分解数组
    public void rotate(int[][] matrix) {
        int ma=matrix.length; //数组的长和宽
        int left[]=new int[ma];
        int right[]=new int[ma];
        int top []=new int[ma];
        int bottom[]=new int[ma];

    }
    //使用一个数组存储中间状态，顺时针覆盖
    public void rotateT(int[][] matrix){

    }
}
