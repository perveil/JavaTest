package leetcode.dp;

import java.util.*;
/*
 *  递归写法(bfs)
 *1. 如果字符串p.eq(s)==true return true
 *2.如果p=*                return true
 *3.if(p.length==0 || s.length==0) return false
 *4.if (p.length==0&& s.length==0) return true
 *5.如果p[0]==s[0]或者p[0]='?' return isMatch(s[1:],p[1:])
 *6.如果p[0]='*'
 *   1.* 没有匹配字符 return isMatch(s,p[1:])
 *   2.* 匹配一个或者多个字符， return isMatch(s[1:],p)
 *7.若p[0]!=s[0] return false
 *
 *  优化问题
 *  1.  的功能 等价于
 *  2. 记忆化剪枝
 * */
public class leetcode44_通配符匹配 {
    /*
    * 动态规划
    * dp[i][j] 表示 s[:i] 是否可以与p[:j] 匹配
    * 1. s[i]==p[j] 或者p[j]='?' 也就是此时s以s[i]为结尾，p以p[j]为结尾，
    *    且s[i]=p[j],此时只需要知道dp[i-1][j-1]的取值，，dp[i][j]=dp[i-1][j-1]
    * 2. s[i]!=p[j] 且p[j]！='?' ，dp[i][j]=false
    * 3.当p[j]=='*' 时，
    *    有两种情况
    *         1. *匹配空字符串  dp[i][j]= dp[i][j-1]
    *         2. *匹配若干长的字符串,相当于s在i-1处,p在j处是否可以匹配，如果可以，那么*就再多指代一个字符s[i]，dp[i][j]=dp[i-1][j]
    * 初始化：
    *    dp[0][0]=true;
    *    dp[0][j]=只要p=若干个'*' 时，则为true，其余情况为false
    *    dp[i][0]=false;
    *
    * */
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean [][]dp=new boolean[m+1][n+1];
        //初始化
        dp[0][0]=true;
        for (int i = 1; i <=n; i++) {
            dp[0][i]=dp[0][i-1] && p.charAt(i-1)=='*';
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if (s.charAt(i-1)==p.charAt(j-1)||
                p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if (p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

}
