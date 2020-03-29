package leetcode.bfs;

import java.util.LinkedList;

public class leetcode200_岛屿数量 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        int res=0;
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        boolean[][] marked = new boolean[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (!marked[i][j]&&grid[i][j]=='1'){
                    res++;
                    //little trick
                    LinkedList<Integer> queue=new LinkedList<>();
                    queue.addLast(i*cols+j);
                    marked[i][j] = true;
                    while (!queue.isEmpty()){
                        int cur=queue.removeLast();
                        int curX = cur / cols;
                        int curY = cur % cols;
                        for (int k = 0; k <4 ; k++) {
                            int newX = curX + directions[k][0];
                            int newY = curY + directions[k][1];
                            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                                queue.addLast(newX * cols + newY);
                                marked[newX][newY] = true;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
