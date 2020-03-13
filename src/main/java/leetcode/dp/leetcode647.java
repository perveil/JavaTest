package leetcode.dp;

public class leetcode647 {
    public int countSubstrings(String s) {
        int res=0;
        boolean dp[][]=new boolean[s.length()][s.length()];
        for (int i = 0; i <s.length(); i++) {
            for (int j = i; j >-1; j--) { //从i开始 考虑单字符
                if (s.charAt(i)==s.charAt(j) &&((i-j)<2||dp[i-1][j+1])){
                    // (i-j)<2  j=i-1,j=i
                    dp[i][j]=true;
                    res++;
                }
            }
        }
        return res;
    }
    /*
    * 中心拓展法=》回文问题
    * */
    public int countSubstrings2(String s) {
        int count = 0;
        int i;
        for(i = 0; i < s.length(); i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }
        return count;
    }
    public int countPalindrome (String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }

}
