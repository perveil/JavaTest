package leetcode.dp;
/*
* 第一次尝试 失败
*  https://blog.csdn.net/racaljk/article/details/79337727
*  以上博客是最一目了然的
* */
public class leetcode91 {
    class Solution {
        public int numDecodings(String s) {
            if (s.length()==0) return 0;
            int [] dp=new int[s.length()];
            char [] chars=s.toCharArray();
            //dp
            dp[0]=chars[0]=='0'?0:1;   //如果第一位是0，则无法转码
            if (s.length()==1) return dp[0];
            int k = s.charAt(0) > '0' && s.charAt(1) > '0'? 1:0;
            dp[1] = k + (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6' ? 1:0);  //第二位dp
            for (int i = 2; i <chars.length ; i++) {
                if(s.charAt(i)!='0'){
                    dp[i] += dp[i-1];
                }
                if(s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)<='6'){
                    dp[i] += dp[i-2];
                }
            }
            return dp[s.length()-1];

        }
    }

    public static void main(String[] args) {
        System.out.println(
                new leetcode91().new Solution().numDecodings("2222")
        );

    }
}
