package leetcode.bfs;

/*
*  多源bfs
* */

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class leetcode994_腐烂的橘子 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int orangesRotting(int[][] grid) {
        int res=0;
        rows = grid.length;
        cols = grid[0].length;
        Queue<Integer> queue=new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap(); //记录所有的节点对应的深度
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (grid[i][j]==2){
                    queue.add(i*cols+j);
                    depth.put(i*cols+j, 0); //初始腐烂的橘子的深度为0
                }
            }
        }
        while(!queue.isEmpty()){
            int code=queue.remove();
            int r = code / cols, c = code % cols;
            for (int k = 0; k <4 ; k++) {
                int newX = r + directions[k][0];
                int newY = c + directions[k][1];
                if (inArea(newX, newY) && grid[newX][newY] == 1) {
                    grid[newX][newY] =2;
                    queue.add(newX*cols+newY);
                    depth.put(newX*cols+newY,depth.get(code)+1); //从code向下传染下一步
                    res=depth.get(code)+1;
                }
            }
        }
        /*
        * 传染后是否存在未腐烂的橘子
        * */
        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;

        return res;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
