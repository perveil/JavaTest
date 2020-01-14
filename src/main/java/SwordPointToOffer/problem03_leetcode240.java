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
    /*
    *  leetcode 74
    * */
    public boolean searchMatrixOfBinarySearch(int[][] matrix, int target) {
        if (matrix[0].length==0) return false;
        if(matrix.length==0) return false;
        for (int i = 0; i <matrix.length ; i++) {
            if (target>=matrix[i][0]&&target<=matrix[i][matrix[i].length-1]){
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

    public static void main(String[] args) {
        new problem03_leetcode240().searchMatrix(
                new int[][]{
                        {1, 4, 7, 11, 15}
                },4
        );
    }
}
