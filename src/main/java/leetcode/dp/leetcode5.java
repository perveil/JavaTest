package leetcode.dp;
/*
*  最长回文子串
* */
public class leetcode5 {
    public String longestPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        return longestCommonSubsequence(s,reverse);
    }
    /*
    * leetcode 1143 的改版
    *
    * S="abc435cba"，S`="abc534cba"
    *  的最长公共子串是“abc”、“cba” 但都不是回文串
    * */
    public String longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][]dp=new int[n+1][m+1];
        /*
         * 为什么从1开始，因为0时的字符串与任何字符串都无公共序列
         * */
        int maxEnd=0;
        int maxLen=1;
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                /*
                * 判断逆转后的坐标是否对应
                *
                * */
                if (dp[i][j]>maxLen){
                    int beforeRev = n - 1 - j; //逆转之前的坐标
                    if (beforeRev + dp[i][j] - 1 == i) {  //逆转之前的坐标+最长公共子串的长度=逆转之后的坐标 判断下标是否对应
                        maxLen = dp[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return text1.substring(maxEnd-maxLen+1,maxEnd+1);
    }
}
