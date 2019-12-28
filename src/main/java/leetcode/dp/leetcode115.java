package leetcode.dp;


public class leetcode115 {
    public int numDistinct(String s, String t) {

        int [][] dp=new int[t.length()+1][s.length()+1];
        for (int j = 0; j < s.length() + 1; j++) dp[0][j] = 1;
        for (int i = 1; i <t.length() + 1 ; i++) {
            for (int j = 1; j <s.length() + 1 ; j++) {
                if (t.charAt(i-1)==s.charAt(j-1)){  //匹配时，用此匹配或者不用此匹配 两种情况均可以
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1]; //不匹配时,回退到 s 的前j-1 表示 t 的前i位
                }else dp[i][j]=dp[i][j-1];
            }
        }
        return dp[t.length()][s.length()];

    }

}
