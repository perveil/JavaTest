package leetcode.dfs;
/*
* 两种思路：
*  1.dfs/bfs
*  2.并查集
* */
public class leetcode200 {
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //方向数组
    private boolean[][] marked; //标记数组
    // grid 的行数
    private int rows;
    // grid 的列数
    private int cols;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        rows=grid.length;
        if (rows==0) return 0;
        cols=grid[0].length;
        this.grid=grid;
        marked=new boolean[rows][cols]; //初始化标记数组
        int res=0;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (marked[i][j]==false&&grid[i][j]=='1'){
                    res++;
                    dfs(i,j);
                }
            }
        }
        return res;
    }
    private void dfs(int i, int j) {
        marked[i][j]=true;
        for (int k = 0; k <4; k++) {
            int newX=i+directions[k][0];
            int newY=j+directions[k][1];
            if(inArea(newX,newY)&&grid[newX][newY]=='1'
                    &&marked[newX][newY]==false){
                dfs(newX,newY);
            }
        }

    }
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
