package leetcode.dp;
/*
*   最短编辑距离
*
*   字符串
* */
public class leetcode42 {
    public static void main(String[] args) {
        new Solution42().minDistance("happy","hsppay");
    }
}
class Solution42 {
    public int minDistance(String word1, String word2) {
        char [] array1=word1.toCharArray();
        char [] array2=word2.toCharArray();
        int [][] dp=new int[array1.length+1][array2.length+1];
        for (int i = 0; i <=array1.length; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=array2.length ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=array1.length ; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i-1]==array2[j-1]){  //i j的字符相同
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[array1.length][array2.length];
    }
}
