package leetcode;

public class leetcode516andll34 {
    /*
    *  两个字符串的最长公共序列--》最长回文子序列
    * leetcode1134
    * */
    public int longestPalindromeSubseq(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=s.length()-1;i>-1;i--){
            str.append(s.charAt(i)+"");
        }
        return longestCommonSubsequence(s,str.toString());
    }
    /*
    * 两个字符串的最长公共序列
    * leetcode516
    * */

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int [][]dp=new int[n+1][m+1];
        for (int i = 1; i <n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
         System.out.println(
                 new leetcode516andll34().longestPalindromeSubseq("bbbab")
         );
    }
}
