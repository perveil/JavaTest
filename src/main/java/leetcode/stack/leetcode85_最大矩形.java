package leetcode.stack;

public class leetcode85_最大矩形 {
    /*
    * 暴力破解
    * 求以matric[i][j] 为右下角的矩形的最大面积
    * 如何求这个矩形：
    *     1.统计每一行（i）的连续的1的个数  1 1 1 0 1 1 -》1 2 3 0 1 2
    *     2.沿j列向上寻找宽度(寻找的是此列上最小的连续的1的宽度)，同时确定高度。
    *
    * */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        //保存以当前行数字结尾的连续 1 的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1; //边界
                    } else {
                        width[row][col] = width[row][col - 1] + 1;
                    }
                    //发现1 的时候向上遍历
                    int minwidth=width[row][col]; //寻找宽度
                    for (int i = row; i >-1 ; i--) { //向上遍历，寻找高度
                        int height=row-i+1;
                        minwidth=Math.min(minwidth,width[i][col]);
                        maxArea=Math.max(maxArea,height*minwidth);
                    }
                } else {
                    width[row][col] = 0; //不是1 则为0
                }
            }
        }
        return maxArea;

    }
    /*
    * 同84的解法 使用单调栈
    * */
    public int StackmaximalRectangle(char[][] matrix) {
        int maxArea=0;
        int[] heights = new int[matrix[0].length];
        for (int row = 0; row<matrix.length ; row++) { //求heights
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col]++;
                }else {  //只要看见0 height就设置为0
                    heights[col]=0;
                }
            }
            maxArea=Math.max(maxArea,new leetcode84_柱状图最大的矩形().largestRectangleArea(heights));
        }
        return  maxArea;
    }

}
