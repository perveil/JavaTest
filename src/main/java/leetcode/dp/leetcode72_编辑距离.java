package leetcode.dp;

public class leetcode72_编辑距离 {
    /*
    * word1 -> word2
    * */
    public int minDistance(String word1, String word2) {
        char [] array1=word1.toCharArray();
        char [] array2=word2.toCharArray();
        int [][] dp=new int[array1.length+1][array2.length+1]; //dp[i][j]表示 word1 的前i 个字符 表示 word2的前j个字符的最短编辑距离
        //初始化第一列和第一行
        for (int i = 0; i <=array1.length; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=array2.length ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=array1.length ; i++) {
            for (int j = 1; j <= array2.length; j++) {
                if (array1[i-1]==array2[j-1]){
                    /*
                    * i j 所对应的字符相同时
                    *可以选择使用这个相应位置的字符：dp[i-1][j-1]
                    * 可以选择不使用这个相应位置的字符,则需要替换、删除、插入一次操作：dp[i-1][j]+1,dp[i][j-1]+1
                    * */
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }else{
                    /*
                     * i j 所对应的字符不同时
                     * 需要替换、删除、插入一次操作：dp[i-1][j-1]+1替换、dp[i][j-1]+1(替换、删除)、dp[i-1][j-1]+1(插入)
                     * */
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[array1.length][array2.length];
    }
}
