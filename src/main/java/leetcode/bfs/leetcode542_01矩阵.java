package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;
/*
* 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
* */
public class leetcode542_01矩阵 {
    // 反向 多源BFS
    private int[][] vector = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int row=0;
    int col=0;
    public int[][] updateMatrix(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean [][] marked=new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 将所有 0 元素作为 BFS 第一层
                    queue.add(new int[]{i, j});
                    marked[i][j]=true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int sizeCurQ=queue.size();
            for (int i = 0; i <sizeCurQ; i++) {
                int[] s = queue.poll();
                // 遍历方向
                for (int [] v:
                        vector) {
                    int newX = s[0]+v[0];
                    int newY = s[1]+v[1];
                    if (inArea(newX,newY)&&!marked[newX][newY]){
                        matrix[newX][newY]=matrix[s[0]][s[1]]+1;
                        queue.add(new int[]{
                                newX,newY
                        }); //遍历结束，添加到列表中
                        marked[newX][newX]=true;
                    }
                }
            }
        }
        return  matrix;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        new leetcode542_01矩阵().updateMatrix(new int[][]{
                new int[]{0,0,0},new int[]{0,1,0},new  int[]{1,1,1}
        });

    }
}
