package leetcode.unionFind;/*
  @Date:2020/4/20 9:59
  @Author:Administrator
*/


import java.lang.reflect.Array;
import java.util.*;

public class leetcode200_岛屿数量I {
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
        int [] roots=new int[rows*cols]; //根数组
        Arrays.fill(roots,-1);
        //根数组初始化，每一个陆地都是一块岛屿，接下来进行岛屿合并
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (grid[i][j]=='1'){
                    roots[i*cols+j]=i*cols+j;
                    res++;
                }
            }
        }
        //合并岛屿
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (grid[i][j]=='1'){
                    int id=i*cols+j;
                    for (int [] pos:
                            directions) {
                        int x=i+pos[0];
                        int y=j+pos[1];
                        int cur_id=x*cols+y;
                        if (!inArea(x,y)||roots[cur_id]==-1) continue;
                        //合并数组
                        int p=findRoot(roots,id);int q=findRoot(roots,cur_id);
                        if (p!=q){
                            roots[p]=q;
                            res--;
                        }

                    }
                }
            }
        }
        return res;
    }
    int findRoot(int []roots,int id){
        return (id==roots[id])?id:findRoot(roots,roots[id]);
    }

    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        new leetcode200_岛屿数量I().numIslands(new char[][]{
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'}
        });
    }
}
