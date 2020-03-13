package leetcode;

public class leetcode5 {
    /*
    *  使用中心拓展算法
    * 选定一个中心去向两边拓展
    * 当最长回文子串为奇数长度时，中心是某个字符
    * 当最长回文子串为偶数长度时，中心是两个字符之间的空格
    * 所以一共有2n-1（n+n-1）个可能的中心
    * */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start=0,end=0;
        for (int i = 0; i <s.length() ; i++) {
            int oddlen=expandAroundCenter(s,i,i);  //奇数长度
            int evenlen=expandAroundCenter(s,i,i+1);// 偶数长度
            int  len=Math.max(oddlen,evenlen);
            if (len>end-start){
                start=i-(len-1)/2; //计算左侧
                end=i+len/2;  //计算右侧
            }
        }
        return s.substring(start,end+1);

    }
    /*
    * param:
    *    s:
    *    left:中心点的左侧
    *    right:中心点的右侧
    * */
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
