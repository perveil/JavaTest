package leetcode;

public class leetcode214 {
    /*
    * 暴力解法、KMP
    * */
    public String shortestPalindrome(String s) {
        /*
        * 由于只能在前边添加，所以回文串的中心在index 0-halflen
        * 从index=0处开始寻找最长回文子串，然后将剩余的就直接逆转拼接在头部
        * */
        int minlen=s.length()*2-1; //最长
        String resStr="";
        for (int i =1; i<s.length() ; i++) { //i 表示回文串的中心点的索引
            String temp=s.substring(0,i+1);
           if (isPalindrome(temp)){
               minlen=s.length()+s.length()-i-1;
               resStr=new StringBuilder().append(new StringBuilder(s.substring(i+1,s.length())).reverse()).append(s).toString();
            }
        }
        if (resStr==""){
            resStr=new StringBuilder().append(new StringBuilder(s.substring(1,s.length())).reverse()).append(s).toString();
        }
        return resStr;

    }
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }

    public String shortestPalindromeForKMP(String s) {
        String ss = s + '#' + new StringBuilder(s).reverse();
        int max = getLastNext(ss);
        return new StringBuilder(s.substring(max)).reverse() + s;
    }

    //返回 next 数组的最后一个值
    public int getLastNext(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        int[] next = new int[n + 1];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int i = 2;
        while (i <= n) {
            if (k == -1 || c[i - 1] == c[k]) {
                next[i] = k + 1;
                k++;
                i++;
            } else {
                k = next[k];
            }
        }
        return next[n];
    }


    public static void main(String[] args) {
        new leetcode214().shortestPalindrome("abcd");
    }
}
