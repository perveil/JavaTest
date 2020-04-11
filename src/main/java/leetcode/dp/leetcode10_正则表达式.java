package leetcode.dp;

public class leetcode10_正则表达式 {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean [][]dp=new boolean[m+1][n+1];
        //初始化
        dp[0][0]=true;
        for (int i = 1; i <=n; i++) {
            //s=""  p="a*b*c*" 可以匹配
            if (i==1) dp[0][i]=false;
            dp[0][i]=dp[0][i-2] && p.charAt(i-1)=='*';
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (s.charAt(i-1)==p.charAt(j-1)||
                        p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    /*
                     * p.charAt(j-1)=='*',需要考虑 p.charAt(j-2)的情况,因为* 只能让p.charAt(j-2) 出现多次或者出现0次
                     * 1. p.charAt(j-2)!=s.charAt(i-1) 此时* 为 -1 *p.charAt(j-1)  dp[i][j] = dp[i][j-2];
                     * 2.
                     * */
                    if (j>1 &&p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.'){
                        dp[i][j] = dp[i][j-2]; //此时* 将前面的字符去掉
                    }
                    else {
                        dp[i][j]=dp[i][j-1]|dp[i][j-2]|dp[i-1][j];
                        /*
                        * dp[i][j-1]： 指的是*不起任何作用
                        * dp[i][j-2]： 指的是*将之前的字符去掉
                        * dp[i-1][j]： p.charAt(j-2)==s.charAt(i-1)时，
                        *    如果s[:i-1] 可以与p[:j] 匹配，则*就在多指代一个*之前的字符
                        * */
                    }

                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new leetcode10_正则表达式().isMatch("aab","c*a*b");
    }
}
