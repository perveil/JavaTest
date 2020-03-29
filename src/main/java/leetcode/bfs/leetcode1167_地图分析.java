package leetcode.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
* 多源广度优先搜索/图的多源层次遍历，求最大距离
* */
public class leetcode1167_地图分析 {
    int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private int rows;
    private int cols;
    public int maxDistance(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        if (rows==0) return -1; //无解
        int res=0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]==1){
                    queue.add(i* cols+j); //陆地入队
                }
            }
        }
        int size = queue.size();
        if (size == 0 || size == cols * cols) { //无解
            return -1;
        }
        while(!queue.isEmpty()){
            int currentQsize=queue.size();
            for (int i = 0; i <currentQsize ; i++) {
                int cur=queue.poll(); //出队
                int curX = cur / cols;
                int curY = cur % cols;
                for (int j = 0; j <4 ; j++) {
                    int newX = curX + directions[j][0];
                    int newY = curY + directions[j][1];
                    if (inArea(newX,newY)&&grid[newX][newY]==0){ //关注正确范围内的海洋
                        grid[newX][newY]=1; //海洋变陆地
                        queue.add(newX*cols+newY); //加入下一层的原点
                    }
                }
            }
            res++; //图的层次遍历
        }

        return res-1;
    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
