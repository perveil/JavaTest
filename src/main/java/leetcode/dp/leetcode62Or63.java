package leetcode.dp;

import java.util.Arrays;

/*
*  不同路径
* */
public class leetcode62Or63 {
    /*
    * (1,1)->(n,m)
    * n 指的是列数
    * m 指的是行数
    * */
    public int uniquePaths(int m, int n) {
        if(m==1||n==1) return 1;
        int dp[][]=new int[n+1][m+1];
        for (int i = 1; i <=n ; i++) {
            dp[i][1]=1;
        }
        for (int i = 1; i <=m; i++) {
            dp[1][i]=1;
        }
        for (int i = 2; i <=n ; i++) {
            for (int j = 2; j<=m ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n][m];
    }
    /*
    *  在上题的基础上在网格中添加障碍物
    *
    * */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];  //状态转换数组
        /*
        * 初始化动态规划矩阵,在1*n/n*1 的表格中，只要遇见1 就无路径可通
        * */
        for (int i = 0; i <obstacleGrid.length ; i++) {
            if (obstacleGrid[i][0]==0) dp[i+1][1]=1; //n*1 矩阵 遇见1 则为不通
            else break;
        }
        for (int i = 0; i <obstacleGrid[0].length ; i++) {
            if (obstacleGrid[0][i]==0) dp[1][i+1]=1;  //1*n 矩阵 遇见1 则为不通
            else break;
        }
        for (int i = 2; i <=obstacleGrid.length ; i++) {
            for (int j = 2; j <=obstacleGrid[0].length ; j++) {
                if (obstacleGrid[i-1][j-1]==1) dp[i][j]=0;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];

    }

    public static void main(String[] args) {
        new leetcode62Or63().uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });
    }
}
