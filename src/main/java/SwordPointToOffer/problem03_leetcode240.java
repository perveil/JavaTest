package SwordPointToOffer;

public class problem03_leetcode240 {
    /*
       右上角-> MAX(row_1) MIN(col_(matrix.length-1))
    *  起始位置在右上角，matrix[i][j] >target 时j列往下都大于target，target是从上到下移动的，所以排除此列
    *                  matrix[i][j] <target 时i行往左都小于target，target是从右侧向左侧移动的，所以排除此行
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length; // 数组的行数
        int cols = matrix[0].length; // 数组行的列数
        int row = 0; // 起始开始的行号
        int col = cols - 1; // 起始开始的列号
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (matrix[row][col] == target) { // 如果找到了就直接退出
                return true;
            }else if (matrix[row][col] > target){
                col--;
            }
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        new problem03_leetcode240().searchMatrix(
                new int[][]{
                        {1, 4, 7, 11, 15}
                },4
        );
    }
}
