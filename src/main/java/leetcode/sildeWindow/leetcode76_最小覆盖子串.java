package leetcode.sildeWindow;/*
  @Date:2020/4/15 10:55
  @Author:Administrator
*/

import java.util.*;
/*
* 滑动窗口经典题
* */
public class leetcode76_最小覆盖子串 {
    Map<Character, Integer> needs=new HashMap<>();
    Map<Character, Integer> cur=new HashMap<>();
    int minLen=Integer.MAX_VALUE;
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        //获得t的pattern
        for (int i = 0; i < t.length(); i++) {
            int count = needs.getOrDefault(t.charAt(i), 0);
            needs.put(t.charAt(i), count + 1);
        }
        int required = needs.size(); //需匹配的数目
        int right=0,left=0;
        int match=0; //匹配数
        int start = 0; //最短字符串的起始位置
        while(right<s.length()){
            if(needs.containsKey(s.charAt(right))){
                int count = cur.getOrDefault(s.charAt(right), 0);
                cur.put(s.charAt(right), count + 1);
                if(needs.get(s.charAt(right)).intValue()==
                        cur.get(s.charAt(right)).intValue()
                ){
                    match++;
                }
            }
            right++;
            while(match==required){ //当右侧找到了边界,需要找左侧边界
                if(right-left<minLen){
                    start=left;
                    minLen=right-left;
                }
                if(needs.containsKey(s.charAt(left))){
                    cur.put(s.charAt(left),cur.get(s.charAt(left))-1); //移出window
                    if(cur.get(s.charAt(left)).intValue()<needs.get(s.charAt(left)).intValue()){
                        match--;
                    }
                }
                left++; //当发生不匹配时，选择left++，以免重复计数
            }
        }
        return minLen == Integer.MAX_VALUE ?
                "" : s.substring(start, start+minLen);
    }
}
