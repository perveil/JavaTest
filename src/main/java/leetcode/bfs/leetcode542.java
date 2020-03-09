package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode542 {
    // 反向 多源BFS
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row=0;
    int col=0;
    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                } else {
                    //原地修改
                    matrix[i][j] = row + col;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] s = queue.poll();
            // 遍历方向
            for (int [] v:
                 vector) {
                int newX = s[0] + v[0];
                int newY = s[1]+v[0];
                if (inArea(newX,newY)){
                    matrix[newX][newY]=matrix[s[0]][s[1]]+1;
                    queue.add(new int[]{
                            newX,newY
                    });
                }
            }
        }
        return  matrix;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
