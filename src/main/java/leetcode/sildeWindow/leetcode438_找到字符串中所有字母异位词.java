package leetcode.sildeWindow;

import java.util.ArrayList;
import java.util.List;

public class leetcode438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        if (s.length()<p.length()) return res;
        int need[]=new int[26];
        int cur[]=new int[26];
        for (int i = 0; i <p.length() ; i++) {
            need[p.charAt(i)-'a']++;
        }
        for (int i = 0; i <p.length() ; i++) {
            cur[s.charAt(i)-'a']++;
        }
        if (isequal(need,cur))
            res.add(0);
        int left=0;
        int right=p.length();
        while(right<s.length()){
            cur[s.charAt(right)-'a']++;
            cur[s.charAt(left)-'a']--;
            if (isequal(need,cur))
                res.add(left+1);
            right++;
            left++; // 同步移动的窗口
        }
        return  res;
    }
    private  boolean isequal(int[] need,int []cur){
        for (int i = 0; i <26 ; i++) {
            if (need[i]!=cur[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new leetcode438_找到字符串中所有字母异位词().findAnagrams("cbaebabacd" , "abc");
    }
}
