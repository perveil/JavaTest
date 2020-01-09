package leetcode.dp;

import java.util.List;

/*
* [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
  ]
*  自顶向下的最短距离
* */
public class leetcode120 {
    /*
    * 转化为自底向上的最短距离
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        /*
        *
        * */
        for (int i = triangle.size()-1; i>=0; i--){
            List<Integer> cur=triangle.get(i);
            for (int j = 0; j <cur.size() ; j++) {
                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+cur.get(j);
            }

        }
        return dp[0][0];
    }
}
