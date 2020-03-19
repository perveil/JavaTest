package leetcode.dp;

public class leetcode96 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if (len3!=len1+len2) return false;
        boolean dp[][]=new boolean[len1+1][len2+1]; //dp[i][j] 表示是否s1的前i个字符和s2的前j个字符是否可以表示s3的i+j个字符
        //初始化第一列
        dp[0][0]=true; // ""+""=>""
        for (int i =1; i <=len1 ; i++) {
            dp[i][0]=(dp[i-1][0]&&s1.charAt(i-1)==s3.charAt(i-1));
        }
        //初始化第一行
        for (int i =1; i <=len2 ; i++) {
            dp[0][i]=(dp[0][i-1]&&s2.charAt(i-1)==s3.charAt(i-1));
        }
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                /*
                * (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1))
                *  当 s1的前i个+s2的前j-1 个 可以表示 s3的i+j-1 时，此时添加 s2的j个字符是否与s3的i+j 相比
                *  (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) 同理
                * */
                dp[i][j]=(dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }

        return dp[len1][len2];
    }
}
