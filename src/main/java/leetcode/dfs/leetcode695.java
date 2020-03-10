package leetcode.dfs;

public class leetcode695 {
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //方向数组
    private boolean[][] marked; //标记数组
    // grid 的行数
    private int rows;
    // grid 的列数
    private int cols;
    int cur=0;
    int max=0;
    int [][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        rows=grid.length;
        if (rows==0) return 0;
        cols=grid[0].length;
        marked=new boolean[rows][cols];   //初始化标记数组
        this.grid=grid;
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if (marked[i][j]==false&&grid[i][j]==1){
                    dfs(i,j);
                    max=Math.max(max,cur);
                    cur=0; //归置0
                }
            }
        }
        return max;
    }
    private void dfs(int i, int j) {
        marked[i][j]=true;
        cur++;
        for (int k = 0; k <4; k++) {
            int newX=i+directions[k][0];
            int newY=j+directions[k][1];
            if(inArea(newX,newY)&&grid[newX][newY]==1
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
