package leetcode;
/*
* 递归，遇见1返回0
* */
public class leetcode63 {
    public static void main(String[] args) {
        System.out.println(
                new leetcode63().uniquePathsWithObstacles(new int[][]{
                        {0,0,0},
                        {0,1,0},
                        {0,0,0},
                        {0,0,0}
                })
        );
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         return find(obstacleGrid,0,0);
    }
    public int find(int[][] obstacleGrid,int y,int x){
        if (obstacleGrid[y][x]==1){  //这条路走不通
             return 0;
        }
        if (y==obstacleGrid.length-1&&x==obstacleGrid[0].length-1){
            return 1;
        }
        if (y+1<obstacleGrid.length&&x+1<obstacleGrid[0].length){
            return  find(obstacleGrid,y+1,x)+find(obstacleGrid,y,x+1);
        }
        if (y+1<obstacleGrid.length){
            return  find(obstacleGrid,y+1,x);
        }
        if (x+1<obstacleGrid.length){
           return   find(obstacleGrid,y,x+1);
        }
        return 0;
    }
}
