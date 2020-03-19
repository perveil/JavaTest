package leetcode;

public class interview0104 {
    public boolean canPermutePalindrome(String s) {
        int chars[]=new int[26];
        for (int i = 0; i <s.length() ; i++) {
            chars[s.charAt(i)-'a']++;
        }
        int numOfodd=0;
        for (int i = 0; i <26 ; i++) {
            if (chars[i]%2!=0) numOfodd++;
        }
        return numOfodd>1?false:true;
    }

    public static void main(String[] args) {

    }
}
