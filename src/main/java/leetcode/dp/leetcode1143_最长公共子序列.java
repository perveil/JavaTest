package leetcode.dp;

/*
* 最长公共子序列
*
* */
public class leetcode1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][]dp=new int[n+1][m+1];
        /*
        * 为什么从1开始，因为0时的字符串与任何字符串都无公共序列
        * */
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    /*
                    * text1.charAt(i-1)!=text2.charAt(j-1)时
                    * 选择抛弃text1.charAt(i-1) /text2.charAt(j-1)
                    * 抛弃后的取最大值
                    * */
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[n][m];
    }
}
