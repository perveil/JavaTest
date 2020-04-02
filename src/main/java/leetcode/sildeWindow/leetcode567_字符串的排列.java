package leetcode.sildeWindow;

public class leetcode567_字符串的排列 {
    public boolean checkInclusion(String s1, String s2) {
        int need[]=new int[26];
        int cur[]=new int[26];
        for (int i = 0; i <s1.length() ; i++) {
            need[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i <s1.length() ; i++) {
            cur[s2.charAt(i)-'a']++;
        }
        if (isequal(need,cur))
            return true;
        int left=0;
        int right=s1.length();
        while(right<s2.length()){
            cur[s2.charAt(right)-'a']++;
            cur[s2.charAt(left)-'a']--;
            if (isequal(need,cur))
                return true;
            right++;
            left++; // 同步移动的窗口
        }
        return false;
    }
    private  boolean isequal(int[] need,int []cur){
        for (int i = 0; i <26 ; i++) {
            if (need[i]!=cur[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode567_字符串的排列().checkInclusion(
                "ab","eidbaooo"
        );
    }
}
