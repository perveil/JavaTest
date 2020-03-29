package leetcode.dfs;
/*
*  直接回溯超时，使用dfs
*
* */
public class leetcode79_单词搜索 {
    char[][] board;
    char[] charOfWord;
    int rows;
    int cols;
    boolean [][] mark;
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.charOfWord=word.toCharArray();
        this.rows=board.length;
        this.cols=board[0].length;
        if (rows == 0)  return false;
        mark=new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) { //dfs 入口
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int start) {
        if (start ==charOfWord.length - 1) {
            return board[i][j] ==charOfWord[start];
        }
        if (board[i][j] == charOfWord[start]) {
            mark[i][j] = true;
            for (int k = 0; k <4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !mark[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) { //向下dfs
                        return true;
                    }
                }
            }
            mark[i][j]=false; //回溯
        }
        return false;

    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


}
